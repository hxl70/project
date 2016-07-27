package com.hxl.mvc.service;


import com.hxl.mvc.entity.User;

/**
 * Created by hxl on 2016/7/13.
 * 用户Service
 */
public interface UserService {

    User loadUserByUsername(String username);

}
