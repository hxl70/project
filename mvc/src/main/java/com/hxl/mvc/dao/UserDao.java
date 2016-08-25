package com.hxl.mvc.dao;

import com.hxl.mvc.entity.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hxl on 2016/7/13.
 * 用户Dao
 */
public interface UserDao extends JpaRepository<User, String> {

    /**
     * 根据用户名查找用户
     * @param username 用户名
     * @return 有则返回用户没有则返回<code>null</code>
     */
    @Cacheable("User")
    User findByUsername(String username);

}
