package com.hxl.parser.entity;

import com.hxl.utils.GeneratorUtils;

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

    private boolean created = true;
    private boolean modified = true;
    private boolean deleted = true;
    private boolean searched = true;
    private String className;
    private String fieldName;

    public void generate(GeneratorUtils utils) {
        className = utils.getClassName(this.getCode());
        fieldName = utils.getFieldName(this.getCode());
        columns.parallelStream().forEach(column -> column.generate(utils));
    }

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

    public boolean isCreated() {
        return created;
    }

    public void setCreated(boolean created) {
        this.created = created;
    }

    public boolean isModified() {
        return modified;
    }

    public void setModified(boolean modified) {
        this.modified = modified;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isSearched() {
        return searched;
    }

    public void setSearched(boolean searched) {
        this.searched = searched;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
