package com.hxl.mvc.service.impl;

import com.hxl.mvc.dao.ConstantDao;
import com.hxl.mvc.entity.Constant;
import com.hxl.mvc.query.ConstantQuery;
import com.hxl.mvc.service.ConstantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hxl on 2016/8/24.
 */
@Service
public class ConstantServiceImpl implements ConstantService {

    @Autowired
    private ConstantDao constantDao;

    @Override
    public Page<Constant> page(ConstantQuery query) {
        return constantDao.findAll(query.getSpecification(), query.getPageable());
    }

    @Override
    public List<Constant> findByParentCode(String parentCode) {
        return constantDao.findByParentCode(parentCode);
    }

    @Override
    public void save(Constant constant) {
        constantDao.save(constant);
    }

    @Override
    public void update(Constant constant) {
        constantDao.save(constant);
    }

    @Override
    public void delete(String id) {
        constantDao.delete(id);
    }

    @Override
    public Constant findById(String id) {
        return constantDao.findOne(id);
    }
}
