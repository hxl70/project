package com.hxl.mvc.query;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

/**
 * Created by hxl on 2016/8/24.
 */
public abstract class Query<T> {

    //default page and pageSize
    protected Integer page = 1;
    protected Integer pageSize = 10;

    protected Sort.Direction direction;
    protected String[] properties;

    public Query(Sort.Direction direction, String... properties) {
        this.direction = direction;
        this.properties = properties;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Sort.Direction getDirection() {
        return direction;
    }

    public void setDirection(Sort.Direction direction) {
        this.direction = direction;
    }

    public String[] getProperties() {
        return properties;
    }

    public void setProperties(String[] properties) {
        this.properties = properties;
    }

    public abstract Specification<T> getSpecification();

    public Pageable getPageable() {
        if (direction == null || properties == null) {
            return new PageRequest(page - 1, pageSize);
        }
        return new PageRequest(page - 1, pageSize, direction, properties);
    }

}
