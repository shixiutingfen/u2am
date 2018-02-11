package com.jiuling.web.dao;

import com.jiuling.core.base.BaseDao;
import com.jiuling.core.feature.orm.mybatis.Page;
import com.jiuling.web.model.SysRole;
import com.jiuling.web.model.SysRoleExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysRoleMapper extends BaseDao<SysRole, Long>{
    int countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int deleteByPrimaryKey(Long roleId);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleExample example);

    SysRole selectByPrimaryKey(Long roleId);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
    
    /**
     * 通过用户id 查询用户 拥有的角色
     * 
     * @param id
     * @return
     */
    List<SysRole> selectRolesByUserId(Long userId);
    
    /**
     * 分页查询
     * @param example
     * @return
     */
    List<SysRole> selectByExample(Page<SysRole> page,SysRoleExample example);
    
   /**
    * 根据权限名称模糊查询拥有该权限的角色
    */
    List<SysRole> selectByPermissonName(Page<SysRole> page,Map<String,Object> map);
}