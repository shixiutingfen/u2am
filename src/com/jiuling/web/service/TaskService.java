package com.jiuling.web.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.jiuling.web.model.VsdTask;

/**
 * 缓存项加载接口
 * @author Administrator
 *
 */
public interface TaskService {
	/**
	 * 上传视频至图侦服务器  集群
	 * @param file 文件
	 * @param cameraId  摄像头id
	 * @param slaveIp 从服务器ip
	 * @return String[0] 1:成功  String[1]描述 ,String[2]上传后的ctrunitfile id 
	 * @throws Exception
	 */
	public String[] uploadFile(MultipartFile file,Map<String,Object> params);
	
	void addTask(VsdTask task);
	
}
