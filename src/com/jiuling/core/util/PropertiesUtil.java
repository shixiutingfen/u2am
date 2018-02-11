package com.jiuling.core.util;

import java.io.IOException;

import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 获取当前应用properties文件内容
 * @author Administrator
 *
 */
public class PropertiesUtil {
	private static PropertiesUtil propertiesUtil = null;


	public static PropertiesUtil getInstance() {
		if (propertiesUtil == null) {
			propertiesUtil = new PropertiesUtil();
		}
		return propertiesUtil;
	}
	/**
	 * 获取 application 文件的内容
	 * @param key
	 * @return
	*/
	 public static String getAppContext(String key) {
		  String result = null;
		  java.util.Properties props;
		  try {
		   props = PropertiesLoaderUtils.loadAllProperties("application.properties");
		   result = props.getProperty(key);//根据name得到对应的value
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		  return result;

		 }
	
	 /**
	 * 获取 appftpserver 文件的内容
	 * @param key
	 * @return
	 */
	
	 public static String getFtpPackey(String key) {
		  String result = null;
		  java.util.Properties props;
		  try {
		   props = PropertiesLoaderUtils.loadAllProperties("appftpserver.properties");
		   result = props.getProperty(key);//根据name得到对应的value
		  } catch (IOException e) {
			  e.printStackTrace();
		  }
		  return result;

		 }
	 
	 /**
	 * 获取 appftpserver 文件的内容
	 * @param key
	 * @return
	 */
	
	 public static String getMsgPackey(String key) {
		  String result = null;
		  java.util.Properties props;
		  try {
		   props = PropertiesLoaderUtils.loadAllProperties("messages.properties");
		   result = props.getProperty(key);//根据name得到对应的value
		  } catch (IOException e) {
			  e.printStackTrace();
		  }
		  return result;

	}
	 
}
