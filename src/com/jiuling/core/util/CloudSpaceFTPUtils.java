package com.jiuling.core.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoader;

/**
 * 云空间ftp服务器工具类
 * @author fanxiaoming
 *
 */
public class CloudSpaceFTPUtils {
	
	protected static Logger logger = Logger.getLogger(CloudSpaceFTPUtils.class
			.getName());

	/**
	 * 获取当前系统配置的ftp连接
	 * @return
	 */
	public static FTPClient getCloudSpaceFTP()
	{
	    FTPClient ftp = getConnectionFTP(PropertiesUtil.getFtpPackey("cloudspace.file.service"), 
            Integer.parseInt(PropertiesUtil.getFtpPackey("cloudspace.file.service.port")),
            PropertiesUtil.getFtpPackey("cloudspace.file.service.uid"), 
            PropertiesUtil.getFtpPackey("cloudspace.file.service.pwd"));
	    
	    return ftp;
	}
	
	 /** 
     * 获得连接-FTP方式 
     * @param hostname FTP服务器地址 
     * @param port FTP服务器端口 
     * @param username FTP登录用户名 
     * @param password FTP登录密码 
     * @return FTPClient 
     */  
    public static FTPClient getConnectionFTP(String hostName, int port, String userName, String passWord) {  
        //创建FTPClient对象  
        FTPClient ftp = new FTPClient();  
        try {  
            //连接FTP服务器  
            ftp.connect(hostName, port);  
            //下面三行代码必须要，而且不能改变编码格式，否则不能正确下载中文文件  
            ftp.setControlEncoding("GBK");  
            FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);  
            conf.setServerLanguageCode("zh");  
            //登录ftp  
            ftp.login(userName, passWord); 
            //System.out.println(ftp.getRemoteAddress());
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
     * @param ftp FTPClient对象 
     * @return boolean 
     */  
    public static void closeFTP(FTPClient ftp) {  
        if (ftp.isConnected()) {  
            try {  
                ftp.disconnect();  
                logger.debug("FTPUtil closeFTP method id =>ftp已经关闭");
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
    }  
	
    /** 
     * 上传文件-FTP方式 
     * @param ftp FTPClient对象 
     * @param path FTP服务器上传地址 
     * @param filename 本地文件路径 
     * @param inputStream 输入流 
     * @return boolean 
     */  
    public static void uploadFile(String path, String fileName, InputStream inputStream) {  
        try {  
        	FTPClient ftp = getCloudSpaceFTP();
    		
        	logger.debug("------------ftpPath =>>" + path);
        	boolean flag = false;
        	//转到指定上传目录  
        	String[] pathStr = path.split("/");
        	for(int i=0;i<pathStr.length;i++){
        		if(!pathStr[i].equals("")){
					String newpath = new String(pathStr[i].getBytes(),FTP.DEFAULT_CONTROL_ENCODING);
        			flag = ftp.changeWorkingDirectory(newpath);//转移到FTP服务器目录 
        		}
        	}//转移到FTP服务器目录  
            ftp.enterLocalPassiveMode();//转移到指定FTP服务器目录  
            logger.debug("------------changeWorkingDirectory - > flag =>>" + flag);
            //FTPFile[] fs = ftp.listFiles();//得到目录的相应文件列表  //deleted by pengmd
            //fileName = FTPUtil.changeName(fileName, fs);    //deleted by pengmd
            //fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");  
            //path = new String(path.getBytes("UTF-8"), "ISO-8859-1");  
           
            //设置缓冲大小200M
            ftp.setBufferSize(204800); 
            //将上传文件存储到指定目录  
            ftp.setFileType(FTP.BINARY_FILE_TYPE); 
            logger.debug("------------fileName =>>" + fileName);
            ftp.enterLocalPassiveMode();
            logger.debug("------------upload begin =>>" + System.currentTimeMillis());
            //如果缺省该句 传输txt正常 但图片和其他格式的文件传输出现乱码  
            flag = ftp.storeFile(fileName, inputStream); 
            logger.debug("------------upload end =>>" + System.currentTimeMillis());
            //关闭输入流  
            inputStream.close();  
            //退出ftp  
            ftp.logout();  
            //表示上传成功  
            logger.info("FTPUtil uploadFile method id =>上传成功。。。。。");
        } catch (Exception e) {  
            e.printStackTrace(); 
            logger.info("FTPUtil uploadFile method 上传失败！" + e.toString());
        }  
    }  
    
    /** 
     * 删除单个文件-FTP方式 
     * @param ftp FTPClient对象 
     * @param path FTP服务器上传地址 
     * @param filename FTP服务器上要删除的文件名 
     * @return 
     */  
    public static void deleteFile(String path, String fileName) {  
        try {  
        	FTPClient ftp = getCloudSpaceFTP();
            changeWorkingDirectory(ftp,path);//转移到指定FTP服务器目录  
            fileName = new String(fileName.getBytes("GBK"), "ISO-8859-1");  
           // path = new String(path.getBytes("GBK"), "ISO-8859-1");  
            ftp.deleteFile(fileName);  
//            ftp.logout();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
    
    /** 
     * 删除文件夹及所有子文件-FTP方式 
     * @param ftp FTPClient对象 
     * @param path FTP服务器上传地址 
     * @return 
     */  
    public static void deleteDirectory(FTPClient ftp,String rootPath) {  
        try {  
        	FTPFile[] files = ftp.listFiles(rootPath);
            for(FTPFile f:files){  
                String path = rootPath+File.separator+f.getName();  
                if(f.isFile()){  
                    // 是文件就删除文件  
                	ftp.deleteFile(path);  
                }else if(f.isDirectory()){  
                	deleteDirectory(ftp,path);  
                }  
            }  
            // 每次删除文件夹以后就去查看该文件夹下面是否还有文件，没有就删除该空文件夹  
            FTPFile[] files2 = ftp.listFiles(rootPath);   
            if(files2.length==0){  
                ftp.removeDirectory(rootPath);  
            }
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
    
    /**
     * 转移到ftp服务器指定目录
     * @param ftp
     * @param path
     * @return
     */
    public static void changeWorkingDirectory(FTPClient ftp, String path){
    	String[] aryStr = path.split("/");
    	for(int i = 0; i < aryStr.length; i++){
    		if(!aryStr[i].equals("")){
    			try {
    				String newpath = new String(aryStr[i].getBytes(),
        					FTP.DEFAULT_CONTROL_ENCODING);
					ftp.changeWorkingDirectory(newpath);
				} catch (IOException e) {
					
				}
    		}
    	}
    }
    
    /** 
     *获取本地下载后文件
     * @param ftp FTPClient对象
     * @param path FTP服务器上传地址 
     * @param fileName 文件名 
     * @param localPath 本地临时路径 
     * @return boolean 
     */  
    public static File getDownFile(FTPClient ftp,String path, String fileName) {  
    	 String root = getRootPath("/");
    	 
    	 File localFile = new File(root + "\\" + path + "\\" + fileName);  
    	 //本地是否该存在
    	 if (!localFile.exists())
    	 {
    	     //先判断文件夹是否存在
             if (!(new File(root + "\\" + path+ "\\")).exists())
             {
                 new File(root + "\\" + path + "\\").mkdirs();
             }
        	  //先下载到本地
        	  downFile(ftp,path,fileName);
        	 // convertFlvFile(ftp,path,fileName);
        	  localFile = new File(root + "\\" + path + "\\" + fileName);  
    	 }
    	return localFile;  
    	
    } 
    
    /** 
     * 下载文件-FTP方式 
     * @param ftp FTPClient对象
     * @param path FTP服务器上传地址 
     * @param localPath 本地临时路径 
     * @param fileName 文件名 
     * @return boolean 
     */  
    public static void downFile(FTPClient ftp,String path, String fileName) {  
        String root = getRootPath("/");
        try {
        	ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
        	String[] pathStr = path.split("/");
        	for(int i=0;i<pathStr.length;i++){
        		if(!pathStr[i].equals("")){
					String newpath = new String(pathStr[i].getBytes(),FTP.DEFAULT_CONTROL_ENCODING);
        			ftp.changeWorkingDirectory(newpath);//转移到FTP服务器目录 
        		}
        	}//转移到FTP服务器目录  
            ftp.enterLocalPassiveMode();
            FTPFile[] fs = ftp.listFiles(); //得到目录的相应文件列表  
            
           for (FTPFile ff : fs) {
             String ftpfileName = new String(ff.getName().getBytes("GBK"),"UTF-8");          
                if (ftpfileName.equals(fileName)) {  
                    File localFile = new File(root + "\\" + path + "\\" + fileName);  
                   
                    OutputStream outputStream = new FileOutputStream(localFile);  
                    //设置缓冲大小1024 =1M   
                    ftp.setBufferSize(204800); //200M
                    //将文件保存到输出流outputStream中  
                    ftp.retrieveFile(new String(fileName.getBytes("GBK"), "ISO-8859-1"), outputStream);  
                    outputStream.flush();  
                    outputStream.close();  
                    System.out.println("下载成功,路径为："+localFile.getAbsolutePath());  
                }  
            }  
            ftp.logout();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }
    
    /**
     * 获取上传文件的大小
     * @return
     */
    public static Long getUploadFileSize(String[] fileArray){
    	Long sum = 0l;
    	for (String source : fileArray) {
    		if(source.startsWith("http:")){
    			URL url = null;
        		HttpURLConnection conn = null;
        		int state = -1;
        		try {
        			url = new URL(source);
        			conn = (HttpURLConnection) url.openConnection();
        			state = conn.getResponseCode();
        			if(state == 200){
        				sum+=conn.getContentLengthLong();
        			}
        		} catch (MalformedURLException e) {
        			e.printStackTrace();
        		} catch (IOException e) {
        			e.printStackTrace();
        		}finally{
        			conn.disconnect();
        		}
    		}else{
    			if(source.startsWith("/cloudspace")){
    				source = source.split("/cloudspace")[1];
    			}
    			String[] pathArray = source.split("/"); 
    			String fileName = pathArray[pathArray.length-1];
    			String filePath = source.split(fileName)[0];
    			
    			FTPUtils ft = new FTPUtils();
                FTPClient ftp = ft.getJudgeFTP();
                try {
                	ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
                	String[] pathStr = filePath.split("/");
                	for(int i=0;i<pathStr.length;i++){
                		if(!pathStr[i].equals("")){
        					String newpath = new String(pathStr[i].getBytes(),FTP.DEFAULT_CONTROL_ENCODING);
                			ftp.changeWorkingDirectory(newpath);//转移到FTP服务器目录 
                		}
                	}//转移到FTP服务器目录  
                    ftp.enterLocalPassiveMode();
                    FTPFile[] fs = ftp.listFiles(); //得到目录的相应文件列表  
                    
                    for (FTPFile ff : fs) {
                     String ftpfileName = new String(ff.getName().getBytes("GBK"),"UTF-8");          
                        if (ftpfileName.equals(fileName)) {  
                        	sum += ff.getSize();
                        	break;
                        }  
                    }
                } catch (Exception e) {  
                    e.printStackTrace();  
                }finally{
                	if(ftp.isConnected()){
                		try {
							ftp.logout();
						} catch (IOException e) {
							e.printStackTrace();
						}
                	}
                }
    		}
		}
    	return sum;
    }
    
    /**
     * 获取当前用户使用的空间大小
     *   {userid}/{cloudid}/{policeid}
     * @return
     */
    public static Long getFtpUsedSize(String path){
    	Long userSize = 0L;
    	userSize = loopPathFile(path,userSize);
    	System.out.println("已经使用空间大小："+userSize+"B ");
    	return userSize;
    }
    
    private static Long loopPathFile(String path,Long userSize){
    	try {
        	FTPClient ftp = getCloudSpaceFTP();
        	String[] aryStr = path.split("/");
        	
        	for(int i=1;i<aryStr.length;i++){
        		String newpath = new String(aryStr[i].getBytes(),
    					FTP.DEFAULT_CONTROL_ENCODING);
        		ftp.changeWorkingDirectory(newpath);
        	}
        	
        	FTPFile[] files = ftp.listFiles();
        	for (FTPFile ftpFile : files) {
        		if(ftpFile.isFile()){
        			Long curSize = ftpFile.getSize();
            		userSize = userSize+curSize;
        		}else if(ftpFile.isDirectory()){  
        			userSize = loopPathFile((path+ftpFile.getName()+"/"),userSize);  
                } 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return userSize;
    }
    
    /**
     * 生成ftp目录 
     * 	    cloudSpace/{userid}/{cloudid}/{policeid}/{caseid}
     * 该目录根目录在配置的cloudspace.upfile.service.path目录下
     * @param path   
     * 		/{userid}/{cloudid}/{policeid}/{caseid}
     * @return
     */
	public static void makeDir(String path){
		String[] aryStr = path.split("/");
        try {
        	FTPClient ftp = getCloudSpaceFTP();
        	//ftp.changeWorkingDirectory(aryStr[1]);
        	for(int i=1;i<aryStr.length;i++){
        		ftp.makeDirectory(aryStr[i]);
        		String newpath = new String(aryStr[i].getBytes(),
    					FTP.DEFAULT_CONTROL_ENCODING);
        		ftp.changeWorkingDirectory(newpath);
        	}
        	ftp.logout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 /**
     * 转换文件大小
     * 
     * @param fileS
     * @return
     */ 
    public static String formetFileSize(long fileS) { 
        DecimalFormat df = new DecimalFormat("#.00"); 
        String fileSizeString = ""; 
        if(fileS == 0){
        	fileSizeString = "0.00B";
        }else if (fileS < 1024) { 
            fileSizeString = df.format((double) fileS) + "B"; 
        } else if (fileS < 1048576) { 
            fileSizeString = df.format((double) fileS / 1024) + "K"; 
        } else if (fileS < 1073741824) { 
            fileSizeString = df.format((double) fileS / 1048576) + "M"; 
        } else { 
            fileSizeString = df.format((double) fileS / 1073741824) + "G"; 
        } 
        return fileSizeString; 
    }
    
    /**
	 * 获取获取项目所在物理路径（根目录）
	 * @param arg
	 * @return
	 */
	public static String getRootPath(String arg) {
		return ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath(arg);
	}
	
	public static void main(String[] args) {
		/*String fileName = "2.avi";
		String sourcePath = "http://192.168.0.129/data/185_20170610155307/tube00000006obj0frm1749_67x125_1.jpg";
		String ftpPath = "/1477468101309/8af60bae78984d95aec87b685f850e19/430100000000/";
		
		CloudSpaceFTPUtils util = new CloudSpaceFTPUtils();
		util.deleteDirectory(util.getJudgeFTP(),"/1477468101309/52ea23aa70424e18894ffe94ebd0208a/430100000000");*/
		//ftpUtil.getFileSize(ftpPath);
		//根据ftp目录 生成ftp服务器文件目录
		//ftpUtil.makeDir(ftpPath);
		//ftpUtil.uploadFile(ftpPath, fileName, in);  //上传文件到对应目录
		
		FTPUtils util = new FTPUtils();
		
		FTPClient ftp = util.getJudgeFTP();
		
		String path = "/new_000000/050000/050200/050299/J4301814300002012100050/";
		
    	System.out.println("------------ftpPath =>>" + path);
    	boolean flag = false;
    	//转到指定上传目录  
    	String[] pathStr = path.split("/");
    	try {
	    	for(int i=0;i<pathStr.length;i++){
	    		if(!pathStr[i].equals("")){
					String newpath;
						newpath = new String(pathStr[i].getBytes(),FTP.DEFAULT_CONTROL_ENCODING);
						flag = ftp.changeWorkingDirectory(newpath);//转移到FTP服务器目录 
						System.out.println("------------changeWorkingDirectory - >  "+newpath+"   - > flag =>>" + flag);
	    		}
	    	}//转移到FTP服务器目录  
	        ftp.enterLocalPassiveMode();//转移到指定FTP服务器目录  
	        
	        FTPFile[] fs = ftp.listFiles();
	        for (FTPFile ftpFile : fs) {
				System.out.println(ftpFile.getName());
			}
			ftp.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
