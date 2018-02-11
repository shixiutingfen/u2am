package com.jiuling.core.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ConvertVideo {
    
    
    public static void main(String args[]) throws IOException {
    	String path ="e:\ftp\ftp2\123.avi";
    	System.out.println(path.substring(path.lastIndexOf("\\")+1 , path.lastIndexOf(".")));
        
     /*   getPath();
        
        if (!checkfile(inputPath)) {
            System.out.println(inputPath + " is not file");
            return;
        }
        if (process()) {
            System.out.println("ok");
        }*/
    }
    
    /**
     * 文件转码
     * @param inputPath 上传文件本地路径
     * @param outPutPath  上传文件的ftp路径
     * @param ffmpegPath 转码器路径
     * @return
     */
	public  static boolean process(String inputPath,String outPutPath) {
	    String ffmpegPath= FTPUtils.getRootPath("/") + "3nd\\ffmpeg.exe";
        int type = checkContentType(inputPath);
        boolean status = false;
        if (type == 0) {
            status = processFLV(inputPath,ffmpegPath ,outPutPath);// 直接转成flv格式
        } else if (type == 1) {
            /*String avifilepath = processAVI(type);
            if (avifilepath == null)
                return false;// 没有得到avi格式
            status = processFLV(avifilepath,outPutPath,ffmpegPath);// 将avi转成flv格式
*/        }
        return status;
    }

    public static int checkContentType(String inputPath) {
        String type = inputPath.substring(inputPath.lastIndexOf(".") + 1, inputPath.length())
                .toLowerCase();
        // ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
        if (type.equals("avi")) {
            return 0;
        } else if (type.equals("mpg")) {
            return 0;
        } else if (type.equals("wmv")) {
            return 0;
        } else if (type.equals("3gp")) {
            return 0;
        } else if (type.equals("mov")) {
            return 0;
        } else if (type.equals("mp4")) {
            return 0;
        } else if (type.equals("asf")) {
            return 0;
        } else if (type.equals("asx")) {
            return 0;
        } else if (type.equals("flv")) {
            return 0;
        }
        // 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等),
        // 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
        else if (type.equals("wmv9")) {
            return 1;
        } else if (type.equals("rm")) {
            return 1;
        } else if (type.equals("rmvb")) {
            return 1;
        }
        return 9;
    }

    public static boolean checkfile(String path) {
        File file = new File(path);
        if (!file.isFile()) {
            return false;
        }
        return true;
    }

    // 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等), 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
/*    public static String processAVI(int type) {
        List<String> commend = new ArrayList<String>();
        commend.add(ffmpegPath + "mencoder");
        commend.add(inputPath);
        commend.add("-oac");
        commend.add("lavc");
        commend.add("-lavcopts");
        commend.add("acodec=mp3:abitrate=64");
        commend.add("-ovc");
        commend.add("xvid");
        commend.add("-xvidencopts");
        commend.add("bitrate=600");
        commend.add("-of");
        commend.add("avi");
        commend.add("-o");
        commend.add(outputPath + "a.avi");
        try {
            ProcessBuilder builder = new ProcessBuilder();
            Process process = builder.command(commend).redirectErrorStream(true).start();
            new PrintStream(process.getInputStream());
            new PrintStream(process.getErrorStream());
            process.waitFor();
            return outputPath + "a.avi";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/

    // ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
    public static boolean processFLV(String oldfilepath,String ffmpegPath,String outputPath) {

        if (!checkfile(oldfilepath)) {
            System.out.println(oldfilepath + " is not file");
            return false;
        }
        
        List<String> command = new ArrayList<String>();
        command.add(ffmpegPath );
        command.add("-i");
        command.add(oldfilepath);
        command.add("-ab");
        command.add("56");
        command.add("-ar");
        command.add("22050");
        command.add("-qscale");
        command.add("8");
        command.add("-r");
        command.add("15");
        command.add("-s");
        command.add("600x500");
        command.add(outputPath );

        try {
            
            // 方案1
//            Process videoProcess = Runtime.getRuntime().exec(ffmpegPath + "ffmpeg -i " + oldfilepath 
//                    + " -ab 56 -ar 22050 -qscale 8 -r 15 -s 600x500 "
//                    + outputPath + "a.flv");
            
            // 方案2
            Process videoProcess = new ProcessBuilder(command).redirectErrorStream(true).start();
            
            new PrintStream(videoProcess.getErrorStream()).start();
            
            new PrintStream(videoProcess.getInputStream()).start();
            
            videoProcess.waitFor();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

class PrintStream extends Thread 
{
    java.io.InputStream __is = null;
    public PrintStream(java.io.InputStream is) 
    {
        __is = is;
    } 

    public void run() 
    {
        try 
        {
            while(this != null) 
            {
                int _ch = __is.read();
                if(_ch == -1) 
                	break;
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
    }
}