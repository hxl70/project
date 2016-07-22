package com.hxl.entity;

import java.util.List;

/**
 * Created by hxl on 2016/7/20.
 * 图表
 */
public class Diagram {

    private String name;
    private String code;
    private List<Table> tables;

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

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }
}
