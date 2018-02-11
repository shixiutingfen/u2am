package com.jiuling.web.interaceptor;
import java.io.Serializable;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;

/**
 * 缓存方法拦截器核心代码 <br/>
 * 对你要拦截的类的方法进行拦截，
 * 然后判断该方法的类路径+方法名称+参数值组合的cache key在缓存cache中是否存在。
 * 如果存在就从缓存中取出该对象，转换成我们要的返回类型。没有的话就把该方法返回的对象添加到缓存中
 * @author YANGXQ
 * @createDate 2016-02-02
 * @version 1.0
 */
public class MethodCacheInterceptor implements MethodInterceptor, InitializingBean{
	
	private static final Logger log = Logger.getLogger(MethodCacheInterceptor.class);
	    
	    private Cache cache;
	 
	    public void setCache(Cache cache) {
	        this.cache = cache;
	    }
	 
	    public void afterPropertiesSet() throws Exception {
	        log.info(cache + " A cache is required. Use setCache(Cache) to provide one.");
	    }
	 
	    public Object invoke(MethodInvocation invocation) throws Throwable {
	        String targetName = invocation.getThis().getClass().getName();
	        String methodName = invocation.getMethod().getName();
	        Object[] arguments = invocation.getArguments();
	        Object result;
	 
	        String cacheKey = getCacheKey(targetName, methodName, arguments);
	        Element element = null;
	        synchronized (this) {
	            element = cache.get(cacheKey);
	            if (element == null) {
	                log.info(cacheKey + "加入到缓存： " + cache.getName());
	                // 调用实际的方法
	                result = invocation.proceed();
	                element = new Element(cacheKey, (Serializable) result);
	                cache.put(element);
	            } else {
	                log.info(cacheKey + "使用缓存： " + cache.getName());
	            }
	        }
	        return element.getValue();
	    }
	 
	    /**
	     *返回具体的方法全路径名称 参数
	     * @param targetName 全路径
	     * @param methodName 方法名称
	     * @param arguments 参数
	     * @return 完整方法名称
	     */
	    private String getCacheKey(String targetName, String methodName, Object[] arguments) {
	        StringBuffer sb = new StringBuffer();
	        sb.append(targetName).append(".").append(methodName);
	        if ((arguments != null) && (arguments.length != 0)) {
	            for (int i = 0; i < arguments.length; i++) {
	                sb.append(".").append(arguments[i]);
	            }
	        }
	        return sb.toString();
	    }
}
