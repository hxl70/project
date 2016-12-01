package com.hxl.parser.entity;

import com.hxl.utils.GeneratorUtils;
import com.hxl.utils.StringUtils;

import java.util.List;

/**
 * Created by hxl on 2016/7/20.
 * 表模型
 */
public class Table {

    // 名称
    private String name;
    //代码
    private String code;
    //主键字段
    private Column pkColumn;
    //字段
    private List<Column> columns;

    //新增标识
    private boolean created = true;
    //修改标识
    private boolean modified = true;
    //删除标识
    private boolean deleted = true;
    //查询标识
    private boolean searched = true;
    //类名
    private String className;
    //类字段名
    private String fieldName;

    public void generate(GeneratorUtils utils, String tablePre) {
        String c = this.getCode();
        //去除表前缀
        if (StringUtils.isNotEmpty(tablePre)) {
            if (c.substring(0, tablePre.length()).equalsIgnoreCase(tablePre)) {
                c = c.substring(tablePre.length());
            }
        }
        className = utils.getClassName(c);
        fieldName = utils.getFieldName(c);
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
