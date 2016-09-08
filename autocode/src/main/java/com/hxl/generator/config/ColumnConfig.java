package com.hxl.generator.config;

import com.hxl.generator.enumeration.ColumnType;
import com.hxl.parser.entity.Column;

/**
 * Created by hxl on 2016/9/5.
 */
public class ColumnConfig {

    private boolean created = true;
    private boolean modified = true;
    private boolean deleted = true;
    private boolean searched = true;
    private ColumnType type = ColumnType.INPUT;
    private Column column;
    private TableConfig tableConfig;

    public ColumnConfig(Column column) {
        this.column = column;
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

    public ColumnType getType() {
        return type;
    }

    public void setType(ColumnType type) {
        this.type = type;
    }

    public Column getColumn() {
        return column;
    }

    public void setColumn(Column column) {
        this.column = column;
    }

    public TableConfig getTableConfig() {
        return tableConfig;
    }

    public void setTableConfig(TableConfig tableConfig) {
        this.tableConfig = tableConfig;
    }
}
