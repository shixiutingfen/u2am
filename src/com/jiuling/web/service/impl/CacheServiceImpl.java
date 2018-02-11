package com.jiuling.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jiuling.core.util.EhcacheUtils;
import com.jiuling.web.constants.CacheItemConstants;
import com.jiuling.web.dao.ModuleMapper;
import com.jiuling.web.model.Module;
import com.jiuling.web.model.ModuleExample;
import com.jiuling.web.service.CacheService;
/**
 * 缓存项加载接口
 * @author Administrator
 *
 */
@Service
public class CacheServiceImpl implements CacheService {

	/**
	 * 菜单表
	 */
	@Resource
	private ModuleMapper moduleMapper;
	
	/**
	 * 模块菜单缓存
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, List<Module>> getModuleMenuCache() {
		
		Map<String, List<Module>> modulMap = null;
		
		modulMap = (Map<String, List<Module>>)EhcacheUtils.getItem(CacheItemConstants.MENU_MAP);
		
		if (null == modulMap || modulMap.isEmpty())
		{
			modulMap = new HashMap<String, List<Module>>();
			ModuleExample moduleExample1 = new ModuleExample();
			moduleExample1.createCriteria().andModuleLevelEqualTo(1L).andStateEqualTo("1");
			moduleExample1.setOrderByClause("seq asc");
			List<Module> module1list =  moduleMapper.selectByExample(moduleExample1);
			if (null != module1list)
			{
				modulMap.put(CacheItemConstants.MENU_1, module1list);
			}
			ModuleExample moduleExample2 = new ModuleExample();
			moduleExample2.createCriteria().andModuleLevelEqualTo(2L).andStateEqualTo("1");
			moduleExample2.setOrderByClause("seq asc");
			List<Module> module2list =  moduleMapper.selectByExample(moduleExample2);
			if (null != module2list)
			{
				modulMap.put(CacheItemConstants.MENU_1_1, module2list);
			}
			ModuleExample moduleExample3 = new ModuleExample();
			moduleExample3.createCriteria().andModuleLevelEqualTo(3L).andStateEqualTo("1");
			moduleExample3.setOrderByClause("seq asc");
			List<Module> module3list =  moduleMapper.selectByExample(moduleExample3);
			if (null != module3list)
			{
				modulMap.put(CacheItemConstants.MENU_1_1_1, module3list);
			}
			//放入缓冲
			EhcacheUtils.putItem(CacheItemConstants.MENU_MAP, modulMap);
			
		}
		return modulMap;
	}
}
