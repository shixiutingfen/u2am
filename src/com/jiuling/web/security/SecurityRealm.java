package com.jiuling.web.security;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import com.jiuling.web.model.SysPermission;
import com.jiuling.web.model.SysRole;
import com.jiuling.web.model.SysUser;
import com.jiuling.web.service.PermissionService;
import com.jiuling.web.service.RoleService;
import com.jiuling.web.service.UserService;

/**  
 * 用户身份验证,授权 Realm 组件
 * 
 * @author YangXQ
 * @since 2016/1/11/11:00
 **/
@Component(value = "securityRealm")
public class SecurityRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private PermissionService permissionService;

    /**
     * 权限检查
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String username = String.valueOf(principals.getPrimaryPrincipal());

        final SysUser user = userService.selectByUsername(username);
        final List<SysRole> roleInfos = roleService.selectRolesByUserId(user.getUserId());
        for (SysRole role : roleInfos) {
            // 添加角色
            System.err.println(role);
            authorizationInfo.addRole(role.getRoleSign());

            final List<SysPermission> permissions = permissionService.selectPermissionsByRoleId(role.getRoleId());
            for (SysPermission permission : permissions) {
                // 添加权限
                System.err.println(permission);
                authorizationInfo.addStringPermission(permission.getPermissionSign());
            }
        }
        return authorizationInfo;
    }

    /**
     * 登录验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = String.valueOf(token.getPrincipal());
        String password = new String((char[]) token.getCredentials());
        // 通过数据库进行验证
        final SysUser authentication = userService.authentication(new SysUser(username, password));
        if (authentication == null) {
            throw new AuthenticationException("账号或密码错误 ！");
        }
        String isValid = authentication.getIsvalid();
        if(!"1".equals(isValid)){
        	throw new AuthenticationException("账号已停用");
        }
        SimpleAuthenticationInfo authenticationInfo = null;
        //密码校验
        //if (EndecryptUtils.checkMd5Password(username,password,authentication.getPassword()))
       // {
         authenticationInfo = new SimpleAuthenticationInfo(username, password, getName());
        //}
        return authenticationInfo;
    }

}
