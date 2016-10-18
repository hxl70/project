package com.hxl.generator.config;

import com.hxl.parser.entity.Table;

import java.util.List;

/**
 * Created by hxl on 2016/9/5.
 */
public class TableConfig {

    private boolean created = true;
    private boolean modified = true;
    private boolean deleted = true;
    private boolean searched = true;
    private Table table;
    private List<ColumnConfig> columnConfigs;

    public TableConfig(Table table) {
        this.table = table;
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

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public List<ColumnConfig> getColumnConfigs() {
        return columnConfigs;
    }

    public void setColumnConfigs(List<ColumnConfig> columnConfigs) {
        this.columnConfigs = columnConfigs;
    }

}
