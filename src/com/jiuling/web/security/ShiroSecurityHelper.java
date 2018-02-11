package com.jiuling.web.security;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;

import com.alibaba.druid.util.StringUtils;
/**
 * 认证帮助类
 * @author hello
 *
 */
public class ShiroSecurityHelper {

	@Resource
	private static SessionDAO sessionDAO;
	
	/** 
     * 初始化
     * @param sessionDAO 
     */  
    public static void initStaticField(SessionDAO sessionDAO){
        ShiroSecurityHelper.sessionDAO = sessionDAO;  
    }  

	/**
	 * 获取当前登录用户session
	 * 
	 * @return
	 */
	public static Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}

	/**
	 * 获取当前登录session_id
	 * 
	 * @return
	 */
	public static String getSessionId() {
		Session session = getSession();
		if (null == session) {
			return null;
		}
		return getSession().getId().toString();
	}

	/**
	 * 根据用户名查询session
	 * 
	 * @param username
	 * @return
	 */
	public static Session getSessionByUsername(String username) {

		Collection<Session> sessions = sessionDAO.getActiveSessions();
		for (Session session : sessions) {
			if (null != session && StringUtils
					.equals(String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)),username)) {
				return session;
			}
		}
		return null;
	}

	/**
	 * 踢除用户
	 * 
	 * @param username
	 */
	public static void kickOutUser(String username) {
		Session session = getSessionByUsername(username);
		
		if (null != session
				&& !StringUtils.equals(String.valueOf(session.getId()),getSessionId())) {
		  ShiroAuthorizationHelper.clearAuthenticationInfo(session.getId());
		  session.setTimeout(0);
		}
	}
	
	 /** 
     * 获得当前用户名 
     *  
     * @return 
     */  
    public static String getCurrentUsername() {  
        Subject subject = getSubject();  
        PrincipalCollection collection = subject.getPrincipals();  
        if (null != collection && !collection.isEmpty()) {  
            return (String) collection.iterator().next();  
        }  
        return null;  
    }  
	
	/** 
     * 判断当前用户是否已通过认证 
     * @return 
     */  
    public static boolean hasAuthenticated() {  
        return getSubject().isAuthenticated();  
    }  
  
    private static Subject getSubject() {  
        return SecurityUtils.getSubject();  
    }  
}
