package com.hxl.generator;

import com.hxl.parser.entity.DataTypes;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.StringWriter;

/**
 * Created by hxl on 2016/9/5.
 */
@Component
@EnableConfigurationProperties(value = {GeneratorProperties.class, DataTypes.class})
public class Generator {

    @Autowired
    private GeneratorProperties properties;
    @Autowired
    private DataTypes dataTypes;

    public static void main(String[] args) {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();
        Template template = velocityEngine.getTemplate("");
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("key", "value");

        StringWriter stringWriter = new StringWriter();
        template.merge(velocityContext, stringWriter);
        System.out.println(stringWriter.toString());
    }

    public GeneratorProperties getProperties() {
        return properties;
    }

    public void setProperties(GeneratorProperties properties) {
        this.properties = properties;
    }

    public DataTypes getDataTypes() {
        return dataTypes;
    }

    public void setDataTypes(DataTypes dataTypes) {
        this.dataTypes = dataTypes;
    }
}
