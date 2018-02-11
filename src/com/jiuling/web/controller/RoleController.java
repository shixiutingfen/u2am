package com.jiuling.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jiuling.core.feature.orm.mybatis.Page;
import com.jiuling.core.util.RandomUtils;
import com.jiuling.core.util.StringUtils;
import com.jiuling.web.constants.CommonConstants;
import com.jiuling.web.model.SysPermission;
import com.jiuling.web.model.SysRole;
import com.jiuling.web.model.SysRolePermission;
import com.jiuling.web.service.RoleService;

/**
 * 角色管理控制器
 * 
 * @author YangXQ
 * @since 2016/1/27/11:00
 **/
@Controller
@RequestMapping("/role")
public class RoleController {
  
	 @Resource
	 private RoleService roleService;
	 
	   /**
	     * 基于权限标识的权限控制案例
	     */
	    @RequestMapping(value = "/create")
	    @ResponseBody
	    public Map<String,Object> create(String permissionIds,SysRole role,Model m) {
	    	
	    	Map<String, Object> result = new HashMap<String, Object>();
	    	result.put("state", true);
	    	Long roleId = RandomUtils.getCurrentTime();
	    	role.setRoleId(roleId);
	    	//role.setCreateTime(createTime);
	    	
	    	List<SysRolePermission> rolePermissionList = new ArrayList<SysRolePermission>();
	    	
	    	if (StringUtils.isNotEmptyString(permissionIds))
	    	{
	    		String[] permissionIdArr = permissionIds.split(",");
	    		for(String str : permissionIdArr)
	    		{
	    			SysRolePermission rolePerm = new SysRolePermission();
	    			Long rolePermissionId = Long.parseLong(RandomUtils.get18TimeRandom());
	    			rolePerm.setRoleId(roleId);
	    			rolePerm.setRolePermissionId(rolePermissionId);
	    			rolePerm.setPermissionId(Long.parseLong(str));
	    			rolePermissionList.add(rolePerm);
	    		}
	    	}
	    	
	    	
	    	try{
	    		roleService.insert(role,rolePermissionList);
	    	}catch(Exception e){
	    		result.put("state", false);
	    		result.put("msg", CommonConstants.DELETE_FAILURE);
				e.printStackTrace();
	    	}
	    	 return result;
	    }
	    
	    /**
	     * 基于权限标识的权限控制案例
	     */
	    @RequestMapping(value = "/update")
	    @ResponseBody
	    public Map<String,Object> update(String permissionIds,SysRole role,Model m) {
	    	
	    	Map<String, Object> result = new HashMap<String, Object>();
	    	result.put("state", true);
	    
	    	List<SysRolePermission> rolePermissionList = new ArrayList<SysRolePermission>();
	    	
	    	if (StringUtils.isNotEmptyString(permissionIds))
	    	{
	    		String[] permissionIdArr = permissionIds.split(",");
	    		for(String str : permissionIdArr)
	    		{	
					SysRolePermission rolePerm = new SysRolePermission();
					Long rolePermissionId = RandomUtils.getCurrentTime();
					rolePerm.setRoleId(role.getRoleId());
					rolePerm.setRolePermissionId(rolePermissionId);
					rolePerm.setPermissionId(Long.parseLong(str));
					rolePermissionList.add(rolePerm);
	    		}
	    	}
	    	
	    	
	    	try{
	    		roleService.update(role,rolePermissionList);
	    	}catch(Exception e){
	    		result.put("state", false);
	    		result.put("msg", CommonConstants.UPDATE_FAILURE);
				e.printStackTrace();
	    	}
	    	 return result;
	    }
	    
	/**
     * 角色页面
     */
    @RequestMapping(value = "/sysRoleMgr")
    @ResponseBody
    public ModelAndView sysRoleMgr(Model m) {
        /*SysUser currentUser = ContxtUtils.getUserSession();
        if (null != currentUser.getUserId())
        {
            m.addAttribute("cerentUserId", currentUser.getUserId());
            List<SysRole> rols =   roleService.selectRolesByUserId(currentUser.getUserId());
            if (null != rols)
            {
                m.addAttribute("cerentRoleId",rols.get(0).getRoleId());
            }
        }*/
        return new ModelAndView("systemsettings/roleList");
    }
    
