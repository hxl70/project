package com.hxl.generator.properties;

import org.apache.commons.lang.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxl on 2016/10/13.
 */
@ConfigurationProperties(prefix = "generator.config", locations = "classpath:/generator.yml")
public class GeneratorConfig {

    private String outputDirectory;

    private List<FileConfig> configs = new ArrayList<>();

    public FileConfig getByType(String type) {
        return configs.parallelStream().filter((f) ->
            f.type.equals(type)
        ).findAny().get();
    }

    public String getOutputDirectory() {
        return outputDirectory;
    }

    public void setOutputDirectory(String outputDirectory) {
        this.outputDirectory = outputDirectory;
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
        //包
        private String classPackage;
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

        public String getClassPackage() {
            return classPackage;
        }

        public void setClassPackage(String classPackage) {
            this.classPackage = classPackage;
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

        public String getPath() {
            return classPackage.replace(".", "/");
        }

        public String getFileName(String name) {
            if (StringUtils.isBlank(name)) {
                return "";
            }
            return this.name.replace("${name}", name);
        }

        public String getFullName(String name) {
            return classPackage + "." + getFileName(name);
        }

    }

}
