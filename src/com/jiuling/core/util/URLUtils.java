package com.jiuling.core.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 流媒体url检测
 * @author fanxiaoming
 *
 */
public class URLUtils {

	/**
	 * 判断当前流媒体url是否有有效
	 * @param source
	 * @return
	 */
	public static synchronized boolean isConnect(String source){
		boolean flag = false;
		
		if(StringUtils.isEmptyString(source)){
			return flag;
		}
		
		URL url = null;
		HttpURLConnection conn = null;
		int state = -1;
		try {
			url = new URL(source);
			conn = (HttpURLConnection) url.openConnection();
			state = conn.getResponseCode();
			System.out.println("  state = "+state);
			if(state == 200){
				System.out.println("文件大小： "+conn.getContentLengthLong());
				flag = true;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			conn.disconnect();
		}
		return flag;
	}
	
	public static void main(String[] args) {
		String source = "http://192.168.0.129/data/185_20170610155307/tube00000006obj0frm1749_67x125_1.jpg";
		boolean flag = URLUtils.isConnect(source);
		System.out.println(flag);
	}

}
