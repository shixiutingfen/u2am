package com.jiuling.web.service;

import java.util.List;

import com.jiuling.web.model.Module;
import com.jiuling.web.model.ModuleExample;

/**
 * 菜单模块服务
 * @author ShiXt  2016年1月13日
 */
public interface ModuleService {
	/**
	 * 新增菜单
	 */
	 void insertModule(Module module);
	/**
	 * 修改菜单
	 */
	 void updateModule(Module module);
	 /**
	  * 删除菜单By id
	  */
	 void deleteModule(Long id);
	 /**
	  * 查询菜单
	  */
	 List<Module> selectModules(ModuleExample moduleExample);
	 
	 /**
	  * 是否有子菜单
	  */
	 boolean hasChildren(Long id);
	 /**
	  * 查询所有子菜单
	  */
	 List<Module> findChildren(Long level ,String longNumber);
	 /**
	  * 查询子菜单最大的编号顺序
	  */
	 int findChildrenSeq(Long parentId);
	 /**
	  * 根据id查询Module
	  */
	 Module selectById(Long id);
	 /**
	  * 获取最大级别菜单
	  */
	 int selectMaxLevel();
	 /**
	  * 根据modeuleurl查询module
	  */
	 Module selectModuleByUrl(String url);
}
