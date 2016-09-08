package com.hxl.parser.entity;

/**
 * Created by hxl on 2016/7/20.
 * 字段模型
 */
public class Column {

    private String name;
    private String code;
    private String type;
    private Integer length;
    private Boolean pkFlag;
    private String defaultValue;
    private Table table;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Boolean getPkFlag() {
        return pkFlag;
    }

    public void setPkFlag(Boolean pkFlag) {
        this.pkFlag = pkFlag;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
