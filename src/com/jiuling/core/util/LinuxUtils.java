package com.jiuling.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

public class LinuxUtils {
	 protected static Logger logger = Logger.getLogger(LinuxUtils.class.getName());
	 
	 @SuppressWarnings("resource")
	 public static Integer executeCommand(String command,String hostname,String username,String password){
		 Integer messageCode = -1;
		 try {  
	            Connection conn = new Connection(hostname);  
	            conn.connect();  
	            boolean isAuthenticated = conn.authenticateWithPassword(username, password);  
	            if (isAuthenticated == false){  
	                logger.error("Authentication failed."); 
	                return messageCode;
	            }
	  
	            Session sess = conn.openSession();   
	            sess.execCommand(command);  
	            logger.info("command:" + command +" \nHere is some information about the remote host:");  
	            InputStream stdout = new StreamGobbler(sess.getStdout());  
	            BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
	            messageCode = sess.getExitStatus();
	            while (true) {  
	                String line = br.readLine();  
	                if (line == null)  
	                    break;
	                logger.info(line);  
	            }  
	            logger.info("ExitCode: " + messageCode);
	            if(messageCode == null){
	            	return -1;
	            }
	            if(messageCode > 0){
	            	InputStream stderr = new StreamGobbler(sess.getStderr());  
		            BufferedReader errBr = new BufferedReader(new InputStreamReader(stderr));
		            while (true) {
		            	String line = errBr.readLine();  
		            	if (line == null)  
		                    break;
			            byte[] resultMsgBytes = line.getBytes();
			            String resultMsg = new String(resultMsgBytes,"UTF-8");
			            logger.error("resultMsg:" + resultMsg);
		            }
	            }
	            sess.close();  
	            conn.close(); 
	        }  catch (IOException e)  {  
	        	logger.error("resultMsg:" + System.err);  
	        }  
		 return messageCode;
	 }
	 public static Integer setSystemTime(String datetime,String hostname,String username,String password){
		 String cmd = "date -s \""+datetime+"\" && hwclock -w";
		 return executeCommand(cmd,hostname,username,password);
	 }
	 
	 public static Integer restartMachine(String hostname,String username,String password){
		 String cmd ="shutdown -r now";
		 return executeCommand(cmd,hostname,username,password);
	 }
	 
	
	 
	 public static void main(String[] args)  {  
		 LinuxUtils.executeCommand("uname -a && date && uptime && who","192.168.0.186","shixiuting","test123");
	 } 
}
