package com.jiuling.core.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.jiuling.web.model.SysUser;
/**
 * 上下文管理
 * @author Administrator
 *
 */
public class ContxtUtils {

	public ContxtUtils() {
		 
		
	}
	
	/**
	 * 获取当前登陆用户信息
	 * @return
	 */
	public static SysUser getUserSession()
	{
		SysUser currentUser = new SysUser();
		  Subject subject = SecurityUtils.getSubject();
	
		  Session session = subject.getSession();
		  currentUser = (SysUser)session.getAttribute("userInfo");
		  if (null != currentUser)
		  {
			  return currentUser;
		  }else
		  {
			  return new SysUser();
		  }
		  
	}
	
	/**
     * 获取当前登陆用户信息
     * @return
     */
    public static boolean getSession()
    {
        SysUser currentUser = new SysUser();
          Subject subject = SecurityUtils.getSubject();
         
          Session session = subject.getSession();
          currentUser = (SysUser)session.getAttribute("userInfo");
         
          return currentUser == null ? false : true;
         
    }
    
  /*  public static void main(String[] args) {
        List<SysUser> list = getOnlineUser();
        System.out.println(list);
    }*/
    
}
