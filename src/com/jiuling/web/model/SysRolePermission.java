package com.jiuling.web.model;

import java.io.Serializable;

public class SysRolePermission implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1634047830024926638L;

	private Long rolePermissionId;

    private Long roleId;

    private Long permissionId;

    public Long getRolePermissionId() {
        return rolePermissionId;
    }

    public void setRolePermissionId(Long rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}