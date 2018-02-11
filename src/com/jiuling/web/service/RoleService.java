package com.jiuling.web.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jiuling.core.base.BaseService;
import com.jiuling.core.feature.orm.mybatis.Page;
import com.jiuling.web.model.SysPermission;
import com.jiuling.web.model.SysRole;
import com.jiuling.web.model.SysRolePermission;
import com.jiuling.web.model.SysUserRole;

/**
 * 角色 业务接口
 * 
 * @author YangXQ
 * @since 2016/1/11/20:20
 **/
public interface RoleService extends BaseService<SysRole, Long> {
    /**
     * 通过用户id 查询用户 拥有的角色
     * 
     * @param userId
     * @return
     */
    List<SysRole> selectRolesByUserId(Long userId);
   
    /**
     * 查询角色
     * 
     * @param userId
     * @return
     */
    List<SysRole> selectRoles();
  
    int insert(SysRole model,List<SysRolePermission> rolePermissionList);

    int update(SysRole model,List<SysRolePermission> rolePermissionList);

    int delete(Long id);
    
    SysRole selectRoleByRoleId(Long roleId);
    
    /**
     * 通过模糊名称查询所有角色
     * 
     * @param sysRole
     * @return
     */
    List<SysRole> selectRolesByName(SysRole sysRole);
    
    /**
     * 分页查询角色列表
     * 
     * @param page 分页信息
     * @param map 查询条件 
     * @return  
     */
    List<SysRole> selectSysRoleList(Page<SysRole> page,Map<String,Object> map);
    
    /**
     * 查询角色列表
     * 
     * @param page 分页信息
     * @param map 查询条件 
     * @return  
     */
    List<SysPermission> selectPermissionList(Map<String,Object> map);
    
    
    /**
     * 通过userId查询用户角色关系表
     * @param userId
     * @return
     */
    List<SysUserRole> selectUserRolesByUserId(Long userId);
    
    /**
     * 通过名称查询所有权限
     * 
     * @param userId
     * @return
     */
    Set<Long>  getPermissionByUserId(Long userId);
    
    /**
     * 通过角色查询所有对应权限
     * 
     * @param roleId
     * @return
     */
    Set<Long>  getPermissionByRoleId(Long roleId);
    
}
