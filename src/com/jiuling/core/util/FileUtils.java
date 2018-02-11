package com.jiuling.core.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
	public static boolean deleteLocalFile(String sPath){
		boolean flag = false;
		File file = new File(sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = true;
		}
		return flag;
	}
	
	public static boolean isImage(String suffix){
		List<String> imageSuffix = new ArrayList<String>();
		imageSuffix.add("jpg");
		imageSuffix.add("gif");
		imageSuffix.add("png");
		return imageSuffix.contains(suffix);
	}
	public static boolean isVideo(String suffix){
		List<String> imageSuffix = new ArrayList<String>();
		imageSuffix.add("avi");
		imageSuffix.add("mp4");
		return imageSuffix.contains(suffix);
	}
	public static boolean isImageAndVideo(String suffix){
		List<String> imageSuffix = new ArrayList<String>();
		imageSuffix.add("avi");
		imageSuffix.add("mp4");
		imageSuffix.add("jpg");
		imageSuffix.add("gif");
		imageSuffix.add("png");
		return imageSuffix.contains(suffix);
	}
	public static String getFileSuffix(String fileName){
		return fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
	}
	public static void main(String[] args) {
		//System.out.println(FileUtils.isImage("jpg"));
		System.out.println(FileUtils.getFileSuffix("123213213213.png"));
	}
}
