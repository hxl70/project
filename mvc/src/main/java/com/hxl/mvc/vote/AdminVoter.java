package com.hxl.mvc.vote;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by hxl on 2016/5/31.
 * 系统超级管理员判断,用户为系统管理员时可以获得所有的权限
 */
public class AdminVoter implements AccessDecisionVoter<Object> {
    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        return authorities.stream().anyMatch((auth) ->
                "ROLE_ADMIN".equals(auth.getAuthority())
        ) ? AccessDecisionVoter.ACCESS_GRANTED : AccessDecisionVoter.ACCESS_ABSTAIN;
    }
}
