package com.jiuling.web.security;

/**
 * 角色标识配置类, <br>
 * 与 role_info 角色表中的 role_sign 字段 相对应 <br>
 * 使用:
 * 
 * <pre>
 * &#064;RequiresRoles(value = RoleSign.ADMIN)
 * public String admin() {
 *     return &quot;拥有admin角色,能访问&quot;;
 * }
 * </pre>
 * 
 * @author YangXQ
 * @since 2016/1/11/11:00
 **/
public class RoleSign {

    /**
     * 普通后台管理员 标识
     */
    public static final String ADMIN = "admin";

    /**
     * 普通部门管理员 标识
     */
    public static final String MANAGER = "manger";
    
    /**
     * 普通操作员 标识
     */
    public static final String OPER = "oper";
    

}
