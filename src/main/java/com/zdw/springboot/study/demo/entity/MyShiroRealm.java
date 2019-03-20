package com.zdw.springboot.study.demo.entity;

import com.zdw.springboot.study.demo.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        /*权限配置*/
        User user = (User) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        List<Role> roleList = user.getRoleList();
        for (Role role : roleList) {
            authorizationInfo.addRole(role.getRoleName());
            List<MyRight> rights = role.getRights();
            for (MyRight myRight : rights) {
                authorizationInfo.addStringPermission(myRight.getRightName());
            }
        }
        return authorizationInfo;
    }

    /*从token中获取用户信息，然后从数据库中比对，进行身份认证*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
       String userName = (String) authenticationToken.getPrincipal();
        System.out.println(authenticationToken.getCredentials());
        User user = userService.getUserByUserName(userName);
    if(null == user)
        return null;
        SimpleAuthenticationInfo  authenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(userName+user.getSalt()),getName());
        return authenticationInfo;
    }


}
