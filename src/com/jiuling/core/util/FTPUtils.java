package com.jiuling.core.util;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoader;

/**
 * FTP工具类
 * 
 * @author YANGXQ
 *
 */
public class FTPUtils {

	protected static Logger logger = Logger.getLogger(FTPUtils.class.getName());

	/**
	 * 获取研判系统配置的ftp连接
	 * 
	 * @return
	 */
	public FTPClient getJudgeFTP() {
		FTPClient ftp = getConnectionFTP(PropertiesUtil.getFtpPackey("file.service"), Integer.parseInt(PropertiesUtil.getFtpPackey("file.service.port")),
				PropertiesUtil.getFtpPackey("file.service.uid"), PropertiesUtil.getFtpPackey("file.service.pwd"));

		return ftp;
	}

	/**
	 * 获取研判系统配置的ftp连接
	 * 
	 * @return
	 */
	public FTPClient getChatFTP() {
		FTPClient ftp = getConnectionFTP(PropertiesUtil.getFtpPackey("file.service"), Integer.parseInt(PropertiesUtil.getFtpPackey("file.service.port")),
				PropertiesUtil.getFtpPackey("file.service.uid"), PropertiesUtil.getFtpPackey("file.service.pwd"));
		return ftp;
	}

	/**
	 * 获取图帧ftp连接
	 * 
	 * @return
	 */
	public FTPClient getVideoFTP() {
		FTPClient ocxftp = getConnectionFTP(PropertiesUtil.getFtpPackey("video.service"), Integer.parseInt(PropertiesUtil.getFtpPackey("ocx.file.service.port")),
				PropertiesUtil.getFtpPackey("video.service.uid"), PropertiesUtil.getFtpPackey("video.service.pwd"));

		return ocxftp;
	}
	
	/**
	 * 获取图帧从服务器ftp连接
	 * 
	 * @return
	 */
	public FTPClient getOcxVideoFTP(String slaveIp) {
		FTPClient ocxftp = getConnectionFTP(slaveIp, Integer.parseInt(PropertiesUtil.getFtpPackey("ocx.file.service.port")),
				PropertiesUtil.getFtpPackey("video.service.uid"), PropertiesUtil.getFtpPackey("video.service.pwd"));

		return ocxftp;
	}

	/**
	 * 获取图帧从服务器ftp连接
	 * 
	 * @return
	 */
	public FTPClient getSlaveVideoFTP(String slaveIp) {
		FTPClient ocxftp = getConnectionFTP(slaveIp, Integer.parseInt(PropertiesUtil.getFtpPackey("ocx.file.service.port")), PropertiesUtil.getFtpPackey("video.service.uid"),
				PropertiesUtil.getFtpPackey("video.service.pwd"));

		return ocxftp;
	}

	/**
	 * 通过服务器IP获取图帧ftp连接
	 * 
	 * @return
	 */
	public FTPClient getVideoFTPBySlaveIP(String slaveIp) {
		FTPClient ocxftp = getConnectionFTP(slaveIp, Integer.parseInt(PropertiesUtil.getFtpPackey("ocx.file.service.port")), PropertiesUtil.getFtpPackey("video.service.uid"),
				PropertiesUtil.getFtpPackey("video.service.pwd"));

		return ocxftp;
	}

	/**
	 * 获得连接-FTP方式
	 * 
	 * @param hostname
	 *            FTP服务器地址
	 * @param port
	 *            FTP服务器端口
	 * @param username
	 *            FTP登录用户名
	 * @param password
	 *            FTP登录密码
	 * @return FTPClient
	 */
	public FTPClient getConnectionFTP(String hostName, int port, String userName, String passWord) {
		// 创建FTPClient对象
		FTPClient ftp = new FTPClient();
		try {
			// 连接FTP服务器
			ftp.connect(hostName, port);
			// 下面三行代码必须要，而且不能改变编码格式，否则不能正确下载中文文件
			ftp.setControlEncoding("GBK");
			FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);
			conf.setServerLanguageCode("zh");
			// 登录ftp
			ftp.login(userName, passWord);
			if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
				ftp.disconnect();
				logger.debug("FTPUtil getConnectionFTP method id =>连接服务器失败");
			}
			logger.debug("FTPUtil getConnectionFTP method id =>登陆服务器成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ftp;
	}