    /**
     * 基于权限标识的权限控制案例
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Map<String, Object> delete(String roleId,Model m) {
    	Map<String, Object> result = new HashMap<String, Object>();
    	result.put("state", true);
    	try{
    		roleService.delete(Long.parseLong(roleId));
    	}catch(Exception e){
    		result.put("state", false);
    		result.put("msg", CommonConstants.DELETE_FAILURE);
			e.printStackTrace();
    	}
        return result;
    }
    
	/**
	 * 打开新增用户页面
	 */
	@RequestMapping(value = "/openaddrole")
	@ResponseBody
	public ModelAndView openRoleAdd(Model m) {
		
		 
		//获取全部权限列表
		Map<String,Object> map = new HashMap<String,Object>();
		
    	List<SysPermission> permissionList =  roleService.selectPermissionList(map);
    	List<SysPermission> permiMuneList = new ArrayList<SysPermission>();
    	if (null != permissionList && permissionList.size()>0)
    	{
    		for (SysPermission perm : permissionList)
    		{
    			if (perm.getResourceType() == 1)
    			{
    				permiMuneList.add(perm);
    			}
    		}
    	}
    	m.addAttribute("permiMuneList",permiMuneList);
 	    m.addAttribute("permissionList",permissionList);
	    return new ModelAndView("systemsettings/roleAdd");
	}   
	
	/**
	 * 打开修改页面
	 */
	@RequestMapping(value = "/openmodifyrole")
	@ResponseBody
	public ModelAndView openRoleUpdate(String roleId,Model m) {
		
		 
		//获取全部权限列表
		Map<String,Object> map = new HashMap<String,Object>();
		
		SysRole sysrole = roleService.selectRoleByRoleId(new Long(roleId));
		
		Set<Long>  currentPerimissions = roleService.getPermissionByRoleId(new Long(roleId));
		
    	List<SysPermission> permissionList =  roleService.selectPermissionList(map);
    	List<SysPermission> permiMuneList = new ArrayList<SysPermission>();
    	if (null != permissionList && permissionList.size()>0)
    	{
    		for (SysPermission perm : permissionList)
    		{
    			if (currentPerimissions.contains(perm.getResourceId()))
    			{
    				perm.setActionId(Long.valueOf("0"));
    			}
    			if (perm.getResourceType() == 1)
    			{
    				permiMuneList.add(perm);
    			}
    			
    		}
    	}
    	m.addAttribute("sysRole",sysrole);
    	m.addAttribute("permiMuneList",permiMuneList);
 	    m.addAttribute("permissionList",permissionList);
	    return new ModelAndView("systemsettings/roleUpdate");
	}   
	    
    /**
     * 查询权限列表
     * @param name
     * @param sex
     * @param m
     * @return
     */
    @RequestMapping(value="/queryPermission",method = RequestMethod.POST)
    @ResponseBody
    public String queryPermission(Model m){
        Map<String,Object> map = new HashMap<String,Object>();
    	List<SysPermission> permissionList =  roleService.selectPermissionList(map);
 	   m.addAttribute("permissionList",permissionList);
 	   return "success";
    }
    
    /**
     * jqgrid查询带分页
     * @param name
     * @param sex
     * @param m
     * @return
     * @throws UnsupportedEncodingException 
     */
    @RequestMapping(value="/queryByPage")
    @ResponseBody
    public Map<String, Object> queryUsers(HttpServletRequest request) throws Exception{
    	
    	String page = request.getParameter("page"); // 取得当前页数,注意这是jqgrid自身的参数 
		String rows = request.getParameter("rows"); // 取得每页显示行数，,注意这是jqgrid自身的参数
		
    	String roleName = request.getParameter("roleName");  
		String permissionName = request.getParameter("permissionName"); 
		
		if (null != roleName)
		{
			roleName = URLDecoder.decode(roleName,"utf-8");
		}
		if (null != permissionName)
		{
			permissionName = URLDecoder.decode(permissionName,"utf-8");
		}
		
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		
		parameterMap.put("roleName", roleName);
		
		parameterMap.put("permissionName", permissionName);
		
    	Page<SysRole> pages = new Page<SysRole>(Integer.parseInt(page),Integer.parseInt(rows));
    	roleService.selectSysRoleList(pages, parameterMap);
    	
    	Map<String, Object> result = new HashMap<String, Object>();
    	result.put("rows", pages.getResult());//列表数据
    	result.put("total", pages.getTotalPages());//总页数
    	result.put("records",pages.getTotalCount());//总记录数
 	   return result;
    }
}