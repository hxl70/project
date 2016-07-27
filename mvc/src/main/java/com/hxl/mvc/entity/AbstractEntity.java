package com.hxl.mvc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by hxl on 2016/6/23.
 * 实体超类,定义id字段
 */
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @Column(length = 32)
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    private String id;

    protected String getId() {
        return id;
    }

    protected void setId(String id) {
        this.id = id;
    }
}
