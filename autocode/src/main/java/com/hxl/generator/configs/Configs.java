package com.hxl.generator.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by hxl on 2016/11/29.
 */
@Component
@EnableConfigurationProperties(value = {GeneratorConfig.class, DataTypes.class})
public class Configs {

    @Autowired
    private DataTypes dataTypes;
    @Autowired
    private GeneratorConfig config;
    @Value("${config.tablePre}")
    private String tablePre;

    public DataTypes getDataTypes() {
        return dataTypes;
    }

    public void setDataTypes(DataTypes dataTypes) {
        this.dataTypes = dataTypes;
    }

    public GeneratorConfig getConfig() {
        return config;
    }

    public void setConfig(GeneratorConfig config) {
        this.config = config;
    }

    public String getTablePre() {
        return tablePre;
    }

    public void setTablePre(String tablePre) {
        this.tablePre = tablePre;
    }
}
