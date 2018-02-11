package com.jiuling.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 视图控制器,返回jsp视图给前端
 * 
 * @author YangXQ
 * @since 2016/1/11/11:00
 **/
@Controller
@RequestMapping("/page")
public class PageController {

    /**
     * 登录页
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request,HttpServletResponse response, Model model) {
    	// 设置页面不缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
        return "login";
    }
    

    /**
     * 404页
     */
    @RequestMapping("/404")
    public String error404() {
        return "common/page/404";
    }

    /**
     * 401页
     */
    @RequestMapping("/401")
    public String error401() {
        return "common/page/401";
    }

    /**
     * 500页
     */
    @RequestMapping("/500")
    public String error500() {
        return "common/page/500";
    }

}