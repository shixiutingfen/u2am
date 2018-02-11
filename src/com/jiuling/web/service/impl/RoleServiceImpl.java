package com.jiuling.web.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jiuling.core.base.BaseDao;
import com.jiuling.core.base.BaseServiceImpl;
import com.jiuling.core.feature.orm.mybatis.Page;
import com.jiuling.core.util.RandomUtils;
import com.jiuling.core.util.StringUtils;
import com.jiuling.web.dao.SysPermissionMapper;
import com.jiuling.web.dao.SysRoleMapper;
import com.jiuling.web.dao.SysRolePermissionMapper;
import com.jiuling.web.dao.SysUserRoleMapper;
import com.jiuling.web.model.SysPermission;
import com.jiuling.web.model.SysPermissionExample;
import com.jiuling.web.model.SysRole;
import com.jiuling.web.model.SysRoleExample;
import com.jiuling.web.model.SysRolePermission;
import com.jiuling.web.model.SysRolePermissionExample;
import com.jiuling.web.model.SysUserRole;
import com.jiuling.web.model.SysUserRoleExample;
import com.jiuling.web.security.RoleSign;
import com.jiuling.web.service.RoleService;

/**
 * 角色Service实现类
 *
 * @author YangXQ
 * @since 2016/1/11/11:00
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<SysRole, Long> implements RoleService {

    @Resource
    private SysRoleMapper roleMapper;
    
    @Resource
    private SysRolePermissionMapper rolePermissionMapper;
    
    @Resource
    private SysPermissionMapper permiMapper;
    
    @Resource
    private SysUserRoleMapper userRoleMapper;

    @Override
    public BaseDao<SysRole, Long> getDao() {
        return roleMapper;
    }
    
    @Override
    public int insert(SysRole model,List<SysRolePermission> rolePermissionList) {
    	
    	if (rolePermissionList.size() > 0)
    	{
    	    //管理员设置用户操作权限
    	    if (RoleSign.ADMIN.equals(model.getRoleSign()))
            {
                for (int i =0;i<3;i++)
                {
                    SysRolePermission rolepermission = new SysRolePermission();
                    rolepermission.setPermissionId(Long.valueOf(i+1));
                    Long rolePermissionId = Long.parseLong(RandomUtils.get18TimeRandom());
                    rolepermission.setRolePermissionId(rolePermissionId);
                    rolepermission.setRoleId(model.getRoleId());
                    rolePermissionList.add(rolepermission);
                }
            }
    	    
    		for(SysRolePermission rolePermi : rolePermissionList)
    		{
    			rolePermissionMapper.insert(rolePermi);
    		}
    	}
    	
    	
    	
        return roleMapper.insertSelective(model);
    }

    @Override
    public int update(SysRole model,List<SysRolePermission> rolePermissionList) {
    	
    	//角色权限关系，先删再插
    	if(null != rolePermissionList && rolePermissionList.size()>0)
    	{
    	 
    		SysRolePermissionExample example = new SysRolePermissionExample();
    		com.jiuling.web.model.SysRolePermissionExample.Criteria criteria = example.createCriteria();
    		criteria.andRoleIdEqualTo(model.getRoleId());
    		
    		rolePermissionMapper.deleteByExample(example);
    		  //管理员设置用户操作权限
            if (RoleSign.ADMIN.equals(model.getRoleSign())){
                    for (int i =0;i<3;i++)
                    {
                        SysRolePermission rolepermission = new SysRolePermission();
                        rolepermission.setPermissionId(Long.valueOf(i+1));
                        Long rolePermissionId = Long.parseLong(RandomUtils.get18TimeRandom());
                        rolepermission.setRolePermissionId(rolePermissionId);
                        rolepermission.setRoleId(model.getRoleId());
                        rolePermissionList.add(rolepermission);
                    }
            }
    		for (SysRolePermission rolePer:rolePermissionList)
    		{
    			rolePer.setRolePermissionId(Long.parseLong(RandomUtils.get18TimeRandom()));
    			rolePermissionMapper.insert(rolePer);
    		}
    	}
    	
        return roleMapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public int delete(Long id) {
    	
    	SysRolePermissionExample example = new SysRolePermissionExample();
    	example.createCriteria().andRoleIdEqualTo(id);
    	rolePermissionMapper.deleteByExample(example);
    	
        return roleMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public SysRole selectRoleByRoleId(Long roleId) {
    	SysRole role = new SysRole();
    	SysRoleExample example = new SysRoleExample();
    	example.createCriteria().andRoleIdEqualTo(roleId);
    	List<SysRole> roles = roleMapper.selectByExample(example);
    	if (null != roles && roles.size()>0)
    	{
    		role= roles.get(0);
    	}
    	
        return role;
    }

    @Override
    public List<SysRole> selectRolesByUserId(Long userId) {
        return roleMapper.selectRolesByUserId(userId);
    }
    
    @Override
    public List<SysRole> selectRoles() {
    	SysRoleExample example = new SysRoleExample();
        return roleMapper.selectByExample(example);
    }
    
    /**
     * 通过userId查询用户角色关系表
     * @param userId
     * @return
     */
    @Override
    public List<SysUserRole> selectUserRolesByUserId(Long userId) {
    	
    	SysUserRoleExample example = new SysUserRoleExample();
    	example.createCriteria().andUserIdEqualTo(userId);
        return userRoleMapper.selectByExample(example);
    }
    
   
    /**
     * 通过模糊名称查询所有角色
     * 
     * @param sysRole
     * @return
     */
    @Override
    public List<SysRole> selectRolesByName(SysRole sysRole)
    {
    	
    	SysRoleExample example = new SysRoleExample();
    	if (StringUtils.isNotEmptyString(sysRole.getRoleName()))
    	{
    		example.createCriteria().andRoleNameLike("%"+sysRole.getRoleName()+"%");
    	}
    	if (StringUtils.isNotEmptyString(sysRole.getCreateUserName()))
    	{
    		example.createCriteria().andCreateUserNameLike("%"+sysRole.getCreateUserName()+"%");
    	}
    	return roleMapper.selectByExample(example);
    }
    
    /**
     * 通过名称查询所有权限id
     * 
     * @param userId
     * @return
     */
    @Override
    public Set<Long>  getPermissionByUserId(Long userId)
    {
    	
    	List<SysRole> roles = roleMapper.selectRolesByUserId(userId);
    	
    	Set<Long> currentp = new HashSet<Long>();
    	
    	if (null != roles && roles.size()>0)
    	{
    		currentp = getPermissionByRoleId(roles.get(0).getRoleId());
    	}
    	
	
    	return currentp;
    }
    
    /**
     * 通过角色查询所有对应权限
     * 
     * @param roleId
     * @return
     */
    @Override
    public Set<Long>  getPermissionByRoleId(Long roleId)
    {
    	
    	List<SysPermission> sysPermissions = new ArrayList<SysPermission>();
    	if (null != roleId)
    	{
    		sysPermissions = permiMapper.selectMenuByRoleId(roleId);
    	}
    	
    	Set<Long> currentp = new HashSet<Long>();
		for (SysPermission perm : sysPermissions)
		{
			currentp.add(perm.getResourceId());
			if (perm.getResourceType() > 0 && StringUtils.isNotEmptyString(perm.getPermissionSign()))
			{
				currentp.add(Long.parseLong(perm.getPermissionSign()));
			}
		}
    	return currentp;
    } 
    
 
    
    /**
     * 查询权限列表
     * 
     * @param page 分页信息
     * @param map 查询条件 
     * @return  
     */
    @Override
    public List<SysPermission> selectPermissionList(Map<String,Object> map)
    {
    	SysPermissionExample example = new SysPermissionExample();
    	example.setDistinct(true);
    	example.createCriteria().andResourceTypeGreaterThan(Long.valueOf("0"));
    	example.setOrderByClause("resource_id asc");
    	List<SysPermission> perimissions = permiMapper.selectByExample(example);
    	return perimissions;
    }
    
    /**
     * 查询角色列表
     * 
     * @param page 分页信息
     * @param map 查询条件 
     * @return  
     */
    @Override
    public List<SysRole> selectSysRoleList(Page<SysRole> page,Map<String,Object> map)
    {
    	List<SysRole> roles = null;
    	SysRoleExample  roleExample = new SysRoleExample();
    	
    	String roleName = (String)map.get("roleName");
    	String permissionName = (String)map.get("permissionName");
    	
    	//根据角色名称模糊查询角色
    	if (StringUtils.isNotEmptyString(roleName))
    	{
    		roleExample.createCriteria().andRoleNameLike("%"+roleName+"%");
    		roles= roleMapper.selectByExample(page,roleExample);
    	}
    	
    	//根据权限名称叉角色
    	if (StringUtils.isNotEmptyString(permissionName))
    	{
    		roles =  roleMapper.selectByPermissonName(page, map);
    	}
    	
    	//直接分页查询角色表
    	else
    	{
    		roles= roleMapper.selectByExample(page,roleExample);
    	}
    	
    	return roles;
    }

}
