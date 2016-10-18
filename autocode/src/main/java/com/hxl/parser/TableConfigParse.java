package com.hxl.parser;

import com.hxl.generator.config.ColumnConfig;
import com.hxl.generator.config.TableConfig;
import com.hxl.parser.entity.Column;
import com.hxl.parser.entity.Table;
import com.hxl.utils.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxl on 2016/9/5.
 */
public class TableConfigParse {

    public static List<TableConfig> parse(List<Table> tables) {
        List<TableConfig> tableConfigs = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(tables)) {
            tables.parallelStream().forEach(table -> {
                TableConfig tableConfig = new TableConfig(table);
                tableConfigs.add(tableConfig);
                List<Column> columns = table.getColumns();
                if (CollectionUtils.isNotEmpty(columns)) {
                    List<ColumnConfig> columnConfigs = new ArrayList<>();
                    tableConfig.setColumnConfigs(columnConfigs);
                    columns.parallelStream().forEach(column -> {
                        ColumnConfig columnConfig = new ColumnConfig(column);
                        columnConfig.setDeleted(column.getPkFlag());
                        columnConfig.setTableConfig(tableConfig);
                        columnConfigs.add(columnConfig);
                    });
                }
            });
        }
        return tableConfigs;
    }

}
