package com.hxl.generator;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by hxl on 2016/9/8.
 */
@ConfigurationProperties(prefix = "generator.config", locations = "classpath:/generator.yml")
public class GeneratorProperties {

    private String outputPath;

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }
}
