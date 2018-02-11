package com.jiuling.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jiuling.core.util.StringUtils;
import com.jiuling.web.constants.CommonConstants;
import com.jiuling.web.dao.ModuleMapper;
import com.jiuling.web.model.Module;
import com.jiuling.web.model.ModuleExample;
import com.jiuling.web.model.ModuleExample.Criteria;
import com.jiuling.web.model.SysPermission;
import com.jiuling.web.service.ModuleService;
import com.jiuling.web.service.PermissionService;
import com.jiuling.web.service.RoleService;
/**
 * 菜单模块service实现类
 * @author ShiXt  2016年1月13日
 */
@Service
public class ModuleServiceImpl implements ModuleService {
	
	@Resource
	private ModuleMapper moduleMapper;
	
	 @Resource
	 private RoleService roleService;
	 
	 @Resource
	 private PermissionService permissionService;
	 
	 
	
	@Override
	public void insertModule(Module module) {
		moduleMapper.insert(module);
		SysPermission permission = new SysPermission();
		permission.setResourceId(module.getModuleId());
		permission.setResourceName(module.getModuleName());
		permission.setPermissionName(module.getModuleName());
		permission.setResourceType(module.getModuleLevel());
		permission.setActionId(Long.valueOf("1"));
		permission.setFunctionCode(module.getModuleUrl());
		if (null != module.getParentId())
		{
		 permission.setPermissionSign(module.getParentId()+"");
		}
		permissionService.insertPermission(permission);
		
	}

	@Override
	public void updateModule(Module module) {
		moduleMapper.updateByPrimaryKey(module);

	}
	

	@Override
	public List<Module> selectModules(ModuleExample moduleExample) {
		moduleExample.setOrderByClause("module_id asc");
		return moduleMapper.selectByExample(moduleExample);
	}

	@Override
	public boolean hasChildren(Long id) {
		Module m = this.selectById(id);
		ModuleExample moduleExample = new ModuleExample();
		moduleExample.createCriteria().andLongNumberLike("%"+m.getLongNumber()+"%");
		List<Module> modules = moduleMapper.selectByExample(moduleExample);
		return modules.size()>1;
	}

	@Override
	public List<Module> findChildren(Long level, String longNumber) {
		ModuleExample moduleExample = new ModuleExample();
		moduleExample.setOrderByClause("seq asc");
		Criteria criteria = moduleExample.createCriteria();
		if (longNumber != null && longNumber.trim().length() > 0) {
			criteria.andModuleLevelEqualTo(level+1);
			criteria.andLongNumberLike("%"+longNumber+"%");
		} else {
			criteria.andModuleLevelEqualTo(level);
		}
		return moduleMapper.selectByExample(moduleExample);
	}
	
	@Override
	public int findChildrenSeq(Long parentId) {
		ModuleExample moduleExample = new ModuleExample();
		Criteria criteria = moduleExample.createCriteria();
		if (parentId != null) {
			criteria.andParentIdEqualTo(parentId);
		} else {
			criteria.andParentIdIsNull();
		}
		return moduleMapper.selectSeqByExample(moduleExample);
	}



	@Override
	public Module selectById(Long id) {
		return moduleMapper.selectByPrimaryKey(id);
	}
	/**
	 * 首先判断是否为叶子节点：非叶子节点，则删除本级以及本级以下菜单
	 * 叶子节点:首先判断父节点除本节点外是否还有其余子节点，如果没有，则删除本节点后，更改leaf状态
	 * 如果除本节点外还有其余子节点，则直接删除本节点
	 * @param id
	 */
	@Override
	public void deleteModule(Long id) {
		Module m = this.selectById(id);
		if(m.getLeaf().equals(1)){//叶子节点
			ModuleExample parentExample = new ModuleExample();
			Criteria parentCriteria = parentExample.createCriteria();
			parentCriteria.andLongNumberEqualTo(StringUtils.getParentLongNumber(m.getLongNumber(), CommonConstants.MODULE_SPLIT));
			List<Module> moduleList = moduleMapper.selectByExample(parentExample);
			if(moduleList.size()>0){
				Module parent=moduleList.get(0);
				if(parent!=null){
					ModuleExample isOnlyLeaf = new ModuleExample();
					isOnlyLeaf.createCriteria().andLongNumberLike("%"+parent.getLongNumber()+"%").andModuleLevelEqualTo(m.getModuleLevel()).andModuleIdNotEqualTo(m.getModuleId());
					List<Module> modules= moduleMapper.selectByExample(isOnlyLeaf);
					if(modules.size()==0){//没有其他叶子节点
						parent.setLeaf(Long.valueOf("1"));
						moduleMapper.updateByPrimaryKey(parent);//更新leaf状态
					}
				}
			}
			moduleMapper.deleteByPrimaryKey(id);
		}else{//非叶子节点
			ModuleExample moduleExample = new ModuleExample();
			Criteria criteria = moduleExample.createCriteria();
			criteria.andLongNumberLike("%"+m.getLongNumber()+"%");
			List<Module> allModules=moduleMapper.selectByExample(moduleExample);
			List<Long> ids=new ArrayList<Long>();
			for(Module module:allModules){
				ids.add(module.getModuleId());
			}
			moduleExample.clear();
			moduleExample.createCriteria().andModuleIdIn(ids);
			moduleMapper.deleteByExample(moduleExample);
		}
		
		//删除对应权限
		permissionService.deletePermissionsByResourceId(m.getModuleId());
	}

	public int selectMaxLevel() {
		return moduleMapper.selectMaxModuleLevel();
	}

	public Module selectModuleByUrl(String url) {
		ModuleExample example = new ModuleExample();
		example.createCriteria().andModuleUrlLike("%"+url+"%");
		List<Module> modules = moduleMapper.selectByExample(example);
		Module module = new Module();
		if(modules.size()>0){
			module = modules.get(0);
		}
		return module;
	}

}
