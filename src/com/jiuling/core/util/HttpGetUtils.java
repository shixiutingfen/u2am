package com.jiuling.core.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONException;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import com.alibaba.fastjson.JSONObject;
import com.jiuling.web.constants.WebserviceConstant;


public class HttpGetUtils {
    private static final Log log = LogFactory.getLog(HttpGetUtils.class);
    
    
    /**
     * get方式
     * 
     * @param param1
     * @param param2
     * @return
     */
    public static String getHttp(String serviceName, Map<String, String> paramMap) {
        String responseMsg = "";
        //log.info(serviceName+"start---");
        String ipAddress = PropertiesUtil.getFtpPackey("video.service");

        // 1.构造HttpClient的实例
        HttpClient httpClient = new HttpClient();

        // 构造参数
        List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
        if (null != paramMap) {
            for (Map.Entry<String, String> entry : paramMap.entrySet()) {

                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue())); // 增加参数1
            }
        }
        String param = URLEncodedUtils.format(params, "UTF-8");// 对参数编码

        // 用于测试的http接口的url
        String url = "http://" + ipAddress + serviceName + "?" + param;
        // 2.创建GetMethod的实例
        GetMethod getMethod = new GetMethod(url);

        // 使用系统系统的默认的恢复策略
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());

        try {
            // 3.执行getMethod,调用http接口
            httpClient.executeMethod(getMethod);

            // 4.读取内容
            byte[] responseBody = getMethod.getResponseBody();

            // 5.处理返回的内容
            responseMsg = new String(responseBody);
        } catch (HttpException e) {
        	log.error("error:"+e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
        	log.error("error:"+e.getMessage());
            e.printStackTrace();
        } finally {
            // 6.释放连接
            getMethod.releaseConnection();
        }
        //log.info("success---end");
        return responseMsg;
    }
    
    /**
     * get方式
     * 
     * @param param1
     * @param param2
     * @return
     */
    public static String getHttps(String slaveip,String serviceName, Map<String, String> paramMap) {
        String responseMsg = "";
        //log.info(serviceName+"start---");

        // 1.构造HttpClient的实例
        HttpClient httpClient = new HttpClient();

        // 构造参数
        List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
        if (null != paramMap) {
            for (Map.Entry<String, String> entry : paramMap.entrySet()) {

                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue())); // 增加参数1
            }
        }
        String param = URLEncodedUtils.format(params, "UTF-8");// 对参数编码

        // 用于测试的http接口的url
        String url = "http://" + slaveip + serviceName + "?" + param;
        // 2.创建GetMethod的实例
        GetMethod getMethod = new GetMethod(url);

        // 使用系统系统的默认的恢复策略
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());

        try {
            // 3.执行getMethod,调用http接口
            httpClient.executeMethod(getMethod);
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(getMethod.getResponseBodyAsStream()));
            StringBuffer stringBuffer = new StringBuffer();
            String str = "";
            while((str = reader.readLine())!=null){
            	stringBuffer.append(str);
            }
            responseMsg = stringBuffer.toString();

            // 4.读取内容
            //byte[] responseBody = getMethod.getResponseBody();

            // 5.处理返回的内容
            //responseMsg = new String(responseBody);
        } catch (HttpException e) {
        	log.error("error:"+e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
        	log.error("error:"+e.getMessage());
            e.printStackTrace();
        } finally {
            // 6.释放连接
            getMethod.releaseConnection();
        }
        //log.info("success---end");
        return responseMsg;
    }

    /**
     * post方式
     * 
     * @param param1
     * @param param2
     * @return
     */
    public static String postHttp(String serviceName, Map<String, String> paramMap) {
        String responseMsg = "";

        String ipAddress = PropertiesUtil.getFtpPackey("video.service");

        // 1.构造HttpClient的实例
        HttpClient httpClient = new HttpClient();

        httpClient.getParams().setContentCharset("UTF-8");

        // 用于测试的http接口的url
        String url = "http://" + ipAddress + serviceName;

        // 2.构造PostMethod的实例
        PostMethod postMethod = new PostMethod(url);

        // 3.把参数值放入到PostMethod对象中
        // 方式1：
        // 构造参数
        // NameValuePair[] data = { new NameValuePair("param1", param1),
        // new NameValuePair("param2", param2) };
        // postMethod.setRequestBody(params);

        // 方式2：
        // postMethod.addParameter("param1", param1);
        // postMethod.addParameter("param2", param2);

        if (null != paramMap) {
            for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                postMethod.addParameter(entry.getKey(), entry.getValue());// 增加参数1
            }
        }

        try {
            // 4.执行postMethod,调用http接口
            httpClient.executeMethod(postMethod);// 200

            // 5.读取内容
            responseMsg = postMethod.getResponseBodyAsString().trim();
            //log.info(responseMsg);

            // 6.处理返回的内容
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 7.释放连接
            postMethod.releaseConnection();
        }
        return responseMsg;
    }
    
    /**
     * post方式
     * 
     * @param param1
     * @param param2
     * @return
     */
    public static String postHttps(String slaveip,String serviceName, Map<String, String> paramMap) {
        String responseMsg = "";

        // 1.构造HttpClient的实例
        HttpClient httpClient = new HttpClient();

        httpClient.getParams().setContentCharset("UTF-8");

        // 用于测试的http接口的url
        String url = "http://" + slaveip + serviceName;

        // 2.构造PostMethod的实例
        PostMethod postMethod = new PostMethod(url);

        // 3.把参数值放入到PostMethod对象中
        // 方式1：
        // 构造参数
        // NameValuePair[] data = { new NameValuePair("param1", param1),
        // new NameValuePair("param2", param2) };
        // postMethod.setRequestBody(params);

        // 方式2：
        // postMethod.addParameter("param1", param1);
        // postMethod.addParameter("param2", param2);

        if (null != paramMap) {
            for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                postMethod.addParameter(entry.getKey(), entry.getValue());// 增加参数1
            }
        }

        try {
            // 4.执行postMethod,调用http接口
            httpClient.executeMethod(postMethod);// 200

            // 5.读取内容
            responseMsg = postMethod.getResponseBodyAsString().trim();
            //log.info(responseMsg);

            // 6.处理返回的内容
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 7.释放连接
            postMethod.releaseConnection();
        }
        return responseMsg;
    }
    
    /**
     * 获取cs2vj 接口IP和端口
     * @return
     */
    public static String getVjServicePrefix(){
    	String ipAddress = PropertiesUtil.getFtpPackey("vj.service.ip");
        String ipPort = PropertiesUtil.getFtpPackey("vj.service.port");
        String url= "http://" + ipAddress +":" + ipPort ;
        return url;
    }
    /**
     * post方式调用cs2vj接口同步
     * 
     * @param param1
     * @param param2
     * @return
     */
    public static String postHttpVj(String serviceName, Map<String, String> paramMap) {
    	String responseMsg = "";
        // 1.构造HttpClient的实例
        HttpClient httpClient = new HttpClient();

        httpClient.getParams().setContentCharset("UTF-8");
        
        // 用于测试的http接口的url
        String url =getVjServicePrefix() +serviceName;

        // 2.构造PostMethod的实例
        PostMethod postMethod = new PostMethod(url);

        // 3.把参数值放入到PostMethod对象中
        // 方式1：
        // 构造参数
        // NameValuePair[] data = { new NameValuePair("param1", param1),
        // new NameValuePair("param2", param2) };
        // postMethod.setRequestBody(params);

        // 方式2：
        // postMethod.addParameter("param1", param1);
        // postMethod.addParameter("param2", param2);

        if (null != paramMap) {
            for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                postMethod.addParameter(entry.getKey(), entry.getValue());// 增加参数1
            }
        }

        try {
            // 4.执行postMethod,调用http接口
            httpClient.executeMethod(postMethod);// 200

            // 5.读取内容
            responseMsg = postMethod.getResponseBodyAsString().trim();
            //log.info(responseMsg);

            // 6.处理返回的内容
        } catch (HttpException e) {
        	log.error(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
        	log.error(e.getMessage());
            e.printStackTrace();
        } finally {
            // 7.释放连接
            postMethod.releaseConnection();
        }
        return responseMsg;
    }
    

  /**
   * 
   * @param fileInputStream 文件流	
   * @param postUrl 上传地址
   * @param fileName 文件名
   * @return
   * @throws ClientProtocolException
   * @throws IOException
   * @throws JSONException
   */
    public static boolean postFile(FileInputStream fileInputStream, final String postUrl, String fileName,String filePath) throws ClientProtocolException, IOException, JSONException {  
    	 boolean upLoadSuccess=false;
    	 HttpURLConnection connection=null;
        try {
        	String urlPath=HttpGetUtils.getVjServicePrefix()+postUrl+"?fileName="+fileName+"&filePath="+filePath;
            URL url=new URL(urlPath);
            connection=(HttpURLConnection)url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.setConnectTimeout(1000*60*5); //连接超时为10秒  
            connection.setRequestMethod("POST");
            connection.setChunkedStreamingMode(1024);
            String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
            if(ValidateHelper.isImageSuffix(suffix)){
            	connection.setRequestProperty("Content-Type","image/"+suffix.toLowerCase());
            }else{
            	connection.setRequestProperty("Content-Type","application/octet-stream");  
            }
            connection.setRequestProperty("Connection", "Keep-Alive");
            
            BufferedInputStream inBufferedInputStream = new BufferedInputStream(fileInputStream);
            BufferedOutputStream out = new BufferedOutputStream(connection.getOutputStream());
            //读取文件上传到服务器
            int len=1024*1024; 
            byte[]bytes=new byte[len];
            int numReadByte=0;
//            long cur1 = System.currentTimeMillis();
            while((numReadByte=inBufferedInputStream.read(bytes))!=-1)
            {
                out.write(bytes, 0, numReadByte);
            }
//            long cur2 = System.currentTimeMillis();
            out.flush();
            out.close();
            fileInputStream.close();
            //System.out.println("输出时间"+(cur2-cur1)+"毫秒");
            //读取URLConnection的响应
            int responseCode = connection.getResponseCode();
            if(HttpURLConnection.HTTP_OK==responseCode){
            	DataInputStream in=new DataInputStream(connection.getInputStream());
            	numReadByte=0;
            	StringBuffer data=new StringBuffer();
            	while((numReadByte=in.read(bytes, 0, 1024))>0){
            		data.append(new String(bytes, 0, numReadByte));
            	}
            	//System.out.println("上传图片----------->"+data.toString());
            	in.close();
            	JSONObject result=JSONObject.parseObject(data.toString());
            	String resultCode = result.getString("code");
            	if("1".equals(resultCode)){
            		upLoadSuccess=true;
            	}
            }
        }catch(Exception e){
        	e.printStackTrace();
        	
        }finally{
        	connection.disconnect();
        }
        return upLoadSuccess;
      } 
    
    /**
     * 测试的main方法
     * 
     * @param args
     */
    public static void main(String[] args) {
    	try { 
    		String  path="http://192.168.1.130/data/74_20161101145031/tube00000001obj0frm49_26x46_1.jpg";
//    		path.replaceFirst("\\\\", "//");
    		path.split("/");
    		//URL url=new URL("http://192.168.1.130/data/74_20161101145031/tube00000001obj0frm49_26x46_1.jpg");
    		
    		//http:\192.168.1.130\data\74_20161101145031\tube00000001obj0frm49_26x46_1.jpg
    		//String newfileUrl = path.replaceAll("/", "//");
			//"http://192.168.0.121/vsd_result/HUMAN_1332040443-000002-000001.jpg"
    		postFile(new FileInputStream(path), WebserviceConstant.UPLOADFILE, "test111"+".jpg",null);
    		//180940毫秒
    		/*Date date=new Date();
    		long data1 = System.currentTimeMillis();
    	//	System.out.println(date.getTime());
			File fileDir=new File("D:\\ftp_cs2vd");
			if(fileDir.isDirectory()){
				File[] files = fileDir.listFiles();
				int i=0;
				for (File image : files) {
					if(image.isFile()){
						String path=image.getAbsolutePath();
						
						if(path.endsWith("avi")){
							boolean result=postFile(new FileInputStream(image), WebserviceConstant.UPLOADFILE, i+"test"+".avi");
							System.out.println(i+"test"+".avi"+"原始路径"+path+":"+result);
						}
					}
					i++;
				}
			}
			long data2 = System.currentTimeMillis();
			System.out.println(((data2-data1))/1000+"秒");*/
    		//boolean result=postFile(new FileInputStream("d://test.jpg"), WebserviceConstant.UPLOADFILE, "test1.jpg");
    		//System.out.println(result);
    	} catch (JSONException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        /*
         * String param =
         * "UserUploadVideoId=91&bAutoAnalysis=1&Userdata=3&type=1&sensitivity=0&fineness=3&snap_type=0&thickness=0&task_priority=0&summary_width=-1&summary_height=-1&drop_frm_rate=1.0&obj_enable=1&obj_type=3"
         * ; LinkedHashMap<String, String> paramMap = new LinkedHashMap<String, String>(); //转map，因为http调用需要对参数封装 String[] analyseParams =
         * param.trim().split("&"); if (null != analyseParams){ for (String params : analyseParams){ String[] subparams = params.split("="); if (null
         * != analyseParams){ paramMap.put(subparams[0], subparams[1]); } } }
         */

        // String result = postHttp(WebserviceConstant.SUBMIT_TASK,paramMap);
      /*  String result = "CheckUrlAndGetInfo return fail..<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<result>" + "<code>0</code>"
                + "<flowNumber>81</flowNumber>" + "<taskName>浓缩检索任务</taskName>" + "<msg>succ</msg>" + "</result>";
        //System.out.println(result);

        String FlowNumber = DomUtil.parseResult(result, "result", "flowNumber");
        // http://master_ip/submitTask.php
        // //System.out.println("get方式调用http接口\n"+getHttp(serviceName,paramMap));
        //System.out.println("post方式调用http接口\n" + FlowNumber);*/
     
       /* for (int i=100;i<389;i++)
        {
            LinkedHashMap<String, String> paramMap = new LinkedHashMap<String, String>(); 
            paramMap.put("type", "0");
            paramMap.put("id", i+"");
            postHttp("/delete.php?type=0&id="+i,null);
        }*/
    }

	

}
