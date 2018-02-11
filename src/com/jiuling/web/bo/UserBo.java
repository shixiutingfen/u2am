package com.jiuling.web.bo;

import com.jiuling.core.base.BaseBo;

public class UserBo extends BaseBo {

    private static final long serialVersionUID = 16136624242373468L;

    /**
     * 登陆用户id
     */
    private Long userId;

    /**
     * 登陆用户名
     */
    private String username;

    /**
     * 登陆用户密码
     */
    private String password;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 电话
     */
    private String tel;

    /**
     * 备足
     */
    private String remark;

    /**
     * 部门id
     */
    private Long deptId;

    /**
     * 是否禁用
     */
    private Integer isvalid;

    /**
     * 是否管理员
     */
    private Integer isDeptAdmin;

    /**
     * 主题id
     */
    private Integer themes;

    /**
     * 创建用户
     */
    private Long createUserId;

    /**
     * 创建用户名称
     */
    private String createUserName;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;
    
    private Long id;
    
    private String avatar;
    
    private String sign;
    
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Integer getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Integer isvalid) {
        this.isvalid = isvalid;
    }

    public Integer getIsDeptAdmin() {
        return isDeptAdmin;
    }

    public void setIsDeptAdmin(Integer isDeptAdmin) {
        this.isDeptAdmin = isDeptAdmin;
    }

    public Integer getThemes() {
        return themes;
    }

    public void setThemes(Integer themes) {
        this.themes = themes;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
