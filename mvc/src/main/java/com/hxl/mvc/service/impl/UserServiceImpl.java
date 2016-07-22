package com.hxl.mvc.service.impl;

import com.hxl.mvc.dao.UserDao;
import com.hxl.mvc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hxl.mvc.service.UserService;

/**
 * Created by hxl on 2016/7/13.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User loadUserByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
