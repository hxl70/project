package com.hxl.parser.entity;

import java.util.List;

/**
 * Created by hxl on 2016/7/20.
 * 表模型
 */
public class Table {

    private String name;
    private String code;
    private Column pkColumn;
    private List<Column> columns;

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

    public Column getPkColumn() {
        return pkColumn;
    }

    public void setPkColumn(Column pkColumn) {
        this.pkColumn = pkColumn;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

}
