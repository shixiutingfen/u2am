package com.jiuling.web.model;

import java.io.Serializable;
import java.util.Date;

public class SysUser implements Serializable{
    
    private static final long serialVersionUID = 1667921742311759247L;
    
    private Long userId;

    private Long groupId;

    private String username;

    private String password;

    private String realName;

    private String idNumber;

    private String tel;

    private String remark;

    private String deptId;

    private String isvalid;

    private String isDeptAdmin;

    private String themes;

    private Long createUserId;

    private String createUserName;

    private Date createTime;
    
    /**
     * ��ɫids
     */
    private String roleId;
    
    public SysUser() {

    }

    public SysUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
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

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
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

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public String getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(String isvalid) {
        this.isvalid = isvalid == null ? null : isvalid.trim();
    }

    public String getIsDeptAdmin() {
        return isDeptAdmin;
    }

    public void setIsDeptAdmin(String isDeptAdmin) {
        this.isDeptAdmin = isDeptAdmin == null ? null : isDeptAdmin.trim();
    }

    public String getThemes() {
        return themes;
    }

    public void setThemes(String themes) {
        this.themes = themes == null ? null : themes.trim();
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRoleId()
    {
        return roleId;
    }

    public void setRoleId(String roleId)
    {
        this.roleId = roleId;
    }
    
    /**
     * �жϲ��Ź���Ա
     * 
     * @return
     */
    public boolean isDeptAdmin() {
        return  "1".equals(this.isDeptAdmin) ? true : false;
    }

    /**
     * �ж�ϵͳ����Ա
     * 
     * @return
     */
    public boolean isSysAdmin() {
        return "2".equals(this.isDeptAdmin)  ? true : false;
    }

    /**
     * �ж���ͨ����Ա
     * 
     * @return
     */
    public boolean isGeneralOperator() {
        return "0".equals(this.isDeptAdmin)  ? true : false;
    }
    
}