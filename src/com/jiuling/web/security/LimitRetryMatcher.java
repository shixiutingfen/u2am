package com.jiuling.web.security;


import org.apache.shiro.authc.AuthenticationInfo; 
import org.apache.shiro.authc.AuthenticationToken; 
import org.apache.shiro.authc.ExcessiveAttemptsException; 
import org.apache.shiro.authc.credential.HashedCredentialsMatcher; 

import com.jiuling.core.util.EhcacheUtils;

import java.util.concurrent.atomic.AtomicInteger; 


/** 
 * 限制登录次数，如果5次出错，锁定1个小时 
* @User： qing 
* @Date： 2016/1/30 0030 
* @Time： 15:22 
* @备注： 限制登录次数，如果5次出错，锁定1个小时 
*/ 
public class LimitRetryMatcher extends HashedCredentialsMatcher{

	 @Override 
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) { 
		 
        String username = (String) token.getPrincipal(); 
         //retrycount + 1 
        Object element = EhcacheUtils.getItem(username); 
        
        if (element == null) { 
            EhcacheUtils.putItem(username, 1); 
            element=0; 
        }
        else{ 
            int count=Integer.parseInt(element.toString())+1; 
            element=count; 
            EhcacheUtils.putItem(username,element); 
        } 
        
        AtomicInteger retryCount = new AtomicInteger(Integer.parseInt(element.toString())); 
        
        if (retryCount.incrementAndGet() > 50000) { 
             //if retrycount >5 throw 
            throw new ExcessiveAttemptsException(); 
        } 
        
        boolean matches = super.doCredentialsMatch(token, info); 
        
        if (matches) { 
            //clear retrycount 
            EhcacheUtils.removeItem(username); 
        } 
        return matches; 
    } 

}
