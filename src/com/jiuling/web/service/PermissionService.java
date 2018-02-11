package com.jiuling.web.service;

import java.util.List;

import com.jiuling.core.base.BaseService;
import com.jiuling.web.model.SysPermission;

/**
 * 权限 业务接口
 * 
 * @author YangXQ
 * @since 2016/1/11/21:20
 **/
public interface PermissionService extends BaseService<SysPermission, Long> {

    /**
     * 通过角色id 查询角色 拥有的权限
     * 
     * @param roleId
     * @return
     */
    List<SysPermission> selectPermissionsByRoleId(Long roleId);
    
    /**
     * 新增权限
     * @param permission
     * @return
     */
    int insertPermission(SysPermission permission);
    /**
     * 删除权限
     * @param resourceId
     * @return
     */
    int deletePermissionsByResourceId(Long resourceId);
    /**
     * 查询权限列表
     * @param permission
     * @return
     */
    public List<SysPermission> selectPermissionsByName(SysPermission permission);

}
