package com.hxl.mvc.dao;

import com.hxl.mvc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hxl on 2016/7/13.
 */
public interface UserDao extends JpaRepository<User, String> {

    User findByUsername(String username);

}
