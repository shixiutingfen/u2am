package com.jiuling.web.service;

import java.util.List;
import java.util.Map;

import com.jiuling.web.model.Module;

/**
 * 缓存项加载接口
 * @author Administrator
 *
 */
public interface CacheService {

	/**
	 * 模块菜单缓存
	 */
	Map<String,List<Module>> getModuleMenuCache();
	
}
