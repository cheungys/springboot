package com.zys.boot.base.config;

import com.zys.boot.base.utils.StringUtil;
import com.zys.boot.user.dao.PermissionMapper;
import com.zys.boot.user.dao.RoleMapper;
import com.zys.boot.user.dao.UserMapper;
import com.zys.boot.user.entity.Permission;
import com.zys.boot.user.entity.Role;
import com.zys.boot.user.entity.User;
import com.zys.boot.user.service.LoginService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyShiroRealm extends AuthorizingRealm {
    @Resource
    private LoginService loginService;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private PermissionMapper permissionMapper;
    @Resource
    private UserMapper userMapper;
    /**
     * 用户认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        // 加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        // 获取用户信息
        String name = authenticationToken.getPrincipal().toString();
        User user = loginService.findByName(name);
        if (user == null) {
            // 这里返回后会报出对应异常
            return null;
        } else {
            // 这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name,
                    user.getPassword().toString(), getName());
            return simpleAuthenticationInfo;
        }
    }

    /**
     * 角色权限和对应权限添加
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取登录用户名
        String name = (String) principalCollection.getPrimaryPrincipal();
        // 查询用户名称
        User user = loginService.findByName(name);
        List<Role> roleList ;
        if (StringUtil.isNotEmpty(user)){
            roleList = roleMapper.getRoleListByUserId(user.getUserId().toString());
            if (!roleList.isEmpty()){
                for (Role role: roleList){
                    List<Permission> permissionList = permissionMapper.getPermissionListByRoleId(role.getId());
                    if (!permissionList.isEmpty()){
                        role.setPermissions(permissionList);
                    }
                }
                user.setRoles(roleList);
            }
        }
        // 添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Role role : user.getRoles()) {
            // 添加角色
            simpleAuthorizationInfo.addRole(role.getRoleName());
            for (Permission permission : role.getPermissions()) {
                // 添加权限
                simpleAuthorizationInfo.addStringPermission(permission.getPermissionName());
            }
        }
        return simpleAuthorizationInfo;
    }
}
