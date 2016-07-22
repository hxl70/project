package com.hxl.mvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.hxl.mvc.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxl on 2016/5/17.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.hxl.mvc.entity.User sys_user = userService.loadUserByUsername(s);
        //权限,需要从数据库中获取
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(sys_user.isAdmin() ? "ADMIN" : "USER"));
        User user = new User(sys_user.getUsername(), sys_user.getPassword(), authorities);
        return user;
    }

}
