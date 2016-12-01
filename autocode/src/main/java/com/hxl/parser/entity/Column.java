package com.hxl.parser.entity;

import com.hxl.generator.enumeration.EditorType;
import com.hxl.utils.GeneratorUtils;

/**
 * Created by hxl on 2016/7/20.
 * 字段模型
 */
public class Column {

    //名称
    private String name;
    //代码
    private String code;
    //类型
    private String type;
    //长度
    private Integer length;
    //主键标识
    private boolean pkFlag;
    //默认值
    private String defaultValue;
    //表
    private Table table;

    private boolean created = true; //是否创建
    private boolean modified = true; //是否修改
    private boolean deleted = true; //是否删除
    private boolean searched = true; //是否查询
    private EditorType editorType = EditorType.INPUT; //编辑类型
    private String javaType; //java类型
    private String fieldName; //字段名

    public void generate(GeneratorUtils utils) {
        javaType = utils.getJavaType(this.getType());
        fieldName = utils.getFieldName(this.getCode());
        setCreated(!pkFlag);
        setModified(!pkFlag);
        setDeleted(pkFlag);
        setSearched(!pkFlag);
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

    public void setPkFlag(boolean pkFlag) {
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

    public boolean isPkFlag() {
        return pkFlag;
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

    public EditorType getEditorType() {
        return editorType;
    }

    public void setEditorType(EditorType editorType) {
        this.editorType = editorType;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
