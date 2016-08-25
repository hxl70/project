package com.hxl.mvc.service;

import com.hxl.mvc.entity.Constant;
import com.hxl.mvc.query.ConstantQuery;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by hxl on 2016/8/24.
 */
public interface ConstantService {

    Page<Constant> page(ConstantQuery query);

    List<Constant> findByParentCode(String parentCode);

    void save(Constant constant);

    void update(Constant constant);

    void delete(String id);

    Constant findById(String id);

}
