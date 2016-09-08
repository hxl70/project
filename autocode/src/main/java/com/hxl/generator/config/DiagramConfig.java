package com.hxl.generator.config;

import com.hxl.parser.entity.Diagram;

import java.util.List;

/**
 * Created by hxl on 2016/9/5.
 */
public class DiagramConfig {

    private String projectName;
    private Diagram diagram;
    private List<TableConfig> tableConfigs;
    private ModelConfig modelConfig;

    public DiagramConfig(Diagram diagram) {
        this.diagram = diagram;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Diagram getDiagram() {
        return diagram;
    }

    public void setDiagram(Diagram diagram) {
        this.diagram = diagram;
    }

    public List<TableConfig> getTableConfigs() {
        return tableConfigs;
    }

    public void setTableConfigs(List<TableConfig> tableConfigs) {
        this.tableConfigs = tableConfigs;
    }

    public ModelConfig getModelConfig() {
        return modelConfig;
    }

    public void setModelConfig(ModelConfig modelConfig) {
        this.modelConfig = modelConfig;
    }
}
