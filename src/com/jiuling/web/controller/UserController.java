package com.jiuling.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jiuling.core.base.BaseController;
import com.jiuling.core.feature.orm.mybatis.Page;
import com.jiuling.core.util.ContxtUtils;
import com.jiuling.core.util.EndecryptUtils;
import com.jiuling.core.util.RandomUtils;
import com.jiuling.core.util.StringUtils;
import com.jiuling.core.util.ValidateHelper;
import com.jiuling.web.bo.UserBo;
import com.jiuling.web.constants.CommonConstants;
import com.jiuling.web.model.SysDept;
import com.jiuling.web.model.SysPermission;
import com.jiuling.web.model.SysRole;
import com.jiuling.web.model.SysUser;
import com.jiuling.web.model.SysUserRole;
//import com.jiuling.web.security.PermissionSign;
import com.jiuling.web.security.RoleSign;
import com.jiuling.web.service.DeptService;
import com.jiuling.web.service.PermissionService;
import com.jiuling.web.service.RoleService;
import com.jiuling.web.service.UserService;

/**
 * 用户控制器
 * 
 * @author YangXQ
 * @since 2016/1/11/11:00
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {
	@Resource
	private UserService userService;
	@Resource
	private PermissionService permissionService;
	@Resource
	private RoleService roleService;
	@Resource
	private DeptService deptService;

	/**
	 * 用户登录
	 * 
	 * @author YangXQ
	 * @since 2016/1/11/11:00
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Valid SysUser user, BindingResult result, Model model, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		try {
			// 得到Subject
			Subject subject = SecurityUtils.getSubject();
			if (result.hasErrors()) {
				model.addAttribute("error", "参数错误！");
				return "login";
			}
			user.setPassword(EndecryptUtils.GetMD5Code(user.getPassword()));
			// 创建用户名/密码身份验证Token(即用户身份/凭证)
			AuthenticationToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
			// 设置登陆token
			subject.login(token);
			// 验证成功在Session中保存用户信息
			final SysUser authUserInfo = userService.selectByUsername(user.getUsername());
			request.getSession().setAttribute("userInfo", authUserInfo);
			// 更新shiro session
			Session session = subject.getSession();
			session.removeAttribute("userInfo");
			session.setAttribute("userInfo", authUserInfo);
			request.getSession().setAttribute("userLoginName", authUserInfo.getRealName());
		}

		catch (ExcessiveAttemptsException ex) {
			model.addAttribute("error", "帐号被锁定1小时 ！");
			ex.printStackTrace();
		}

		catch (AuthenticationException e) {
			// 身份验证失败
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "login";
		}
		return "redirect:/";
	}

	/**
	 * 用户登录 提供给第三方
	 * 
	 * @author YangXQ
	 * @since 2016/1/11/11:00
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("all")
	@RequestMapping(value = "/thirdlogin")
	public String thirdlogin(String i, HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			SysUser user = new SysUser();
			String endecryInfo = EndecryptUtils.decryptBase64(i);
			if (StringUtils.isNotEmptyString(endecryInfo)) {
				String ustr = endecryInfo.split("&")[0];
				String pswstr = endecryInfo.split("&")[1];
				user.setUsername(ustr.split("=")[1]);
				user.setPassword(pswstr.split("=")[1]);
			}
			// 得到Subject
			Subject subject = SecurityUtils.getSubject();

			user.setPassword(EndecryptUtils.GetMD5Code(user.getPassword()));// 加密
			// 创建用户名/密码身份验证Token(即用户身份/凭证)
			AuthenticationToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
			// 设置登陆token
			subject.login(token);
			// 验证成功在Session中保存用户信息
			final SysUser authUserInfo = userService.selectByUsername(user.getUsername());
			request.getSession().setAttribute("userInfo", authUserInfo);
			// 更新shiro session
			Session session = subject.getSession();
			session.removeAttribute("userInfo");
			session.setAttribute("userInfo", authUserInfo);
			request.getSession().setAttribute("userLoginName", authUserInfo.getRealName());
		} catch (ExcessiveAttemptsException ex) {
			ex.printStackTrace();
		} catch (AuthenticationException e) {
			// 身份验证失败
			e.printStackTrace();
		}
		return "redirect:/";
	}

	/**
	 * 用户登出
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("userInfo");
		// 登出操作
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "login";
	}

	/**
	 * 基于角色 标识的权限控制案例
	 */
	@RequestMapping(value = "/admin")
	@ResponseBody
	@RequiresRoles(value = RoleSign.ADMIN)
	public String admin() {
		return "拥有admin角色,能访问";
	}

	/**
	 * 基于权限标识的权限控制案例
	 */
	@RequestMapping(value = "/createUser")
	@ResponseBody
	public Map<String, Object> createUser(@ModelAttribute("user") @Valid SysUser sysuser, Model m) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("state", true);

		// 校验用户是否存在
		boolean isUserNameExist = userService.isUserNameExist(sysuser.getUsername());
		if (isUserNameExist) {
			result.put("state", false);
			result.put("msg", "用户名:" + sysuser.getUsername() + "已经存在");
			return result;
		}

		if (StringUtils.isNotEmptyString(sysuser.getIdNumber())) {
			boolean isIdNumberExist = userService.isIdNumberExist(null, sysuser.getIdNumber());
			if (isIdNumberExist) {
				result.put("state", false);
				result.put("msg", "证件编号:" + sysuser.getIdNumber() + "已经注册");
				return result;
			}
		}

		// 设置部门管理员标识
		setDeptAdmin(sysuser);

		Long userId = RandomUtils.getCurrentTime();
		sysuser.setUserId(userId);

		// sys_user_role记录增加
		List<SysUserRole> userRoleList = setSysUserRoles(sysuser);

		try {
			userService.saveUser(userRoleList, sysuser);

			// 添加用户的时候，分配云空间（审核员默认分配512M 录入员默认分配1G）
			if (ValidateHelper.isNotEmptyList(userRoleList)) {
				for (SysUserRole sysUserRole : userRoleList) {
					userService.createCloudSpaceforUser(sysUserRole);
				}
			}

		} catch (Exception e) {
			result.put("state", false);
			result.put("msg", CommonConstants.CREATE_FAILURE);
			e.printStackTrace();
		}

		return result;
	}

	private List<SysUserRole> setSysUserRoles(SysUser sysuser) {
		List<SysUserRole> userRoleList = new ArrayList<SysUserRole>();
		if (StringUtils.isNotEmptyString(sysuser.getRoleId())) {
			String[] roles = sysuser.getRoleId().split(",");

			for (int i = 0; i < roles.length; i++) {
				SysUserRole userRole = new SysUserRole();

				Long userRoleId = RandomUtils.getCurrentTime();
				userRole.setUserRoleId(userRoleId);
				userRole.setUserId(sysuser.getUserId());
				userRole.setRoleId(Long.parseLong(roles[i]));
				userRoleList.add(userRole);
			}
		}
		return userRoleList;
	}

	private void setDeptAdmin(SysUser sysuser) {
		if (StringUtils.isNotEmptyString(sysuser.getRoleId())) {
			String[] roles = sysuser.getRoleId().split(",");

			StringBuffer roleType = new StringBuffer();
			for (int i = 0; i < roles.length; i++) {
				SysRole sysRole = roleService.selectRoleByRoleId(new Long(roles[i]));
				if (null != sysRole) {
					roleType.append(sysRole.getRoleSign()).append(";");
				}
			}
			String roleTypeStr = roleType.toString();

			// 系统管理员
			if (roleTypeStr.contains(RoleSign.ADMIN)) {
				sysuser.setIsDeptAdmin("1");
			}
			// 设置部门管理员
			else if (roleTypeStr.contains(RoleSign.MANAGER)) {
				sysuser.setIsDeptAdmin("2");
			}
			// 普通操作员
			else {
				sysuser.setIsDeptAdmin("0");
			}
		}
	}

	/**
	 * 基于权限标识的权限控制案例
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public Map<String, Object> updateUser(String currentRoleId, SysUser user, String usernameold, Model m) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("state", true);

		String userName = user.getUsername();
		boolean isUserNameExist = userService.isUserNameExist(user.getUsername());
		if (!userName.equals(usernameold)) {// 用户名修改过
			if (isUserNameExist) {
				result.put("state", false);
				result.put("msg", "用户名已经存在");
				return result;
			}
		}

		if (StringUtils.isNotEmptyString(user.getIdNumber())) {
			boolean isIdNumberExist = userService.isIdNumberExist(user.getUserId(), user.getIdNumber());
			if (isIdNumberExist) {
				result.put("state", false);
				result.put("msg", "证件编号:" + user.getIdNumber() + "已经注册");
				return result;
			}
		}

		if (StringUtils.isEmptyString(user.getPassword())) {
			user.setPassword(null);
		}
		/*
		 * else{
		 * user.setPassword(EndecryptUtils.GetMD5Code(user.getPassword())); }
		 */

		try {
			// 删除就的sys_user_role记录
			deleteTheOldUserRoles(user);

			// 增加新的sys_user_role记录
			List<SysUserRole> userRoleList = setSysUserRoles(user);
			userService.saveRoleUser(userRoleList);

			// 更新sys_user数据
			userService.update(user);
		} catch (Exception e) {
			result.put("state", false);
			result.put("msg", CommonConstants.UPDATE_FAILURE);
			e.printStackTrace();
		}

		return result;
	}

	private void deleteTheOldUserRoles(SysUser user) {
		// 获取用户对应的sys_user_role记录
		List<SysUserRole> userRoles = roleService.selectUserRolesByUserId(user.getUserId());

		// 删除用户已有的sys_user_role记录
		for (SysUserRole sysUserRole : userRoles) {
			userService.deleteSysUserRole(sysUserRole.getUserRoleId());
		}
	}

	/**
	 * 用户页面
	 */
	@RequestMapping(value = "/sysUserMgr")
	@ResponseBody
	public ModelAndView sysUserMgr(Model m) {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		SysUser currentUser = (SysUser) session.getAttribute("userInfo");
		m.addAttribute("cerentUserId", currentUser.getUserId());

		if (null != currentUser.getUserId()) {
			List<SysRole> rols = roleService.selectRolesByUserId(currentUser.getUserId());
			if (null != rols) {
				m.addAttribute("cerentRoleId", rols.get(0).getRoleId());
			}
		}

		return new ModelAndView("systemsettings/userList");
	}

	/**
	 * 用户列表修改用户密码
	 */
	@RequestMapping(value = "/changeSelectedPwd")
	@ResponseBody
	public ModelAndView changeSelectedPwd(HttpSession session, String userId, String username, Model m) {
		SysUser currentUser = (SysUser) session.getAttribute("userInfo");
		m.addAttribute("userId", userId);
		m.addAttribute("username", username);
		m.addAttribute("currentUsername", currentUser.getUsername());
		return new ModelAndView("systemsettings/changeselectedpwd");
	}

	/**
	 * 当前操作员密码修改
	 */
	@RequestMapping(value = "/changePwd")
	@ResponseBody
	public ModelAndView changePwd(Model m) {
		return new ModelAndView("systemsettings/changepwd");
	}

	/**
	 * 保存当前操作员新密码
	 */
	@RequestMapping(value = "/saveSelectedNewPwd")
	@ResponseBody
	public Map<String, Object> saveSelectedNewPwd(HttpServletRequest request, Model m) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", false);
		result.put("msg", "修改失败");
		String userIdStr = request.getParameter("userId");
		// String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("confirmpassword");
		String confirmpassword = request.getParameter("confirmpassword");
		Long userId = new Long(userIdStr);

		SysUser sysuer = userService.selectById(userId);
		if (null != sysuer) {
			if (StringUtils.isNotEmptyString(newpassword) && StringUtils.isNotEmptyString(confirmpassword)
					&& newpassword.equals(confirmpassword)) {
				// 更新新的用户密码到数据库
				SysUser sysuser = new SysUser();
				sysuser.setUserId(userId);
				sysuser.setPassword(EndecryptUtils.GetMD5Code(newpassword));
				int rst = userService.updateUserPwd(sysuser);
				if (rst > 0) {
					result.put("status", true);
					// request.getSession().setAttribute("userInfo", sysuser);
				}

			} else {
				result.put("msg", "新密码与确认密码不一致");
			}
		}

		return result;
	}

	/**
	 * 保存当前操作员新密码
	 */
	@RequestMapping(value = "/saveNewPwd")
	@ResponseBody
	public Map<String, Object> saveNewPwd(HttpServletRequest request, Model m) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", false);
		result.put("msg", "修改失败");
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("confirmpassword");
		String confirmpassword = request.getParameter("confirmpassword");
		Long userId = ContxtUtils.getUserSession().getUserId();
		String pwd = ContxtUtils.getUserSession().getPassword();
		String oldpasswordMd5 = EndecryptUtils.GetMD5Code(oldpassword);
		// 旧密码必须和登录密码相等
		if (StringUtils.isNotEmptyString(oldpassword) && pwd.equals(oldpasswordMd5)) {
			if (StringUtils.isNotEmptyString(newpassword) && StringUtils.isNotEmptyString(confirmpassword)
					&& newpassword.equals(confirmpassword)) {
				if (!oldpassword.equals(newpassword)) {
					// 更新新的用户密码到数据库
					SysUser sysuser = new SysUser();
					sysuser.setUserId(userId);
					sysuser.setPassword(EndecryptUtils.GetMD5Code(newpassword));
					int rst = userService.updateUserPwd(sysuser);
					if (rst > 0) {
						result.put("status", true);
						request.getSession().setAttribute("userInfo", sysuser);
					}
				} else {
					result.put("msg", "新密码不能与旧密码一致");
				}
			} else {
				result.put("msg", "新密码与确认密码不一致");
			}
		} else {
			result.put("msg", "旧密码不正确");
		}
		return result;
	}

	/**
	 * 打开新增用户页面
	 */
	@RequestMapping(value = "/openAdduser")
	@ResponseBody
	public ModelAndView openUserAdd(Model m) {
		// 获取全部角色列表
		List<SysRole> roles = roleService.selectRoles();
		m.addAttribute("roleList", roles);
		return new ModelAndView("systemsettings/userAdd");
	}

	/**
	 * 打开修改用户页面
	 */
	@RequestMapping(value = "/openModifyuser")
	@ResponseBody
	public ModelAndView openUserModify(String userId, Model m) {

		SysUser sysUser = userService.selectById(new Long(userId));

		if (null == sysUser) {
			return null;
		}
		// 用户角色
		List<SysRole> userRole = roleService.selectRolesByUserId(Long.parseLong(userId));

		// 全部角色列表
		List<SysRole> roles = roleService.selectRoles();

		// 如果不是系统管理员,则过滤掉系统管理员权限
		getMatchRoles(sysUser, roles);

		// 当前用户对应角色
		if (null != userRole && userRole.size() > 0) {
			for (SysRole role : roles) {
				// 角色记录是用户已经有的角色
				if (role.getRoleId().compareTo(userRole.get(0).getRoleId()) == 0) {
					role.setCreateUserId(Long.parseLong(userId));
				}

			}

			// 用户角色转str
			StringBuffer currentRoleBuf = new StringBuffer();
			for (SysRole role : userRole) {
				currentRoleBuf.append(role.getRoleId()).append(",");
			}
			String currentRoleStr = currentRoleBuf.toString().substring(0, currentRoleBuf.toString().length() - 1);

			m.addAttribute("currentRoleId", currentRoleStr);
		}

		m.addAttribute("sysUser", sysUser);
		m.addAttribute("roleList", roles);
		return new ModelAndView("systemsettings/userUpdate");
	}

	private void getMatchRoles(SysUser sysUser, List<SysRole> roles) {
		if (!"1".equals(sysUser.getIsDeptAdmin())) {
			if (ValidateHelper.isNotEmptyList(roles)) {
				for (SysRole role : roles) {
					if (1 == role.getRoleId()) {
						roles.remove(role);
						break;
					}
				}
			}
		}
	}

	/**
	 * 根据条件查询
	 * 
	 * @param name
	 * @param sex
	 * @param m
	 * @return
	 */
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView likeName(String username, String realName, Model m) {
		SysUser user = new SysUser();
		user.setUsername(username);
		user.setRealName(realName);
		int pageNo = 1;// 当前页编号
		int pageSize = 1;// 每页条数
		Page<UserBo> page = new Page<UserBo>(pageNo, pageSize);
		List<UserBo> userList = userService.selectSysUserList(page, user);
		m.addAttribute("userList", userList);
		return new ModelAndView("systemsettings/userList");
	}

	/**
	 * jqgrid查询带分页
	 * 
	 * @param name
	 * @param sex
	 * @param m
	 * @return
	 */
	@RequestMapping(value = "/queryByPage")
	@ResponseBody
	public Map<String, Object> queryUsers(String currentUserId, HttpServletRequest request) {
		String page = request.getParameter("page"); // 取得当前页数,注意这是jqgrid自身的参数
		String rows = request.getParameter("rows"); // 取得每页显示行数，,注意这是jqgrid自身的参数
		String username = request.getParameter("username");
		String realName = request.getParameter("realName");

		SysUser user = new SysUser();
		if (StringUtils.isNotEmptyString(username)) {
			user.setUsername("%" + username + "%");
		}
		if (StringUtils.isNotEmptyString(realName)) {
			user.setRealName("%" + realName + "%");
		}
		SysUser currentUser = ContxtUtils.getUserSession();
		if (null != currentUser) {
			System.out.println(currentUser.getUsername());
			if (currentUser.getUsername().equals("admin")) {
				user.setGroupId(null);
			} else {
				user.setGroupId(currentUser.getGroupId());
			}
		}
		Page<UserBo> pages = new Page<UserBo>(Integer.parseInt(page), Integer.parseInt(rows));
		userService.selectSysUserList(pages, user);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("rows", pages.getResult());// 列表数据
		result.put("total", pages.getTotalPages());// 总页数
		result.put("records", pages.getTotalCount());// 总记录数
		return result;
	}

	/**
	 * 权限列表
	 * 
	 * @return
	 */
	@RequestMapping("listPermission")
	@RequiresRoles(value = RoleSign.ADMIN)
	public ModelAndView listPermission(Model model) {
		SysPermission permission = new SysPermission();
		List<SysPermission> permissions = permissionService.selectPermissionsByName(permission);
		model.addAttribute("permissionList", permissions);
		return new ModelAndView("systemsettings/sysPermissionList");
	}

	/**
	 * 角色列表
	 * 
	 * @return
	 */
	@RequestMapping("listRole")
	@RequiresRoles(value = RoleSign.ADMIN)
	public ModelAndView listRoles(String roleName, String createUserName, Model model) {
		SysRole role = new SysRole();
		role.setRoleName(roleName);
		role.setCreateUserName(createUserName);
		List<SysRole> roles = roleService.selectRolesByName(role);
		model.addAttribute("roleList", roles);
		return new ModelAndView("systemsettings/sysRoleList");
	}

	@RequestMapping(value = "/getUser")
	@ResponseBody
	// @RequiresPermissions(value = PermissionSign.USER_DELETE)
	public Map<String, Object> getUser() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("state", true);
		try {
			SysUser user = ContxtUtils.getUserSession();
			result.put("userName", user.getRealName());
			SysDept dept = deptService.selectByDeptNumber(user.getDeptId(), true);
			result.put("deptName", dept.getDeptName());
			List<SysUserRole> userRoles = roleService.selectUserRolesByUserId(user.getUserId());
			if (userRoles.size() > 0) {
				SysRole role = roleService.selectById(userRoles.get(0).getRoleId());
				result.put("roleName", role.getRoleName());
			}
		} catch (Exception e) {
			result.put("state", false);
			result.put("msg", CommonConstants.QUERY_FAILURE);
			e.printStackTrace();
		}
		return result;
	}

}
