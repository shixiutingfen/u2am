package com.jiuling.web.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jiuling.core.base.BaseController;
import com.jiuling.core.util.ContxtUtils;
import com.jiuling.core.util.DateTimeUtils;
import com.jiuling.core.util.EhcacheUtils;
import com.jiuling.core.util.StringUtils;
import com.jiuling.web.constants.CacheItemConstants;
import com.jiuling.web.constants.CommonConstants;
import com.jiuling.web.model.Module;
import com.jiuling.web.model.SysUser;
import com.jiuling.web.service.CacheService;
import com.jiuling.web.service.ModuleService;
import com.jiuling.web.service.RoleService;
/**
 * 菜单模块控制器
 * @author ShiXt  2016年1月13日
 */
@Controller
@RequestMapping("/module")
public class ModuleController extends BaseController{
	@Resource
	private ModuleService moduleService;
	
	@Resource
	private RoleService roleService;
	
	@Resource
	private CacheService  cacheService;
	
	/**
	 * 菜单列表
	 * @return
	 */
	@RequestMapping("listModules")
	public ModelAndView listModules(){
		return new ModelAndView("systemsettings/modulemanage");
	}
	
	/**
	 * 获取菜单
	 * @param parentId父菜单id
	 */
	@RequestMapping(value = "/getTree/{parentId}")
	@ResponseBody
	public List<Map<String, Object>> moduleTree(HttpServletRequest request,
			@PathVariable("parentId") String parentId) throws Exception {
		List<Map<String, Object>> listData = new ArrayList<Map<String, Object>>();
		if (parentId == null || "null".equals(parentId)) {
			List<Module> mList = this.moduleService.findChildren( Long.valueOf("1"), null);
			listData = bulidTree(mList);
		} else {
			Module parentModule = this.moduleService.selectById(Long.parseLong(parentId));
			List<Module> mList = this.moduleService.findChildren(parentModule.getModuleLevel(), parentModule.getLongNumber());
			listData = bulidTree( mList);
		}
		return listData;
	}
	
