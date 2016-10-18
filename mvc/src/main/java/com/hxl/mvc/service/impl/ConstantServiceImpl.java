package com.hxl.mvc.service.impl;

import com.hxl.mvc.dao.ConstantDao;
import com.hxl.mvc.entity.Constant;
import com.hxl.mvc.query.ConstantQuery;
import com.hxl.mvc.service.ConstantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by hxl on 2016/8/24.
 */
@Service
public class ConstantServiceImpl implements ConstantService {

    @Autowired
    private ConstantDao constantDao;

    @Cacheable("Constant")
    @Override
    public List<Constant> findByParentCode(String parentCode) {
        return constantDao.findByParentCode(parentCode);
    }

    @Override
    public Page<Constant> page(ConstantQuery query) {
        return constantDao.findAll(query.getSpecification(), query.getPageable());
    }

    @Transactional
    @Cacheable("Constant")
    @Override
    public void save(Constant constant) {
        constantDao.save(constant);
        constant.setName("2222");
        constantDao.save(constant);
        throw new RuntimeException("error");
    }

    @CachePut("Constant")
    @Override
    public void update(Constant constant) {
        constantDao.save(constant);
    }

    @CacheEvict(value = "Constant", allEntries = true)
    @Override
    public void delete(String id) {
        constantDao.delete(id);
    }

    @Cacheable("Constant")
    @Override
    public Constant findById(String id) {
        return constantDao.findOne(id);
    }
}
