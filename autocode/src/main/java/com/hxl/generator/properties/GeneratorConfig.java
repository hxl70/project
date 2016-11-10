package com.hxl.generator.properties;

import com.hxl.generator.enumeration.FileType;
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

    public FileConfig getFileConfigByName(String name) {
        return configs.parallelStream().filter((f) -> {
//            return f.fileType == fileType;
            return f.name.equals(name);
        }).findAny().get();
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
        private FileType fileType;
        //生成文件的名称
        private String name;
        //路径
        private String path;
        //模板路径
        private String template;
        //后缀
        private String ext;

        public FileType getFileType() {
            return fileType;
        }

        public void setFileType(FileType fileType) {
            this.fileType = fileType;
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
