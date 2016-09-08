package com.hxl.generator;

import com.hxl.generator.config.ColumnConfig;
import com.hxl.generator.config.DiagramConfig;
import com.hxl.generator.config.ModelConfig;
import com.hxl.generator.config.TableConfig;
import com.hxl.parser.PdmParser;
import com.hxl.parser.entity.Column;
import com.hxl.parser.entity.Diagram;
import com.hxl.parser.entity.Model;
import com.hxl.parser.entity.Table;
import com.hxl.utils.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxl on 2016/9/5.
 */
public class GeneratorParser {

    public static ModelConfig parse(Model model) {
        ModelConfig modelConfig = new ModelConfig(model);
        List<Diagram> diagrams = model.getDiagrams();
        if (CollectionUtils.isNotEmpty(diagrams)) {
            List<DiagramConfig> diagramConfigs = new ArrayList<>();
            modelConfig.setDiagramConfigs(diagramConfigs);
            diagrams.stream().forEach(diagram -> {
                String projectName = model.getCode() + "." + diagram.getCode();
                DiagramConfig diagramConfig = new DiagramConfig(diagram);
                diagramConfig.setProjectName(projectName);
                diagramConfig.setModelConfig(modelConfig);
                diagramConfigs.add(diagramConfig);
                List<Table> tables = diagram.getTables();
                if (CollectionUtils.isNotEmpty(tables)) {
                    List<TableConfig> tableConfigs = new ArrayList<>();
                    diagramConfig.setTableConfigs(tableConfigs);
                    tables.stream().forEach(table -> {
                        TableConfig tableConfig = new TableConfig(table);
                        tableConfig.setDiagramConfig(diagramConfig);
                        tableConfigs.add(tableConfig);
                        List<Column> columns = table.getColumns();
                        if (CollectionUtils.isNotEmpty(columns)) {
                            List<ColumnConfig> columnConfigs = new ArrayList<>();
                            tableConfig.setColumnConfigs(columnConfigs);
                            columns.stream().forEach(column -> {
                                ColumnConfig columnConfig = new ColumnConfig(column);
                                columnConfig.setDeleted(column.getPkFlag());
                                columnConfig.setTableConfig(tableConfig);
                                columnConfigs.add(columnConfig);
                            });
                        }
                    });
                }
            });
        }
        return modelConfig;
    }

    public static void main(String[] args) {
        Model model = PdmParser.pdmParse("F:/IMS.pdm");
        ModelConfig modelConfig = parse(model);
        System.out.println(modelConfig);
    }

}
