package com.jiuling.web.security;

/**
 * 权限标识配置类, <br>
 * 与 permission 权限表 中的 permission_sign 字段 相对应 <br>
 * 使用:
 * 
 * <pre>
 * &#064;RequiresPermissions(value = PermissionConfig.USER_CREATE)
 * public String create() {
 *     return &quot;拥有user:create权限,能访问&quot;;
 * }
 * </pre>
 * 
 * @author YangXQ
 * @since 2016/1/11/11:00
 **/
public class PermissionSign {

    /**
     * 用户新增权限 标识
     */
    public static final String USER_CREATE = "user:create";

    /**
     * 用户删除权限 标识
     */
    public static final String USER_DELETE = "user:delete";

    /**
     * 用户更新权限 标识
     */
    public static final String USER_UPDATE = "user:update";
    
    /**
     * 角色新增权限 标识
     */
    public static final String ROLE_CREATE = "role:create";

    /**
     * 角色删除权限 标识
     */
    public static final String ROLE_DELETE = "role:delete";

    /**
     * 角色更新权限 标识
     */
    public static final String ROLE_UPDATE = "role:update";
    
    

}
