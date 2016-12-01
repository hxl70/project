package com.hxl.utils;

import com.hxl.generator.configs.Configs;
import com.hxl.generator.configs.DataTypes;
import com.hxl.generator.configs.GeneratorConfig;
import com.hxl.parser.entity.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Created by hxl on 2016/10/18.
 * 构造工具类
 * 生成getter,setter,类名,包路径,完整路径,变量等
 */
public class GeneratorUtils {

    private Logger logger = LoggerFactory.getLogger(GeneratorUtils.class);

    private DataTypes dataTypes;
    private GeneratorConfig generatorConfig;
    private Table table;

    public GeneratorUtils(Configs configs, Table table) {
        this.dataTypes = configs.getDataTypes();
        this.generatorConfig = configs.getConfig();
        this.table = table;
        table.generate(this, configs.getTablePre());
    }

    /**
     * sql类型转成java类型
     * @param sqlType sql类型
     * @return java类型,没有则返回sql类型
     */
    public String getJavaType(String sqlType) {
        try {
            if (StringUtils.isNotEmpty(sqlType)) {
                return dataTypes.getTypes().parallelStream().filter(t -> sqlType.equalsIgnoreCase(t.getSqlType())).findFirst().get().getJavaType();
            }
        } catch (Exception e) {
            logger.error("can not find sqlType: {}", sqlType);
        }
        return sqlType;
    }

    /**
     * 生成类名
     * @param code 带下划线的字符串
     * @return
     */
    public String getClassName(String code) {
        String[] codes = code.toLowerCase().split("_");
        StringBuffer sb = new StringBuffer();
        for (String s : codes) {
            sb.append(s.substring(0, 1).toUpperCase() + s.substring(1));
        }
        return sb.toString();
    }

    /**
     * 生成变量名
     * @param code 带下划线的字符串
     * @return
     */
    public String getFieldName(String code) {
        String[] codes = code.toLowerCase().split("_");
        if (codes.length == 1) {
            return codes[0];
        }
        StringBuffer sb = new StringBuffer(codes[0]);
        for (int i = 1; i < codes.length; i++) {
            String s = codes[i];
            sb.append(s.substring(0, 1).toUpperCase() + s.substring(1));
        }
        return sb.toString();
    }

    /**
     * 生成getter字符串
     * @param code 字段名
     * @param type 字段类型
     * @return
     */
    public String getter(String code, String type) {
        return ("boolean".equalsIgnoreCase(type) ? "is" : "get") + code.substring(0, 1).toUpperCase() + code.substring(1);
    }

    /**
     * 生成setter字符串
     * @param code 字段名
     * @return
     */
    public String setter(String code) {
        return "set" + code.substring(0, 1).toUpperCase() + code.substring(1);
    }

    /**
     * 生成完整的名称
     * @param fileName 文件类型
     * @return com.entity.Entity
     */
    public String getFullName(String fileName) {
        return getFullName(getFileConfigByName(fileName), table.getClassName());
    }

    /**
     * 生成名称
     * @param fileName 文件类型
     * @return Entity
     */
    public String getName(String fileName) {
        return getFileName(getFileConfigByName(fileName), table.getClassName());
    }

    /**
     * 生成字段名
     * @param fileName 文件类型
     * @return entity
     */
    public String getField(String fileName) {
        return getFileName(getFileConfigByName(fileName), table.getFieldName());
    }

    /**
     * 生成包路径
     * @param type 文件类型
     * @return com.entity
     */
    public String getPackage(String type) {
        return getPackage(getFileConfigByName(type));
    }

    /**
     * 根据名称获取文件配置
     * @param name
     * @return
     */
    public GeneratorConfig.FileConfig getFileConfigByName(String name) {
        try {
            Optional<GeneratorConfig.FileConfig> first = generatorConfig.getConfigs().parallelStream().filter((f) ->
                    f.getName().equals(name)
            ).findFirst();
            return first.isPresent() ? first.get() : null;
        } catch (Exception e) {
            logger.error("can not found fileConfig by name: {}", name);
            return null;
        }
    }

    /**
     * 获取文件的完整路径
     * @param fileConfig 文件配置
     * @return com.entity.Entity.java
     */
    public String getFullPath(GeneratorConfig.FileConfig fileConfig) {
        String name = table.getClassName();
        if (fileConfig == null) {
            return name;
        }
        if (fileConfig.getType().equalsIgnoreCase("source")) {
            return generatorConfig.getProjectDirectory() + generatorConfig.getSourceDirectory() + fileConfig.getPath() + "/" + getFileName(fileConfig, name) + fileConfig.getExt();
        }
        if (fileConfig.getType().equalsIgnoreCase("test")) {
            return generatorConfig.getProjectDirectory() + generatorConfig.getTestDirectory() + fileConfig.getPath() + "/" + getFileName(fileConfig, name) + fileConfig.getExt();
        }
        if (fileConfig.getType().equalsIgnoreCase("view")) {
            return generatorConfig.getProjectDirectory() + generatorConfig.getViewDirectory() + table.getFieldName() + "/" + fileConfig.getPath() + fileConfig.getExt();
        }
        return name;
    }

    private String getFileName(GeneratorConfig.FileConfig fileConfig, String name) {
        if (fileConfig == null) {
            return name;
        }
        if (fileConfig.getType().equalsIgnoreCase("source")) {
            switch (fileConfig.getName()) {
                case "entity":
                    return name;
                case "dao":
                    return name + "Dao";
                case "query":
                    return name + "Query";
                case "service":
                    return name + "Service";
                case "serviceImpl":
                    return name + "ServiceImpl";
                case "controller":
                    return name + "Controller";
            }
        }
        return name;
    }

    private String getPackage(GeneratorConfig.FileConfig fileConfig) {
        return fileConfig != null ? fileConfig.getPath().replace("/", ".") : null;
    }

    private String getFullName(GeneratorConfig.FileConfig fileConfig, String name) {
        return fileConfig != null ? this.getPackage(fileConfig) + "." + getFileName(fileConfig, name) : null;
    }
}
