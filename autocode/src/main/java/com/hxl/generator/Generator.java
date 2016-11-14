package com.hxl.generator;

import com.hxl.generator.properties.DataTypes;
import com.hxl.generator.properties.GeneratorConfig;
import com.hxl.parser.entity.Table;
import com.hxl.utils.FileUtils;
import com.hxl.utils.GeneratorUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


/**
 * Created by hxl on 2016/9/5.
 */
@Component
@EnableConfigurationProperties(value = {GeneratorConfig.class, DataTypes.class})
public class Generator {

    @Autowired
    private GeneratorConfig generatorConfig;
    @Autowired
    private DataTypes dataTypes;

    private VelocityEngine velocityEngine;

    public Generator() {
        velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.setProperty(RuntimeConstants.INPUT_ENCODING, "utf-8");
        velocityEngine.setProperty(RuntimeConstants.OUTPUT_ENCODING, "utf-8");
        velocityEngine.init();
    }

    public void generator(List<Table> tables) {
        tables.parallelStream().forEach(this::generator);
    }

    public void generator(Table table) {
        generatorConfig.getConfigs().parallelStream().forEach(c -> {
            try {
                Template template = velocityEngine.getTemplate(c.getTemplate());
                VelocityContext velocityContext = new VelocityContext();
                GeneratorUtils utils = new GeneratorUtils(dataTypes, generatorConfig, table);
                velocityContext.put("table", table);
                velocityContext.put("utils", utils);
                String file = utils.getFullPath(c);
                FileUtils.createFile(file);
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                template.merge(velocityContext, bw);
                bw.flush();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
