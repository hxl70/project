package com.hxl.entity;

import java.util.List;

/**
 * Created by hxl on 2016/7/20.
 * 模型
 */
public class Model {

    private String name;
    private String code;
    private List<Diagram> diagrams;

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

    public List<Diagram> getDiagrams() {
        return diagrams;
    }

    public void setDiagrams(List<Diagram> diagrams) {
        this.diagrams = diagrams;
    }
}
