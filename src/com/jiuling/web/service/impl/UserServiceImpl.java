package com.jiuling.web.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jiuling.core.base.BaseDao;
import com.jiuling.core.base.BaseServiceImpl;
import com.jiuling.core.feature.orm.mybatis.Page;
import com.jiuling.core.util.ContxtUtils;
import com.jiuling.core.util.DateTime;
import com.jiuling.core.util.EndecryptUtils;
import com.jiuling.core.util.StringUtils;
import com.jiuling.core.util.ValidateHelper;
import com.jiuling.web.bo.UserBo;
import com.jiuling.web.constants.CommonConstants;
import com.jiuling.web.dao.SysDeptMapper;
import com.jiuling.web.dao.SysRoleMapper;
import com.jiuling.web.dao.SysUserMapper;
import com.jiuling.web.dao.SysUserRoleMapper;
import com.jiuling.web.model.SysRole;
import com.jiuling.web.model.SysUser;
import com.jiuling.web.model.SysUserExample;
import com.jiuling.web.model.SysUserRole;
import com.jiuling.web.model.SysUserRoleExample;
import com.jiuling.web.service.DeptService;
import com.jiuling.web.service.RoleService;
import com.jiuling.web.service.UserService;

/**
 * 用户Service实现类
 *
 * @author YangXQ
 * @since 2016/1/11/11:00
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<SysUser, Long> implements UserService {
	@Resource
	private SysUserMapper userMapper;
	@Resource
	private SysUserRoleMapper userRoleMapper;
	@Resource
	private SysRoleMapper roleMapper;
	@Resource
	private SysDeptMapper deptMapper;
	@Resource
	private DeptService deptService;
	@Resource
	private RoleService roleService;

	@Override
	public int insert(SysUser model) {
		return userMapper.insertSelective(model);
	}

	@Override
	public int update(SysUser model) {
		return userMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public int delete(Long id) {
		SysUserRoleExample example = new SysUserRoleExample();
		example.createCriteria().andUserIdEqualTo(id);
		userRoleMapper.deleteByExample(example);
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public SysUser authentication(SysUser user) {
		return userMapper.authentication(user);
	}

	@Override
	public SysUser selectById(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public BaseDao<SysUser, Long> getDao() {
		return userMapper;
	}

	@Override
	public SysUser selectByUsername(String username) {
		SysUserExample example = new SysUserExample();
		example.createCriteria().andUsernameEqualTo(username);
		final List<SysUser> list = userMapper.selectByExample(example);
		return (null == list || list.size() == 0) ? null : list.get(0);
	}

	/**
	 * 查询用户列表
	 * 
	 * @param username
	 * @return
	 */
	@Override
	public List<UserBo> selectSysUserList(Page<UserBo> page, SysUser user) {
		int count = 0;
		SysUserExample example = new SysUserExample();
		// 查询个数
		count = userMapper.countByExample(example);

		// 个数大于0
		if (count > 0) {
			List<UserBo> sysUserList = new ArrayList<UserBo>();
			sysUserList = userMapper.selectUsersByPage(page, user);

			// 根据uerID查询角色信息
			setRoleInfo(sysUserList);

			return sysUserList;
		} else {
			return null;
		}

	}

	private void setRoleInfo(List<UserBo> sysUserList) {
		if (ValidateHelper.isNotEmptyList(sysUserList)) {
			for (UserBo userBo : sysUserList) {
				SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
				sysUserRoleExample.createCriteria().andUserIdEqualTo(userBo.getUserId());
				List<SysUserRole> sysUserRoleList = userRoleMapper.selectByExample(sysUserRoleExample);
				if (ValidateHelper.isNotEmptyList(sysUserRoleList)) {
					StringBuffer roleStrbuf = new StringBuffer();
					for (SysUserRole sysUserRole : sysUserRoleList) {
						SysRole role = roleMapper.selectByPrimaryKey(sysUserRole.getRoleId());
						if (null != role) {
							roleStrbuf.append(role.getRoleName()).append(",");
						}
					}

					if (roleStrbuf.toString().length() >= 1) {
						String roleStr = roleStrbuf.toString().substring(0, roleStrbuf.toString().length() - 1);
						userBo.setRoleName(roleStr);
					}
				}
			}
		}
	}

	/**
	 * 保存用户
	 * 
	 * @param roleId
	 * @param user
	 * @return
	 */
	public int saveUser(SysUserRole userRole, SysUser user) {
		// MD5加密
		if (StringUtils.isNotEmptyString(user.getPassword())) {
			user.setPassword(EndecryptUtils.GetMD5Code(user.getPassword()));
		}

		SysUser currentUser = ContxtUtils.getUserSession();
		if (null != currentUser) {
			user.setCreateUserId(currentUser.getUserId());
			user.setCreateUserName(currentUser.getUsername());
			user.setCreateTime(DateTime.getCurrentTime());
		}
		user.setIsvalid("1");

		userRoleMapper.insert(userRole);

		return userMapper.insert(user);
	}

	/**
	 * 保存用户
	 * 
	 * @param userRoleList
	 * @param user
	 * @return
	 */

	@Override
	public int saveUser(List<SysUserRole> userRoleList, SysUser user) {
		// MD5加密
		if (StringUtils.isNotEmptyString(user.getPassword())) {
			user.setPassword(EndecryptUtils.GetMD5Code(user.getPassword()));
		}

		SysUser currentUser = ContxtUtils.getUserSession();
		if (null != currentUser) {
			user.setCreateUserId(currentUser.getUserId());
			user.setCreateUserName(currentUser.getUsername());
			user.setCreateTime(DateTime.getCurrentTime());
		}
		user.setIsvalid("1");

		// 增加多条
		if (ValidateHelper.isNotEmptyList(userRoleList)) {
			for (SysUserRole sysUserRole : userRoleList) {
				userRoleMapper.insert(sysUserRole);
			}
		}

		return userMapper.insert(user);
	}

	/**
	 * 新增用户的时候 分配云空间
	 * 
	 * @param userId
	 */
	@SuppressWarnings("unused")
	@Override
	public void createCloudSpaceforUser(SysUserRole sysUserRole) {
		Long cloudSize = 0l;
		if (null != sysUserRole.getRoleId()) {
			SysRole role = userMapper.selectByRoleId(sysUserRole.getRoleId());
			if (sysUserRole.getUserId() != 1) {
				if (role.getRoleName().equals(CommonConstants.ROLE_ENTERING)) {
					cloudSize = (long) 500 * (1024 * 1024 * 1024);
				} else {
					cloudSize = (long) 100 * (1024 * 1024 * 1024);
				}
			}
		}
	}

	/**
	 * 保存用户
	 * 
	 * @param userRoleList
	 * @param user
	 * @return
	 */

	@Override
	public int saveRoleUser(List<SysUserRole> userRoleList) {
		// 增加多条
		if (ValidateHelper.isNotEmptyList(userRoleList)) {
			for (SysUserRole sysUserRole : userRoleList) {
				userRoleMapper.insert(sysUserRole);
			}
		}

		return 1;
	}

	/**
	 * 更新用户
	 * 
	 * @param roleId
	 * @param user
	 * @return
	 */
	public int updateUser(SysUserRole userRole, SysUser user) {

		if (null != userRole.getRoleId()) {
			userRoleMapper.updateByPrimaryKeySelective(userRole);
		}

		return userMapper.updateByPrimaryKeySelective(user);
	}

	/**
	 * 更新用户密码到数据库
	 * 
	 * @param user
	 * @return
	 */
	public int updateUserPwd(SysUser user) {
		if (StringUtils.isEmptyString(user.getPassword())) {
			return 0;
		}
		return userMapper.updateByPrimaryKeySelective(user);
	}

	/**
	 * 删除用户
	 * 
	 * @param userId
	 * @return
	 */
	public int deleteUser(Long userId) {

		if (null != userId) {
			// 删除用户角色关系
			SysUserRoleExample example = new SysUserRoleExample();
			example.createCriteria().andUserIdEqualTo(userId);
			userRoleMapper.deleteByExample(example);
		}

		return delete(userId);
	}

	public List<SysUser> selectUsers(SysUserExample example) {
		return userMapper.selectByExample(example);
	}

	public boolean isUserNameExist(String userName) {
		SysUserExample example = new SysUserExample();
		example.createCriteria().andUsernameEqualTo(userName);
		return userMapper.selectByExample(example).size() > 0;
	}

	@Override
	public int deleteSysUserRole(Long id) {
		return userRoleMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 关键字查询 联合搜索 用户名、真实姓名 两个字段
	 */
	@Override
	public List<SysUser> selectUsers(String searchKey) {
		return userMapper.selectBySearchKey(searchKey);
	}

	@Override
	public boolean isIdNumberExist(Long userId, String idNumber) {

		SysUserExample example = new SysUserExample();
		if (null != userId) {
			example.createCriteria().andUserIdNotEqualTo(userId).andIdNumberEqualTo(idNumber);
		} else {
			example.createCriteria().andIdNumberEqualTo(idNumber);
		}

		return userMapper.selectByExample(example).size() > 0;
	}

	/**
	 * 根据姓名和证件查询用户
	 * 
	 * @param certId
	 * @param realname
	 * @return
	 */
	@Override
	public SysUser selectByCertIdAndRealName(String certId, String realname) {
		SysUserExample example = new SysUserExample();
		example.createCriteria().andRealNameEqualTo(realname).andIdNumberEqualTo(certId);
		final List<SysUser> list = userMapper.selectByExample(example);
		return (null == list || list.size() == 0) ? null : list.get(0);
	}

	@Override
	public List<UserBo> selectByimg(UserBo userBo) {
		return userMapper.selectByimg(userBo);
	}

	@Override
	public List<SysUser> selectOthersUsers(Long userId) {
		return userMapper.selectOthersUsers(userId);
	}

	public List<SysUser> selectByPage(Page<SysUser> pages, Map<String, Object> params) {
		SysUserExample example = new SysUserExample();
		return userMapper.selectByExample(pages, example);
	}

}
