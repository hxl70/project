package com.hxl.mvc.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by hxl on 2016/8/24.
 */
@Entity
@Table(name = "sys_constant")
public class Constant extends AbstractEntity {

    @Column(length = 32)
    private String name;
    @Column(length = 32)
    private String code;
    private Integer num;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Constant parent;
    @OneToMany(mappedBy = "parent")
    private Set<Constant> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Constant getParent() {
        return parent;
    }

    public void setParent(Constant parent) {
        this.parent = parent;
    }

    public Set<Constant> getChildren() {
        return children;
    }

    public void setChildren(Set<Constant> children) {
        this.children = children;
    }
}
