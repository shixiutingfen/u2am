package com.jiuling.web.security;

import java.io.Serializable;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.ehcache.EhCacheManager;
/**
 *  授权帮助类
 * @author hello
 *
 */
public class ShiroAuthorizationHelper {
     
	@Resource
	private static EhCacheManager shiroEhcacheManager; 
	
	 /** 
     * 清除用户的授权信息 
     * @param username 
     */  
    public static void clearAuthorizationInfo(String username){  
       
        //ShiroCasRealm.authorizationCache 为shiro自义cache名(shiroCasRealm为我们定义的reaml类的类名)  
        Cache<Object, Object> cache = shiroEhcacheManager.getCache("securityRealm.authorizationCache");  
        cache.remove(username);  
    }  
      
    /** 
     * 清除当前用户的授权信息 
     */  
    public static void clearAuthorizationInfo(){  
        if(SecurityUtils.getSubject().isAuthenticated()){  
            clearAuthorizationInfo(ShiroSecurityHelper.getCurrentUsername());  
        }  
    }  
      
    /**清除session(认证信息) 
     * @param JSESSIONID 
     */  
    public static void clearAuthenticationInfo(Serializable JSESSIONID){  
       
        //shiro-activeSessionCache 为shiro自义cache名，该名在org.apache.shiro.session.mgt.eis.CachingSessionDAO抽象类中定义  
        //如果要改变此名，可以将名称注入到sessionDao中，例如注入到CachingSessionDAO的子类EnterpriseCacheSessionDAO类中  
        Cache<Object, Object> cache = shiroEhcacheManager.getCache("shiro-activeSessionCache");  
        cache.remove(JSESSIONID);  
    }  
  
    public static EhCacheManager getCacheManager() {  
        return shiroEhcacheManager;  
    }  
  
    public static void setCacheManager(EhCacheManager cacheManager) {  
        ShiroAuthorizationHelper.shiroEhcacheManager = cacheManager;  
    }  
      
}
