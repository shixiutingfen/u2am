package com.jiuling.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jiuling.core.base.BaseServiceImpl;
import com.jiuling.core.base.BaseDao;
import com.jiuling.core.util.RandomUtils;
import com.jiuling.core.util.StringUtils;
import com.jiuling.web.dao.SysPermissionMapper;
import com.jiuling.web.model.SysPermission;
import com.jiuling.web.model.SysPermissionExample;
import com.jiuling.web.service.PermissionService;

/**
 * 权限Service实现类
 *
 * @author YangXQ
 * @since 2016/1/11/11:00
 */
@Service
public class PermissionServiceImpl extends BaseServiceImpl<SysPermission, Long> implements PermissionService {

    @Resource
    private SysPermissionMapper permissionMapper;
    

    @Override
    public BaseDao<SysPermission, Long> getDao() {
        return permissionMapper;
    }

    @Override
    public List<SysPermission> selectPermissionsByRoleId(Long roleId) {
        return permissionMapper.selectPermissionsByRoleId(roleId);
    }
    
    /**
     * 删除权限
     * @param resourceId
     * @return
     */
    @Override
    public int deletePermissionsByResourceId(Long resourceId) {
    	SysPermissionExample example = new SysPermissionExample();
    	example.createCriteria().andResourceIdEqualTo(resourceId);
        return permissionMapper.deleteByExample(example);
    }
    
    /**
     * 新增权限
     * @param permission
     * @return
     */
    @Override
    public int insertPermission(SysPermission permission)
    {
    	Long permissionId = RandomUtils.getCurrentTime();
    	permission.setPermissionId(permissionId);
    	return permissionMapper.insert(permission);
    }
    
   
	  
    
    /**
     * 查询权限列表
     * @param permission
     * @return
     */
    public List<SysPermission> selectPermissionsByName(SysPermission permission)
    {
    	SysPermissionExample example = new SysPermissionExample();
    	if (StringUtils.isNotEmptyString(permission.getPermissionName()))
    	{
    		example.createCriteria().andPermissionNameLike("%"+permission.getPermissionName()+"%");
    	}
    	if (StringUtils.isNotEmptyString(permission.getResourceName()))
    	{
    		example.createCriteria().andResourceNameLike("%"+permission.getResourceName()+"%");
    	}
    	return permissionMapper.selectByExample(example);
    }
}
