package com.hxl.mvc.query;

import com.hxl.mvc.entity.Constant;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxl on 2016/8/24.
 */
public class ConstantQuery extends Query<Constant> {

    public ConstantQuery() {
        super(Sort.Direction.ASC, "code");
    }

    private String code;
    private String name;

    @Override
    public Specification<Constant> getSpecification() {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (!StringUtils.isEmpty(code)) {
                predicates.add(cb.like(root.get("code"), "%" + code + "%"));
            }
            if (!StringUtils.isEmpty(name)) {
                predicates.add(cb.like(root.get("name"), "%" + name + "%"));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
