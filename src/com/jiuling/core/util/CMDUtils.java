package com.jiuling.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class CMDUtils {
	
	protected static Logger logger = Logger.getLogger(CMDUtils.class.getName());
	
	public static void main(String[] args) throws IOException {
		//CMDUtils.execueteCommand("cmd.exe /c shutdown -r");
		//"winrar x +文件路径D:\ftp\dayfilm\2018\01\31\s\Snapshots.zip"  
		CMDUtils.execueteCommand("cmd.exe /c cd /d D:/ftp/dayfilm/2018/01/31/s &&  winrar x Snapshots.zip");
		//CMDUtils.execueteCommand("winrar x Snapshots.zip");
	}
	
	public static void setSystemTime(String datetime){
		try {
		   String date = datetime.substring(0, 10);
		   String time = datetime.substring(11);
		   Runtime.getRuntime().exec("cmd /c date " + date); //修改应用服务器年月日
		   Runtime.getRuntime().exec("cmd /c time " + time);//修改应用服务器时分秒
		} catch (IOException e) {
		   logger.error("与ntp服务器同步时间错误！");
		} 
	}
	
	public static void restartMaster() throws IOException{
		CMDUtils.execueteCommand("cmd.exe /c shutdown -r");
	}
	
	public static int execueteCommand(String command) throws IOException{
		int exitStatus = -1;
		Runtime rt = Runtime.getRuntime();
		Process p = rt.exec(command);
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));  
	        StringBuffer sb = new StringBuffer();  
	        String line;  
	        while ((line = br.readLine()) != null) {  
	            sb.append(line).append("\n");  
	        }  
	        String result = sb.toString();
	        if(result.length()> 0){
	        	logger.info("command:"+ command +"\n"+ result); 
	        }
	        BufferedReader errorBuffer = new BufferedReader(new InputStreamReader(p.getErrorStream()));  
	        while ((line = errorBuffer.readLine()) != null) {  
	            sb.append(line).append("\n");  
	        }  
	        result = sb.toString(); 
	        if(result.length() > 0){
				logger.error("command:"+ command +" exitStatus:"+exitStatus+" result:"+ result); 
			}
			p.waitFor();
		} catch (InterruptedException e) {
			logger.error(e.getMessage());
		}
		exitStatus = p.exitValue();
		return exitStatus;
	}
	
	public static int execueteCommand(String[] command) throws IOException{
		Runtime rt = Runtime.getRuntime();
		Process p = rt.exec(command);
		int exitStatus = -1;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));  
	        StringBuffer sb = new StringBuffer();  
	        String line;  
	        while ((line = br.readLine()) != null) {  
	            sb.append(line).append("\n");  
	        }  
	        String result = sb.toString();
	        if(result.length()> 0){
	        	logger.info("command:"+ command[2] + result); 
	        }
	        BufferedReader errorBuffer = new BufferedReader(new InputStreamReader(p.getErrorStream()));  
	        while ((line = errorBuffer.readLine()) != null) {  
	            sb.append(line).append("\n");  
	        }  
	        result = sb.toString();  
	        p.waitFor();
			exitStatus = p.exitValue();
			if(result.length() > 0){
				logger.error("command:"+ command[2] +" exitStatus:"+exitStatus+" result:"+ result); 
			}
		} catch (InterruptedException e) {
			logger.error(e.getMessage());
		} 
		return exitStatus;
	}
}
