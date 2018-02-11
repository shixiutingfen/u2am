package com.jiuling.web.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jiuling.core.util.FTPUtils;
import com.jiuling.core.util.PropertiesUtil;
import com.jiuling.core.util.RandomUtils;
import com.jiuling.core.util.StringUtils;
import com.jiuling.web.constants.CommonConstants;
import com.jiuling.web.model.Module;
import com.jiuling.web.service.ModuleService;

/**
 * 公共视图控制器
 * 
 * @author YangXQ
 * @since 2016/1/11/11:00
 **/
@Controller
public class CommonController {
    
    @Resource
    private ModuleService moduleService;
    /**
     * 首页
     * 
     * @param request
     * @return
     */
    @RequestMapping("index")
    public String index(HttpServletRequest request) {
    	request.setAttribute("carService", PropertiesUtil.getAppContext("car.service"));
    	request.setAttribute("carUsername", PropertiesUtil.getAppContext("car.service.username"));
    	request.setAttribute("carPassword", PropertiesUtil.getAppContext("car.service.password"));
    	return "sysMain";
    }
    
    
    /**
     * 跳转到主页
     * @throws UnsupportedEncodingException 
     */
    @RequestMapping("toMain")
    public ModelAndView toMain(HttpServletRequest request,String hrefAndName,String moduleId) throws UnsupportedEncodingException {
        Map<String,String> result = new HashMap<String,String>();
        Module module = moduleService.selectById(Long.parseLong(moduleId));
        String url = module.getModuleUrl();
        String disPlayName = module.getDisplayName();
        if(url.indexOf("rest/")!=-1){
            url=url.substring(url.indexOf("rest/")+5, url.length());
        }
        
        result.put("hrefAndName", url+","+disPlayName);
        return new ModelAndView("main",result);
    }
   
    /**
     * ftp流获取
     * 
     * @param request
     * @return
     */
    @RequestMapping("ftp/{fileName}.{type}")
    public void getvsdresult(@PathVariable("fileName") String fileName,@PathVariable("type") String type,HttpServletResponse response) {
        
        if (StringUtils.isNotEmptyString(fileName))
        {
            FTPUtils ft = new FTPUtils();
            FTPClient ftp = ft.getJudgeFTP();
            File file2 = ft.getDownFile(ftp,"ftp",fileName+"."+type);
            
            
            try {
                InputStream ins=new FileInputStream(file2);//构造一个读取文件的IO流对象
                BufferedInputStream bins=new BufferedInputStream(ins);//放到缓冲流里面
                OutputStream outs=response.getOutputStream();//获取文件输出IO流
                BufferedOutputStream bouts=new BufferedOutputStream(outs);
                response.setContentType("application/x-download");//设置response内容的类型
                response.setHeader("Content-disposition","attachment;filename="+ URLEncoder.encode(fileName+"."+type, "UTF-8"));//设置头部信息
                int bytesRead = 0;
                byte[] buffer = new byte[8192];
                 //开始向网络传输文件流
                     while ((bytesRead = bins.read(buffer, 0, 8192)) != -1) {
                        bouts.write(buffer, 0, bytesRead);
                        }
                     bouts.flush();//这里一定要调用flush()方法
                     ins.close();
                     bins.close();
                     outs.close();
                     bouts.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    
    /**
     * ftp流获取
     * 
     * @param request
     * @return
     */
    @RequestMapping("vsd_result/{fileName}.{type}")
    public void getvsdresult2(@PathVariable("fileName") String fileName,@PathVariable("type") String type,HttpServletResponse response) {
        
        if (StringUtils.isNotEmptyString(fileName))
        {
            FTPUtils ft = new FTPUtils();
            FTPClient ftp = ft.getJudgeFTP();
            File file2 = ft.getDownFile(ftp,"vsd_result",fileName+"."+type);
            
            
            try {
                InputStream ins=new FileInputStream(file2);//构造一个读取文件的IO流对象
                BufferedInputStream bins=new BufferedInputStream(ins);//放到缓冲流里面
                OutputStream outs=response.getOutputStream();//获取文件输出IO流
                BufferedOutputStream bouts=new BufferedOutputStream(outs);
                response.setContentType("application/x-download");//设置response内容的类型
                response.setHeader("Content-disposition","attachment;filename="+ URLEncoder.encode(fileName+"."+type, "UTF-8"));//设置头部信息
                int bytesRead = 0;
                byte[] buffer = new byte[8192];
                 //开始向网络传输文件流
                     while ((bytesRead = bins.read(buffer, 0, 8192)) != -1) {
                        bouts.write(buffer, 0, bytesRead);
                        }
                     bouts.flush();//这里一定要调用flush()方法
                     ins.close();
                     bins.close();
                     outs.close();
                     bouts.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    

    /**
     * 获取请求者ip
     * @return
     */
    @RequestMapping(value = "api/ip.action", method = {RequestMethod.GET})
    @ResponseBody
    public String getVSDTaskList(HttpServletRequest request){
       String requestIp =  request.getRemoteAddr();
     return   "{\"ip\":\""+requestIp+"\"}";
    }
    
    /**
     * 获取随机数
     */
    @RequestMapping(value = "/getRandomKey")
    @ResponseBody
    public Map<String, Object> getRandomKey(HttpServletRequest request) {

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("state", true);
        try {
            String random = RandomUtils.get24TimeRandom();
            result.put("random", random);
        } catch (Exception e) {
            result.put("state", false);
            result.put("msg", CommonConstants.CREATE_FAILURE);
            e.printStackTrace();
        }
        return result;
    }
    
       
    /** 
     * 下载文件 
     * @param request 
     * @param response 
     * @param filePath 文件在服务器的相对路径 
     * @param fileName 文件下载后的文件名 
     * @param contentType 文件类型 
     * @throws Exception 
     */  
    public void download(HttpServletRequest request,  
            HttpServletResponse response, String filePath,String fileName,  
            String contentType) throws Exception {  
          
        request.setCharacterEncoding("UTF-8");  
        BufferedInputStream bis = null;  
        BufferedOutputStream bos = null;  
      
        String ctxPath = request.getSession().getServletContext().getRealPath("/");       
        String downLoadPath = ctxPath + filePath + fileName;  
      
        long fileLength = new File(downLoadPath).length();  
      
        response.setContentType(contentType);  
        response.setHeader("Content-disposition", "attachment; filename=" + fileName);  
        response.setHeader("Content-Length", String.valueOf(fileLength));  
      
        bis = new BufferedInputStream(new FileInputStream(downLoadPath));  
        bos = new BufferedOutputStream(response.getOutputStream());  
        byte[] buff = new byte[1024*8];  
        int bytesRead;  
        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
            bos.write(buff, 0, bytesRead);  
        }  
        bis.close();  
        bos.flush();  
        bos.close();  
    }
 
}

