package com.common.shiro;

import com.chen.entity.po.User;
import com.chen.service.UserService;
import com.common.util.MD5Utils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Component
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 获取授权信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName=principalCollection.getPrimaryPrincipal().toString();
        User user=userService.queryUserByName(userName);
        Set<String> set=new HashSet<String>();
        set.add(user.getRole());

        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(set);
        return simpleAuthorizationInfo;
    }


    /**
     * 获取身份验证信息
     * Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
     *
     * @param authenticationToken 用户身份信息 token
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName=authenticationToken.getPrincipal().toString();
        String password=String.valueOf((char[])authenticationToken.getCredentials());
        User user=userService.queryUserByName(userName);
        if(Objects.isNull(user)){
            throw new UnknownAccountException();
        }else if(!user.getPassword().equals(MD5Utils.MD5(password))){
            throw new UnknownAccountException();
        }
        return new SimpleAuthenticationInfo(userName,password,getName());
    }
}
