package com.jiuling.web.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jiuling.core.util.ContxtUtils;
import com.jiuling.core.util.DateTimeUtils;
import com.jiuling.core.util.FTPUtils;
import com.jiuling.core.util.PropertiesUtil;
import com.jiuling.core.util.RandomUtils;
import com.jiuling.web.dao.TaskFileMapper;
import com.jiuling.web.dao.VsdTaskMapper;
import com.jiuling.web.model.SysUser;
import com.jiuling.web.model.TaskFile;
import com.jiuling.web.model.VsdTask;
import com.jiuling.web.service.TaskService;
@Service
public class TaskServieImpl implements TaskService{
	Logger log = Logger.getLogger(TaskServieImpl.class);
	@Resource
	private TaskFileMapper taskFileMapper;
	@Resource
	private VsdTaskMapper vasTaskMapper;
	
	public String[] uploadFile(MultipartFile file, Map<String, Object> params) {
		String[] result = new String[3];
		// 默认返回成功
		result[0] = "1";
		result[1] = "success";
		// 检查磁盘容量
		Integer status = FTPUtils.checkDiskSpace();
		switch (status) {
		case -1:
			result[0] = "1";
			result[1] = "请注意，未设置磁盘空间预警值！";
			break;
		case 1:
			result[0] = "1";
			result[1] = "请注意，磁盘空间使用率达到预警值（即快满了）";
			break;
		case 2:
			result[0] = "0";
			result[1] = "磁盘空间已满！";
			break;
		}

		// 如果磁盘空间满足条件，则上传
		if (!"0".equals(result[0])) {
			// 视频上传转码，生成文件记录
			result = saveFileToTransCodingFtp(file,params);
		}

		return result;
	}
	
	/**
	 * @param file 文件
	 * @param cameraId 点位id
	 * @param slaveIp 从服务器IP
	 * @return 返回数组 result[0] 状态：1 为成功 ，result[1] 返回的描述信息 ，result[2]CtrlUnitFile 记录的主键ID
	 * @throws Exception
	 */
	private String[] saveFileToTransCodingFtp(MultipartFile file, Map<String,Object> params) {
		String[] result = new String[3];
		// 默认返回成功
		result[0] = "1";
		result[1] = "success";
		// 工程目录
		String root = FTPUtils.getRootPath("/");
		String resPath = PropertiesUtil.getFtpPackey("file.service.path")+ "/"+DateTimeUtils.getNowFolder(1)+ "/"+DateTimeUtils.getNowFolder(2) 
		+ "/"+DateTimeUtils.getNowFolder(3);
		String fileOriginalName = file.getOriginalFilename();
		try {
			// 文件后缀
			String suffix = "";
			if (fileOriginalName.contains(".")) {
				suffix = fileOriginalName.substring(fileOriginalName.lastIndexOf('.'), fileOriginalName.length());
			}
			String fileName = RandomUtils.get24TimeRandom() + suffix;
			String filePath = root + "\\" + resPath + "\\"+DateTimeUtils.getNowFolder(1)+ "\\"+DateTimeUtils.getNowFolder(2) 
			+ "\\"+DateTimeUtils.getNowFolder(3)+ fileName;
			String url = resPath + "/" + fileName;
			File urlFile = new File(filePath);
			if (!urlFile.getParentFile().exists()) {
				urlFile.mkdirs();
			}
			// 建立连接
			FTPUtils fu = new FTPUtils();
			// 传到指定临时目录
			file.transferTo(urlFile);
			String slaveIp = "";
			// 上传到转码服务器ftp
			FTPClient judgeftp = fu.getJudgeFTP();
			FileInputStream vedioiss = new FileInputStream(urlFile);
			boolean uploadFtpFlag = fu.uploadPic(judgeftp, resPath, fileName, vedioiss);
			urlFile.delete();
			// 是否上传成功
			if (uploadFtpFlag) {
				// 2 新增数据库记录
				TaskFile orgfile = new TaskFile();
				String cameraMediaId = RandomUtils.get18TimeRandom();
				orgfile.setId(Long.valueOf(cameraMediaId));
				result[2] = cameraMediaId;
				SysUser user = ContxtUtils.getUserSession();
				Long userId = user.getUserId();
				orgfile.setCreateUerid(userId);
				orgfile.setCreateTime(new Date());
				orgfile.setFileNameafterupload(fileName);
				orgfile.setFilePathafterupload(url);
				orgfile.setFileName(fileOriginalName);
				orgfile.setFileSuffix(suffix);
				orgfile.setSlaveIp(slaveIp);

				// 文件大小的换算，图片用kb，视频用mb，原本是byte
				if (file.getContentType().contains("image")) {
					float a = file.getSize() * 100 / 1024;
					orgfile.setFileSize(String.valueOf(Math.round(a) / 100.0));
				} else {
					float b = file.getSize() * 100 / 1048576;
					orgfile.setFileSize(String.valueOf(Math.round(b) / 100.0));
				}
				taskFileMapper.insertSelective(orgfile);
			}
		} catch (Exception e) {
			//e.printStackTrace();
			result[0] = "0";
			result[1] = "文件转码失败！";
			log.info("saveFileToTransCodingFtp -- >> " + e.getMessage());
			return result;
		}
		return result;
	}

	public void addTask(VsdTask task) {
		vasTaskMapper.insert(task);
	}
}
