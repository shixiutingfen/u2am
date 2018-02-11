package com.jiuling.web.service;

import java.util.List;
import java.util.Map;

import com.jiuling.core.base.BaseService;
import com.jiuling.core.feature.orm.mybatis.Page;
import com.jiuling.web.bo.UserBo;
import com.jiuling.web.model.SysUser;
import com.jiuling.web.model.SysUserExample;
import com.jiuling.web.model.SysUserRole;

/**
 * 用户 业务 接口
 * 
 * @author YangXQ
 * @since 2016/1/11/20:20
 **/
public interface UserService extends BaseService<SysUser, Long> {

    /**
     * 用户验证
     * 
     * @param user
     * @return
     */
    SysUser authentication(SysUser user);

    /**
     * 根据用户名查询用户
     * 
     * @param username
     * @return
     */
    SysUser selectByUsername(String username);
    
    /**
     * 查询用户列表
     * 
     * @param username
     * @return
     */
    public List<UserBo> selectSysUserList(Page<UserBo> page,SysUser user);
    
    /**
     * 保存用户
     * @param user
     * @return
     */
    int saveUser(SysUserRole userRole,SysUser user);
    
    /**
     * 新增云空间
     * @param userId
     */
    void createCloudSpaceforUser(SysUserRole sysUserRole);
    /**
     * 更新用户
     * @param roleId
     * @param user
     * @return
     */
    int updateUser(SysUserRole userRole,SysUser user);
    
    
    /**
     * 更新用户密码到数据库
     * @param user
     * @return
     */
    int updateUserPwd(SysUser user);
    
    /**
     * 删除用户
     * @param userId
     * @return
     */
    int deleteUser(Long userId);
    
    List<SysUser> selectUsers(SysUserExample example);
    
    List<SysUser> selectOthersUsers(Long userId);
    
    boolean isUserNameExist(String userName);
    
    int saveUser(List<SysUserRole> userRoleList, SysUser user);
    
    int saveRoleUser(List<SysUserRole> userRoleList);
    
    public int deleteSysUserRole(Long id);

    /**
     * 关键字查询用户 
     * @param searchKey 用户名、真实姓名
     * @return
     */
	List<SysUser> selectUsers(String searchKey);
	
	 /**
     * 根据姓名和证件查询用户
     * 
     * @param certId
     * @param realname
     * @return
     */
    SysUser selectByCertIdAndRealName(String certId,String realname);
	/**
	 * 判断证件号重复
	 * @param userId
	 * @param idNumber
	 * @return
	 */
	boolean isIdNumberExist(Long userId,String idNumber);
	
	List<UserBo>  selectByimg(UserBo userBo);
    
	List<SysUser> selectByPage(Page<SysUser> pages,Map<String,Object> params);
}
