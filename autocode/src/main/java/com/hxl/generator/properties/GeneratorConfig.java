package com.hxl.generator.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxl on 2016/10/13.
 */
@ConfigurationProperties(prefix = "generator.config", locations = "classpath:/generator.yml")
public class GeneratorConfig {

    //项目路径
    private String projectDirectory;
    //java源码路径
    private String sourceDirectory;
    //test路径
    private String testDirectory;
    //view路径
    private String viewDirectory;
    //文件配置
    private List<FileConfig> configs = new ArrayList<>();

    public String getProjectDirectory() {
        return projectDirectory;
    }

    public void setProjectDirectory(String projectDirectory) {
        this.projectDirectory = projectDirectory;
    }

    public String getSourceDirectory() {
        return sourceDirectory;
    }

    public void setSourceDirectory(String sourceDirectory) {
        this.sourceDirectory = sourceDirectory;
    }

    public String getTestDirectory() {
        return testDirectory;
    }

    public void setTestDirectory(String testDirectory) {
        this.testDirectory = testDirectory;
    }

    public String getViewDirectory() {
        return viewDirectory;
    }

    public void setViewDirectory(String viewDirectory) {
        this.viewDirectory = viewDirectory;
    }

    public List<FileConfig> getConfigs() {
        return configs;
    }

    public void setConfigs(List<FileConfig> configs) {
        this.configs = configs;
    }

    public static class FileConfig {

        //类型
        private String type;
        //生成文件的名称
        private String name;
        //路径
        private String path;
        //模板路径
        private String template;
        //后缀
        private String ext;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getTemplate() {
            return template;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public String getExt() {
            return ext;
        }

        public void setExt(String ext) {
            this.ext = ext;
        }
    }

}
