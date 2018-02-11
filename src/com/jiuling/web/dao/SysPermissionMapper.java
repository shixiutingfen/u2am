package com.jiuling.web.dao;

import com.jiuling.core.base.BaseDao;
import com.jiuling.web.model.SysPermission;
import com.jiuling.web.model.SysPermissionExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysPermissionMapper   extends BaseDao<SysPermission, Long>{
    int countByExample(SysPermissionExample example);

    int deleteByExample(SysPermissionExample example);

    int deleteByPrimaryKey(Long permissionId);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    List<SysPermission> selectByExample(SysPermissionExample example);

    SysPermission selectByPrimaryKey(Long permissionId);

    int updateByExampleSelective(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    int updateByExample(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);
    

    /**
     * 通过角色id 查询角色 拥有的权限
     * 
     * @param roleId
     * @return
     */
    List<SysPermission> selectPermissionsByRoleId(Long roleId);
    
    /**
     * 通过角色id 菜单
     * 
     * @param roleId
     * @return
     */
    List<SysPermission> selectMenuByRoleId(Long roleId);
    
}