package com.jiuling.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class OracleJdbcUtils {

	
	private Connection connection = null; 
	
	private Connection connectionsz = null; 
	 
	 /**
	  * 创建连接
	  * @return
	  */
	 public Connection createConnection(){  
	  try {
	   //驱动名称
	   String driverName =  PropertiesUtil.getAppContext("oracle.jdbc.driver");
	   //链接
	   String url =  PropertiesUtil.getAppContext("oracle.jdbc.url");
	   //账号
	   String username =  PropertiesUtil.getAppContext("oracle.jdbc.username");
	   //密码
	   String userpwd =  PropertiesUtil.getAppContext("oracle.jdbc.password");
	   Class.forName(driverName);
	   connection = DriverManager.getConnection(url, username,userpwd);
	   return connection;   
	  } catch (ClassNotFoundException e) {
	   Logger.getLogger(this.getClass()).error(e.getMessage());
	   return null;
	  } catch (SQLException e) {
	   Logger.getLogger(this.getClass()).error(e.getMessage());
	   return null;
	  }
	 } 
	 /**
	  * 释放连接
	  */
	 public void releaseConnection(){  
	  if (connection!=null)
	   try {
	    connection.close();
	   } catch (SQLException e) {
	    Logger.getLogger(this.getClass()).error(e.getMessage());
	   }
	 }
	 
	 /**
	  * 创建连接
	  * @return
	  */
	 public Connection createConnectionsz(){  
	  try {
	   //驱动名称
	   String driverName =  PropertiesUtil.getAppContext("oraclesz.jdbc.driver");
	   //链接
	   String url =  PropertiesUtil.getAppContext("oraclesz.jdbc.url");
	   //账号
	   String username =  PropertiesUtil.getAppContext("oraclesz.jdbc.username");
	   //密码
	   String userpwd =  PropertiesUtil.getAppContext("oraclesz.jdbc.password");
	   Class.forName(driverName);
	   connectionsz = DriverManager.getConnection(url, username,userpwd);
	   return connectionsz;   
	  } catch (ClassNotFoundException e) {
	   Logger.getLogger(this.getClass()).error(e.getMessage());
	   return null;
	  } catch (SQLException e) {
	   Logger.getLogger(this.getClass()).error(e.getMessage());
	   return null;
	  }
	 } 
	 /**
	  * 释放连接
	  */
	 public void releaseConnectionsz(){  
	  if (connectionsz!=null)
	   try {
		   connectionsz.close();
	   } catch (SQLException e) {
	    Logger.getLogger(this.getClass()).error(e.getMessage());
	   }
	 }
	}