	/**
	 * 关闭连接-FTP方式
	 * 
	 * @param ftp
	 *            FTPClient对象
	 * @return boolean
	 */
	public boolean closeFTP(FTPClient ftp) {
		if (ftp.isConnected()) {
			try {
				ftp.disconnect();
				logger.debug("FTPUtil closeFTP method id =>ftp已经关闭");
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * 上传文件-FTP方式
	 * 
	 * @param ftp
	 *            FTPClient对象
	 * @param path
	 *            FTP服务器上传地址
	 * @param filename
	 *            本地文件路径
	 * @param inputStream
	 *            输入流
	 * @return boolean
	 */
	public boolean uploadFile(String path, String fileName, InputStream inputStream) {
		boolean success = false;
		try {
			FTPClient ftp = getJudgeFTP();

			logger.debug("------------ftpPath =>>" + path);
			boolean flag = false;
			// 转到指定上传目录
			String[] pathStr = path.split("/");
			for (int i = 0; i < pathStr.length; i++) {
				if (!pathStr[i].equals("")) {
					String newpath = new String(pathStr[i].getBytes(), FTP.DEFAULT_CONTROL_ENCODING);
					flag = ftp.changeWorkingDirectory(newpath);// 转移到FTP服务器目录
				}
			}// 转移到FTP服务器目录
			ftp.enterLocalPassiveMode();// 转移到指定FTP服务器目录
			logger.debug("------------changeWorkingDirectory - > flag =>>" + flag);
			// FTPFile[] fs = ftp.listFiles();//得到目录的相应文件列表 //deleted by pengmd
			// fileName = FTPUtil.changeName(fileName, fs); //deleted by pengmd
			// fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
			// path = new String(path.getBytes("UTF-8"), "ISO-8859-1");

			// 设置缓冲大小200M
			ftp.setBufferSize(204800);
			// 将上传文件存储到指定目录
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			logger.debug("------------fileName =>>" + fileName);
			ftp.enterLocalPassiveMode();
			logger.debug("------------upload begin =>>" + System.currentTimeMillis());
			// 如果缺省该句 传输txt正常 但图片和其他格式的文件传输出现乱码
			flag = ftp.storeFile(fileName, inputStream);
			logger.debug("------------upload end =>>" + System.currentTimeMillis());
			// 关闭输入流
			inputStream.close();
			// 退出ftp
			ftp.logout();
			// 表示上传成功
			success = true;
			logger.info("FTPUtil uploadFile method id =>上传成功。。。。。");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("FTPUtil uploadFile method 上传失败！" + e.toString());
		}
		return success;
	}

	/**
	 * 上传文件图侦-FTP方式
	 * 
	 * @param ftp
	 *            FTPClient对象
	 * @param path
	 *            FTP服务器上传地址
	 * @param filename
	 *            本地文件路径
	 * @param inputStream
	 *            输入流
	 * @return boolean
	 */
	public boolean uploadPic(FTPClient ftp, String path, String fileName, InputStream inputStream) {
		boolean success = false;
		try {
			/*
			 * ftp.changeWorkingDirectory(path);//转移到指定FTP服务器目录 FTPFile[] fs =
			 * ftp.listFiles();//得到目录的相应文件列表 if(isFileExist(fileName,fs)){
			 * deleteFile(ftp, path, fileName); }
			 */
			makeDir(path);
			String[] pathStr = path.split("/");
			for (int i = 0; i < pathStr.length; i++) {
				if (!pathStr[i].equals("")) {
					String newpath = new String(pathStr[i].getBytes(), FTP.DEFAULT_CONTROL_ENCODING);
					ftp.changeWorkingDirectory(newpath);// 转移到FTP服务器目录
				}
			}// 转移到FTP服务器目录
			
			fileName = new String(fileName.getBytes("GBK"), "ISO-8859-1");
			if (StringUtils.isNotEmptyString(path)) {
				path = new String(path.getBytes("GBK"), "ISO-8859-1");
			}
			// 设置缓冲大小1024 =1M
			ftp.setBufferSize(204800); // 200M
			// 转到指定上传目录
			// ftp.changeWorkingDirectory(path);
			// 将上传文件存储到指定目录
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			ftp.enterLocalPassiveMode();
			// 如果缺省该句 传输txt正常 但图片和其他格式的文件传输出现乱码
			ftp.storeFile(fileName, inputStream);
			// 关闭输入流
			inputStream.close();
			// 退出ftp
			ftp.logout();
			// 表示上传成功
			success = true;

			logger.info("FTPUtil uploadFile method id =>上传成功。。。。。");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("FTPUtil uploadFile method 上传失败！" + e.toString());
		}
		return success;
	}

	/**
	 * 上传文件-FTP方式
	 * 
	 * @param ftp
	 *            FTPClient对象
	 * @param path
	 *            FTP服务器上传地址
	 * @param filename
	 *            本地文件路径
	 * @param inputStream
	 *            输入流
	 * @return boolean
	 */
	public boolean uploadFileCs2vj(FTPClient ftp, String path, String fileName, InputStream inputStream) {
		boolean success = false;
		try {

			logger.debug("------------ftpPath =>>" + path);
			// 转到指定上传目录
			boolean flag = ftp.changeWorkingDirectory(path);// 转移到指定FTP服务器目录
			logger.debug("------------changeWorkingDirectory - > flag =>>" + flag);
			// FTPFile[] fs = ftp.listFiles();//得到目录的相应文件列表 //deleted by pengmd
			// fileName = FTPUtil.changeName(fileName, fs); //deleted by pengmd
			// fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
			// path = new String(path.getBytes("UTF-8"), "ISO-8859-1");

			// 设置缓冲大小200M
			ftp.setBufferSize(204800);
			// 将上传文件存储到指定目录
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			logger.debug("------------fileName =>>" + fileName);
			ftp.enterLocalPassiveMode();
			logger.debug("------------upload begin =>>" + System.currentTimeMillis());
			// 如果缺省该句 传输txt正常 但图片和其他格式的文件传输出现乱码
			flag = ftp.storeFile(fileName, inputStream);
			logger.debug("------------upload end =>>" + System.currentTimeMillis());
			// 关闭输入流
			inputStream.close();
			// 退出ftp
			ftp.logout();
			// 表示上传成功
			success = true;
			logger.info("FTPUtil uploadFile method id =>上传成功。。。。。");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("FTPUtil uploadFile method 上传失败！" + e.toString());
		}
		return success;
	}

	/**
	 * 删除文件-FTP方式
	 * 
	 * @param ftp
	 *            FTPClient对象
	 * @param path
	 *            FTP服务器上传地址
	 * @param filename
	 *            FTP服务器上要删除的文件名
	 * @return
	 */
	public boolean deleteFile(FTPClient ftp, String path, String fileName) {
		boolean success = false;
		try {
			changeWorkingDirectory(ftp, path);// 转移到指定FTP服务器目录
			fileName = new String(fileName.getBytes("GBK"), "ISO-8859-1");
			// path = new String(path.getBytes("GBK"), "ISO-8859-1");
			ftp.deleteFile(fileName);
			// ftp.logout();
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	public boolean changeWorkingDirectory(FTPClient ftp, String path) {
		boolean flag = false;
		String[] aryStr = path.split("/");
		for (int i = 0; i < aryStr.length; i++) {
			if (!aryStr[i].equals("")) {
				try {
					String newpath = new String(aryStr[i].getBytes(), FTP.DEFAULT_CONTROL_ENCODING);
					flag = ftp.changeWorkingDirectory(newpath);
				} catch (IOException e) {
					flag = false;
				}
			}
		}
		return flag;
	}

	/**
	 * 获取本地下载后文件
	 * 
	 * @param ftp
	 *            FTPClient对象
	 * @param path
	 *            FTP服务器上传地址
	 * @param fileName
	 *            文件名
	 * @param localPath
	 *            本地临时路径
	 * @return boolean
	 */
	public File getDownFile(FTPClient ftp, String path, String fileName) {
		String root = getRootPath("/");

		File localFile = new File(root + "\\" + path + "\\" + fileName);
		// 本地是否该存在
		if (!localFile.exists()) {
			// 先判断文件夹是否存在
			if (!(new File(root + "\\" + path + "\\")).exists()) {
				new File(root + "\\" + path + "\\").mkdirs();
			}
			// 先下载到本地
			downFile(ftp, path, fileName);
			// convertFlvFile(ftp,path,fileName);
			localFile = new File(root + "\\" + path + "\\" + fileName);
		}
		return localFile;

	}

	/**
	 * 下载文件-FTP方式
	 * 
	 * @param ftp
	 *            FTPClient对象
	 * @param path
	 *            FTP服务器上传地址
	 * @param localPath
	 *            本地临时路径
	 * @param fileName
	 *            文件名
	 * @return boolean
	 */
	public boolean downFile(FTPClient ftp, String path, String fileName) {
		boolean success = false;
		String root = getRootPath("/");
		try {
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			String[] pathStr = path.split("/");
			for (int i = 0; i < pathStr.length; i++) {
				if (!pathStr[i].equals("")) {
					String newpath = new String(pathStr[i].getBytes(), FTP.DEFAULT_CONTROL_ENCODING);
					ftp.changeWorkingDirectory(newpath);// 转移到FTP服务器目录
				}
			}// 转移到FTP服务器目录
			ftp.enterLocalPassiveMode();
			FTPFile[] fs = ftp.listFiles(); // 得到目录的相应文件列表

			for (FTPFile ff : fs) {
				String ftpfileName = new String(ff.getName().getBytes("GBK"), "UTF-8");
				if (ftpfileName.equals(fileName)) {
					File localFile = new File(root + "\\" + path + "\\" + fileName);
					String dirPath = localFile.getParent();
					File file = new File(dirPath);
					if (!file.exists() && !file.isDirectory()) {
						file.mkdirs();
					}
					OutputStream outputStream = new FileOutputStream(localFile);
					// 设置缓冲大小1024 =1M
					ftp.setBufferSize(204800); // 200M
					// 将文件保存到输出流outputStream中
					ftp.retrieveFile(new String(fileName.getBytes("GBK"), "ISO-8859-1"), outputStream);
					outputStream.flush();
					outputStream.close();
					System.out.println("下载成功");
				}
			}
			ftp.logout();
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	/**
	 * 下载文件-FTP方式
	 * 
	 * @param ftp
	 *            FTPClient对象
	 * @param path
	 *            FTP服务器上传地址
	 * @param localPath
	 *            本地临时路径
	 * @param fileName
	 *            文件名
	 * @return boolean
	 */
	public boolean convertFlvFile(FTPClient ftp, String path, String fileName) {
		boolean success = false;
		String root = getRootPath("/");
		try {
			String inputFilePath = root + path + "\\" + fileName;
			String fileName2 = fileName.substring(0, fileName.lastIndexOf("."));
			String outputFilePath = root + path + "\\" + fileName2 + ".mp4";
			ConvertVideo.process(inputFilePath, outputFilePath);
			File vFile = new File(outputFilePath);
			FileInputStream iss = new FileInputStream(vFile);
			uploadFile(path, fileName2 + ".mp4", iss);
			ftp.logout();
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	/**
	 * 下载文件-FTP方式
	 * 
	 * @param ftp
	 *            FTP服务器上传地址
	 * @param path
	 *            本地临时路径
	 * @param fileName
	 *            文件名
	 * @param newFileName
	 *            重命名文件名
	 * @return boolean
	 */
	public boolean downFile(FTPClient ftp, String path, String fileName, String newFileName) {
		boolean success = false;
		String root = getRootPath("/");
		String ocx = PropertiesUtil.getFtpPackey("ocx.upfile.service.path");
		try {
			ftp.changeWorkingDirectory(path);// 转移到FTP服务器目录
			ftp.enterLocalPassiveMode();
			FTPFile[] fs = ftp.listFiles(); // 得到目录的相应文件列表

			for (FTPFile ff : fs) {
				if (ff.getName().equals(fileName)) {
					File localFile = new File(root + "\\" + ocx + "\\" + newFileName);
					if (!localFile.exists()) {
						new File(root + "\\" + ocx + "\\").mkdirs();
					}
					OutputStream outputStream = new FileOutputStream(localFile);
					// 设置缓冲大小1024 =1M
					ftp.setBufferSize(204800); // 200M
					// 将文件保存到输出流outputStream中
					ftp.retrieveFile(new String(fileName.getBytes("GBK"), "ISO-8859-1"), outputStream);
					outputStream.flush();
					outputStream.close();
					System.out.println("下载成功");
					break;
				}
			}
			ftp.logout();
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	/**
	 * 下载文件
	 * 
	 * @param ftp
	 * @param path
	 * @param fileName
	 * @param outputStream
	 * @return
	 */
	public boolean downloadFile(FTPClient ftp, String path, String fileName, OutputStream outputStream) {
		boolean success = false;
		try {
			ftp.changeWorkingDirectory(path);// 转移到FTP服务器目录
			ftp.enterLocalPassiveMode();
			// 2015-11-17 生产紧急bug修复 upd by pengmd
			FTPFile[] fs = ftp.listFiles(); // 得到目录的相应文件列表
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			for (FTPFile ff : fs) {
				if (ff.getName().equals(fileName)) {
					// 将文件保存到输出流outputStream中
					ftp.retrieveFile(new String(ff.getName().getBytes("GBK"), "ISO-8859-1"), outputStream);
					outputStream.flush();
					outputStream.close();
				}
			}
			ftp.logout();
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	/**
	 * 判断是否有重名文件
	 * 
	 * @param fileName
	 * @param fs
	 * @return
	 */
	public static boolean isFileExist(String fileName, FTPFile[] fs) {
		for (int i = 0; i < fs.length; i++) {
			FTPFile ff = fs[i];
			if (ff.getName().equals(fileName)) {
				return true; // 如果存在返回 正确信号
			}
		}
		return false; // 如果不存在返回错误信号
	}

	/**
	 * 根据重名判断的结果 生成新的文件的名称
	 * 
	 * @param fileName
	 * @param fs
	 * @return
	 */
	public static String changeName(String fileName, FTPFile[] fs) {
		int n = 0;
		// fileName = fileName.append(fileName);
		while (isFileExist(fileName.toString(), fs)) {
			n++;
			String a = "[" + n + "]";
			int b = fileName.lastIndexOf(".");// 最后一出现小数点的位置
			int c = fileName.lastIndexOf("[");// 最后一次"["出现的位置
			if (c < 0) {
				c = b;
			}
			StringBuffer name = new StringBuffer(fileName.substring(0, c));// 文件的名字
			StringBuffer suffix = new StringBuffer(fileName.substring(b + 1));// 后缀的名称
			fileName = name.append(a) + "." + suffix;
		}
		return fileName.toString();
	}

	public String[] download(String fileName, String urlStr) throws Exception {
		String[] result = new String[2];
		String ctxPath = FTPUtils.getRootPath("") + "\\" + "ftp\\";
		URL url = new URL(this.getEncodeUrl(urlStr)); // 必须要转码才能获取
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)"); // 防止屏蔽程序抓取而返回403错误
		InputStream inputStream = conn.getInputStream(); // 得到输入流
		BufferedInputStream bi = new BufferedInputStream(inputStream);
		File saveDir = new File(ctxPath); // 文件保存位置
		if (!saveDir.exists()) {
			saveDir.mkdir();
		}
		String filePath = saveDir + File.separator + fileName;// 最终文件保存位置
		result[0] = filePath;// 返回最终保存本地位置
		File file = new File(filePath);
		FileOutputStream bs = new FileOutputStream(file);
		result[1] = conn.getContentLength() / 1024 + "";// 返回文件大小
		byte[] by = new byte[1024];
		int len = 0;
		while ((len = bi.read(by)) != -1) {
			bs.write(by, 0, len);
		}
		bs.close();
		bi.close();
		return result;
	}

	public void downloadUrlFile(String fileName, String urlStr) throws Exception {
		URL urlUrl = new URL(urlStr);
		HttpURLConnection urlConn = (HttpURLConnection) urlUrl.openConnection();
		urlConn.setRequestMethod("GET");
		urlConn.setRequestProperty("accept", "*/*");
		urlConn.setRequestProperty("connection", "Keep-Alive");

		if (urlConn.getResponseCode() == 200) {
			System.out.println("COME IN");
			DataInputStream fis = new DataInputStream(urlConn.getInputStream());
			String ctxPath = FTPUtils.getRootPath("") + "\\" + "ftp\\";
			File saveDir = new File(ctxPath); // 文件保存位置
			if (!saveDir.exists()) {
				saveDir.mkdir();
			}
			String filePath = saveDir + File.separator + fileName;// 最终文件保存位置
			// result[0]=filePath;//返回最终保存本地位置
			File file = new File(filePath);
			FileOutputStream fos = new FileOutputStream(file);
			byte[] buffer = new byte[1024];
			int length = 0;
			while ((length = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, length);
			}
			fis.close();
			fos.close();
		} else {
			throw new RuntimeException(" responseCode is not 200 ... ");
		}
	}

	public String getEncodeUrl(String str) throws UnsupportedEncodingException {
		String head = str.substring(0, str.lastIndexOf("/") + 1);
		String param = str.substring(str.lastIndexOf("/") + 1, str.length());
		String url = head + URLEncoder.encode(param, "UTF-8");
		url = url.replace("+", "%20");// 空格会转换成+号，替换空格
		// System.out.println("url--"+url);
		return url;
	}

	/**
	 * @Title: checkDiskSpace
	 * @Description: 检测磁盘空间使用情况
	 * @return -1 - 未设置预警值，跳过检验返回 0 - 磁盘空间使用率未达到预警值 1 - 磁盘空间使用率达到预警值（即快满了） 2 -
	 *         磁盘空间已满
	 * @ReturnType: Integer
	 */
	public static Integer checkDiskSpace() {

		String warningValue = null;
		try {
			warningValue = PropertiesUtil.getFtpPackey("Disk_Space_WarningValue");
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (null == warningValue || "".equals(warningValue)) {
			return -1;
		}
		Double spaceUsage = Double.parseDouble(warningValue);
		logger.debug("检查磁盘空间大小");
		Integer result = 0;
		String root = getRootPath("/");// 获取项目所在物理路径
		String diskName = root.substring(0, 3);// 获取盘符
		logger.debug("检查磁盘：" + diskName);
		File[] roots = File.listRoots();// 获取磁盘分区列表
		for (File file : roots) {
			if (!file.getPath().equals(diskName))
				continue;
			Double usedSpace = (file.getTotalSpace() - file.getUsableSpace()) / (double) file.getTotalSpace();
			logger.debug("磁盘" + file.getPath() + "使用率：" + usedSpace);
			if (usedSpace > spaceUsage) {
				result = 1;
				logger.debug("磁盘" + file.getPath() + "使用率已超过预警值");
			} else if (usedSpace > 0.98) {
				result = 2;
				logger.debug("磁盘" + file.getPath() + "已满");
			}
		}
		return result;
	}

	/**
	 * 获取获取项目所在物理路径（根目录）
	 * 
	 * @param arg
	 * @return
	 */
	public static String getRootPath(String arg) {
		return ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath(arg);
	}

	/**
	 * 从ocxftp服务器同步到系统ftp服务器
	 * 
	 * @param ocxfileName
	 * @param ocxfilePath
	 */
	public void copyFtpFile(String ocxfileName, String ocxfilePath, String newFileName) {

		FTPClient ftpfrom = getVideoFTP();

		// 从下载到本地目录
		downFile(ftpfrom, ocxfilePath, ocxfileName, newFileName);
		// 上传到系统对应ftp
		String ocx = PropertiesUtil.getFtpPackey("ocx.upfile.service.path");
		File localFile = new File(getRootPath("/") + "\\" + ocx + "\\" + newFileName);
		try {
			InputStream inputStream = new FileInputStream(localFile);
			uploadFile(ocx, newFileName, inputStream);
			// localFile.delete();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public boolean makeDir(String path) {
		boolean success = false;
		String[] aryStr = path.split("/");
		try {
			FTPClient ftp = getJudgeFTP();
			ftp.changeWorkingDirectory(aryStr[1]);
			for (int i = 2; i < aryStr.length; i++) {
				success = ftp.makeDirectory(aryStr[i]);
				String newpath = new String(aryStr[i].getBytes(), FTP.DEFAULT_CONTROL_ENCODING);
				ftp.changeWorkingDirectory(newpath);
			}
			ftp.logout();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	public static String analysisCategory(String category) {
		StringBuffer path = new StringBuffer();
		path.append("new_");
		if (!category.substring(4, 6).equals("00")) {
			for (int i = 0; i < 6; i++) {
				path.append(category.substring(0, i + 1));
				for (int j = 0; j < 5 - i; j++) {
					path.append("0");
				}
				path.append("/");
				if (i > 0) {
					++i;
				}
			}
		} else if (!category.substring(2, 4).equals("00")) {
			for (int i = 0; i < 4; i++) {
				path.append(category.substring(0, i + 1));
				for (int j = 0; j < 5 - i; j++) {
					path.append("0");
				}
				path.append("/");
				if (i > 0) {
					++i;
				}
			}
		} else if (!category.substring(1, 2).equals("0")) {
			for (int i = 0; i < 2; i++) {
				path.append(category.substring(0, i + 1));
				for (int j = 0; j < 5 - i; j++) {
					path.append("0");
				}
				path.append("/");
				if (i > 0) {
					++i;
				}
			}
		} else {
			path.append(category + "/");
		}
		return path.toString();
	}
	
	/**
	 * 保存base64编码图片至ftp
	 * @param base64Str
	 * @param fileName
	 * @param filepath
	 * @return
	 */
	public String saveBase64ImgToFtp(String base64Str,String fileName,String filepath){
        try {
            String root = getRootPath("/");
            String saveDir = root + "\\base64\\";
            
            //如果文件夹不存在 创建
            File dir = new File(saveDir);
            if(!dir.exists()){
            	dir.mkdirs();
            }
            
            //生成图片
            ImageUtils.str2Image(base64Str, saveDir + fileName);
            
            File file = new File(saveDir + fileName);
            InputStream inputStream = new FileInputStream(file);
            String saveftpdir = PropertiesUtil.getFtpPackey("clue.service.path") + filepath;
            
            makeDir(saveftpdir);
            
            uploadFile(saveftpdir, fileName, inputStream);
            
            return saveftpdir + fileName;
        }catch(Exception e){
        	
        }
        return null;
	}

	/**
	 * 
	 * @param args
	 * 
	 * @throws FileNotFoundException
	 * 
	 *             测试程序
	 * 
	 */
	public static void main(String[] args) throws FileNotFoundException {

	}

}
