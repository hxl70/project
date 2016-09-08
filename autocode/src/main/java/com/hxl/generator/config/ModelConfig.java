package com.hxl.generator.config;

import com.hxl.parser.entity.Model;

import java.util.List;

/**
 * Created by hxl on 2016/9/5.
 */
public class ModelConfig {

    private Model model;
    private List<DiagramConfig> diagramConfigs;

    public ModelConfig(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public List<DiagramConfig> getDiagramConfigs() {
        return diagramConfigs;
    }

    public void setDiagramConfigs(List<DiagramConfig> diagramConfigs) {
        this.diagramConfigs = diagramConfigs;
    }
}
