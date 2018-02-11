package com.jiuling.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jiuling.core.util.ContxtUtils;
import com.jiuling.core.util.VarUtils;
import com.jiuling.web.enums.TaskStatus;
import com.jiuling.web.enums.YESORNO;
import com.jiuling.web.model.SysUser;
import com.jiuling.web.model.VsdTask;
import com.jiuling.web.service.TaskService;

/**
 * 部门控制器(测)
 * 
 * @author ShiXt 2016年1月28日
 */
@Controller
@RequestMapping("/task")
public class TaskController {
	@Resource
	private TaskService taskService;
	/**
     * 任务列表
     */
    @RequestMapping(value = "/listtasks")
    @ResponseBody
    public ModelAndView listtasks(Model m) {
        return new ModelAndView("business/task/taskList");
    }
    /**
     * 添加任务
     */
    @RequestMapping(value = "/addTask")
    @ResponseBody
    public ModelAndView addTask(Model m) {
        return new ModelAndView("business/task/addTask");
    }
    
    /**
     * 提交本地文件进行分析
     * @throws Exception
     */
    @RequestMapping(value = "/submitFile")
    @ResponseBody
    public Map<String, Object> submitLocalVideoAnalysis(HttpServletRequest request, Model m, MultipartFile file,String taskName,String type) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("state", true);
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("taskName", taskName);
        params.put("type", type);
        if (file!=null &&  !file.isEmpty()){
            //文件上传至转码服务器
           String[] objs = taskService.uploadFile(file,params);
           // 上传失败
           if("0".equals(objs[0])){
               result.put("state", false);
               result.put("msg", "文件上传失败!");
           }else{
        	   VsdTask task = new VsdTask();
        	   task.setName(taskName);
        	   task.setType(type);
        	   SysUser user = ContxtUtils.getUserSession();
			   Long userId = user.getUserId();
			   task.setCreateUser(userId);
			   task.setCreatetime(new Date());
			   task.setStatus((short)TaskStatus.WAIT.value);
			   task.setIsvalid(String.valueOf(YESORNO.YES.value));
			   task.setSerialnumber(objs[2]);
			   task.setRetrycount((short)0);
			   taskService.addTask(task);
           }
        }else{
            result.put("state", false);
            result.put("msg","文件为空！");
        }
        return result;
    }
    
    /**
     * 提交本地文件进行分析
     * @throws Exception
     */
    @RequestMapping(value = "/addData")
    @ResponseBody
    public Map<String, Object> addData(HttpServletRequest request, Model m) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("state", true);
        VarUtils util = new VarUtils();
        util.addDataByJson("");
        return result;
    }
}
