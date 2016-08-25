package com.hxl.mvc.dao;

import com.hxl.mvc.entity.Constant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by hxl on 2016/8/24.
 */
public interface ConstantDao extends JpaRepository<Constant, String>, JpaSpecificationExecutor<Constant> {

    @Query(" select c from Constant c where c.parent.code = ?1 ")
    List<Constant> findByParentCode(String parentCode);
}