	/**
	 * 获取子菜单的顺序编号
	 * @param parentId父菜单id
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/findSeq/{parentId}")
	@ResponseBody
	public Integer findSeq(HttpServletRequest request,
			@PathVariable("parentId") String parentId) throws Exception {
		int seq=0;
		List<Map<String, Object>> listData = new ArrayList<Map<String, Object>>();
		if (parentId == null || "null".equals(parentId)) {
			seq = this.moduleService.findChildrenSeq(null);
		} else {
			seq = this.moduleService.findChildrenSeq(Long.parseLong(parentId));
		}
		return seq;
	}
	
	/**
	 * 构建树
	 * @param tlist
	 * @return
	 * @throws Exception
	 */
	private List<Map<String, Object>> bulidTree( List<Module> tlist)
			throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (Module module : tlist) {
			Map<String, Object> treeNode = new HashMap<String, Object>();
			treeNode.put("moduleId", module.getModuleId());
			treeNode.put("moduleName", module.getModuleName());
			treeNode.put("moduleState", module.getState());
			treeNode.put("isVisible", module.getIsVisible());  //modify by shiwu_bin 2013-10-12
			treeNode.put("displayState", module.getState());
			treeNode.put("moduleUrl", module.getModuleUrl());
			treeNode.put("seq", module.getSeq());
			treeNode.put("moduleNumber", module.getModuleNumber());
			treeNode.put("moduleIcon", module.getModuleIcon());
			treeNode.put("moduleLevel", module.getModuleLevel());
			treeNode.put("info1", module.getInfo1());
			if (null !=module.getCreateTime()){
			  treeNode.put("createTime",new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(module.getCreateTime()));
			}
			treeNode.put("moduleDescription", module.getModuleDescription());
			if (this.moduleService.hasChildren( module.getModuleId())) {
				treeNode.put("state", "closed");
			}else{
				treeNode.put("state", "open");
			}
			list.add(treeNode);
		}
		return list;
	}
	/**
	 * 删除模块
	 */
	@RequestMapping(value = "/delModule/{id}")
	@ResponseBody
	public Map<String, Object> del(HttpServletRequest request,
			@PathVariable("id") String id) throws Exception {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("state", true);
		if (StringUtils.isNotEmptyString(id)) {
			try {
				moduleService.deleteModule(Long.parseLong(id));
			} catch (Exception e) {
				m.put("state", false);
				m.put("msg", CommonConstants.DELETE_FAILURE);
				e.printStackTrace();
			}
		} else {
			m.put("state", false);
			m.put("msg", CommonConstants.DELETE_FAILURE);
		}

        EhcacheUtils.removeItem(CacheItemConstants.MENU_MAP);
		return m;
	}
	/**
	 * 新增模块
	 */
	@RequestMapping(value = "/saveModule")
	@ResponseBody
	public Map<String, Object> saveModule(HttpServletRequest request,Module module) {
		 Map<String, Object> m = new HashMap<String, Object>();
	        try {
	            Long parentId = module.getModuleId();
	            Module parentModule = null;
	            module.setModuleId(System.currentTimeMillis());
	            if (parentId != null) {
	                parentModule = moduleService.selectById(parentId);
	            }
	            if (parentModule != null) {
	                if (1 == parentModule.getLeaf() ) {// 父级是叶子节点
	                    parentModule.setLeaf(0L);
	                    moduleService.updateModule(parentModule);// 更新父级节点状态
	                }
	                module.setModuleLevel(parentModule.getModuleLevel() + 1);
	                module.setLongNumber(parentModule.getLongNumber() + CommonConstants.MODULE_SPLIT + module.getModuleId());
	                module.setDisplayName(parentModule.getDisplayName() + CommonConstants.MODULE_SPLIT + module.getModuleName());
	                module.setParentId(parentModule.getModuleId());
	                SysUser user = ContxtUtils.getUserSession();
	                module.setCreatorId(user.getUserId());

	            } else {
	                module.setModuleLevel(1L);
	                module.setLongNumber(module.getModuleId() + "");
	                module.setDisplayName(module.getModuleName());
	            }
	            module.setLeaf(1L);// 新增的模块都为叶子节点
	            module.setIsVisible("1");
	            module.setCreateTime(DateTimeUtils.now());
	            moduleService.insertModule(module);
	            m.put("state", true);
	            m.put("id", module.getModuleId());
	        } catch (Exception e) {
	            e.printStackTrace();
	            m.put("state", false);
	            m.put("msg", e.getMessage());
	        }

	        EhcacheUtils.removeItem(CacheItemConstants.MENU_MAP);
	        return m;
	}
	/**
	 * 编辑模块
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/editModule")
	@ResponseBody
	public Map<String, Object> editModule(HttpServletRequest request,Module module,String moduleNameEncode) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
        Map<String, Object> m = new HashMap<String, Object>();
        try {
            Module moduleSource = moduleService.selectById(module.getModuleId());
            List<Module> mList = this.moduleService.findChildren(moduleSource.getModuleLevel(), moduleSource.getLongNumber());
            if (mList.size() > 0) {
                for (Module child : mList) {
                    child.setDisplayName(StringUtils.replaceStrWithLevel(child.getDisplayName(), CommonConstants.MODULE_SPLIT,
                            module.getModuleLevel().intValue(), module.getModuleName()));
                    child.setLongNumber(StringUtils.replaceStrWithLevel(child.getLongNumber(), CommonConstants.MODULE_SPLIT, module.getModuleLevel().intValue(),
                            module.getModuleId() + ""));
                    moduleService.updateModule(child);
                }
            }
            moduleSource.setDisplayName(StringUtils.replaceStrWithLevel(moduleSource.getDisplayName(), CommonConstants.MODULE_SPLIT,
                    module.getModuleLevel().intValue(), module.getModuleName()));
            moduleSource.setLongNumber(StringUtils.replaceStrWithLevel(moduleSource.getLongNumber(), CommonConstants.MODULE_SPLIT,
                    module.getModuleLevel().intValue(), module.getModuleId() + ""));
            moduleSource.setModuleName(moduleNameEncode);
            moduleSource.setModuleDescription(module.getModuleDescription());
            moduleSource.setModuleUrl(module.getModuleUrl());
            moduleSource.setModuleIcon(module.getModuleIcon());
            if (StringUtils.isNotEmptyString(module.getState())){
              moduleSource.setState(module.getState());
            }
            moduleSource.setModuleNumber(module.getModuleNumber());
            moduleSource.setSeq(module.getSeq());
            moduleSource.setInfo1(module.getInfo1());
            moduleSource.setCreateTime(DateTimeUtils.now());
            moduleService.updateModule(moduleSource);
            m.put("state", true);
        } catch (Exception e) {
            e.printStackTrace();
            m.put("state", false);
            m.put("msg", e.getMessage());
        }

        EhcacheUtils.removeItem(CacheItemConstants.MENU_MAP);
		return m;
	}
	
	/**
	 * 获取首页菜单
	 */
	@RequestMapping(value = "/mainPageMenu")
	@ResponseBody
	public Map<String, Object> mainPageMenu(HttpServletRequest request) throws Exception {
		
		Map<String, List<Module>> menuMap = cacheService.getModuleMenuCache();
		List<Module> modules1 = null;
		List<Module> modules2 = null;
		//List<Module> modules3 = null;
		//获取当前登陆用户信息
		SysUser user = ContxtUtils.getUserSession();
		Long userId = user.getUserId();
		Set<Long> permissionSet = roleService.getPermissionByUserId(userId);
		
		 Map<String, Object> m = new HashMap<String, Object>();
		 if (null != permissionSet){
			//第一级菜单
			 modules1 = menuMap.get(CacheItemConstants.MENU_1);
			 List<Module> newModules= new ArrayList<Module>();
			 for(Module modul:modules1){
				 if (permissionSet.contains(modul.getModuleId())
						 //&& "0".equals(modul.getInfo1())
						 ){
					 //第二级菜单
					 modules2 = menuMap.get(CacheItemConstants.MENU_1_1);
					 List<Module> children = new ArrayList<Module>();
					 for(Module module2:modules2){
						 if(StringUtils.getParentLongNumber(module2.getLongNumber(), CommonConstants.MODULE_SPLIT).equals(modul.getLongNumber())
								 && permissionSet.contains(module2.getModuleId())
								 //&& "0".equals(modul.getInfo1())
								 ){
							 children.add(module2);
						 }
					 }
					 modul.setChildren(children);
					 newModules.add(modul);
				 }
			}
			 m.put("rows", newModules);
		 }
		return m;
	}
	
	/**
	 * 获取案件关联菜单
	 */
	@RequestMapping(value = "/casePageMenu")
	@ResponseBody
	public Map<String, Object> casePageMenu(HttpServletRequest request) throws Exception {
		
		Map<String, List<Module>> menuMap = cacheService.getModuleMenuCache();
		List<Module> modules1 = null;
		List<Module> modules2 = null;
		//List<Module> modules3 = null;
		//获取当前登陆用户信息
		SysUser user = ContxtUtils.getUserSession();
		Long userId = user.getUserId();
		Set<Long> permissionSet = roleService.getPermissionByUserId(userId);
		
		 Map<String, Object> m = new HashMap<String, Object>();
		 if (null != permissionSet){
			//第一级菜单
			 modules1 = menuMap.get(CacheItemConstants.MENU_1);
			 List<Module> newModules= new ArrayList<Module>();
			 for(Module modul:modules1){
				 if (permissionSet.contains(modul.getModuleId())
						 && "1".equals(modul.getInfo1())){
					 //第二级菜单
					 modules2 = menuMap.get(CacheItemConstants.MENU_1_1);
					 List<Module> children = new ArrayList<Module>();
					 for(Module module2:modules2){
						 if(StringUtils.getParentLongNumber(module2.getLongNumber(), CommonConstants.MODULE_SPLIT).equals(modul.getLongNumber())
								 && permissionSet.contains(module2.getModuleId())
								 && "1".equals(modul.getInfo1())){
							 children.add(module2);
						 }
					 }
					 modul.setChildren(children);
					 newModules.add(modul);
				 }
			}
			 m.put("rows", newModules);
		 }
		return m;
	}
	
	
	/**
	 * 编辑模块
	 */
	@RequestMapping(value = "/listChild")
	@ResponseBody
	public Map<String, Object> listChild(HttpServletRequest request,Module module) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			Module moduleSource  = moduleService.selectById(module.getModuleId());
			List<Module> mList = this.moduleService.findChildren(moduleSource.getModuleLevel(), moduleSource.getLongNumber());
			if(mList.size()>0){
				for(Module child:mList){
					child.setDisplayName(StringUtils.replaceStrWithLevel(child.getDisplayName(), CommonConstants.MODULE_SPLIT, module.getModuleLevel().intValue(), module.getModuleName()));
					child.setLongNumber(StringUtils.replaceStrWithLevel(child.getLongNumber(), CommonConstants.MODULE_SPLIT, module.getModuleLevel().intValue(), module.getModuleNumber()));
					moduleService.updateModule(child);
				}
			}
			moduleSource.setDisplayName(StringUtils.replaceStrWithLevel(moduleSource.getDisplayName(), CommonConstants.MODULE_SPLIT, module.getModuleLevel().intValue(), module.getModuleName()));
			moduleSource.setLongNumber(StringUtils.replaceStrWithLevel(moduleSource.getLongNumber(), CommonConstants.MODULE_SPLIT, module.getModuleLevel().intValue(), module.getModuleNumber()));
			moduleSource.setModuleName(module.getModuleName());
			moduleSource.setModuleDescription(module.getModuleDescription());
			moduleSource.setModuleUrl(module.getModuleUrl());
			moduleSource.setModuleIcon(module.getModuleIcon());
			moduleSource.setState(module.getState());
			moduleSource.setModuleNumber(module.getModuleNumber());
			moduleService.updateModule(moduleSource);
			m.put("state", true);
		} catch (Exception e) {
			e.printStackTrace();
			m.put("state", false);
			m.put("msg", e.getMessage());
		}
		return m;
	}
	
	/**
	 * 获取首页菜单
	 */
/*	@RequestMapping(value = "/mainMenu")
	@ResponseBody
	public Map<String, Object> mainMenu(HttpServletRequest request) throws Exception{
		
	}*/
	
	
	@RequestMapping("totest")
	public ModelAndView totest(){
		
		return new ModelAndView("test");
	}
}
