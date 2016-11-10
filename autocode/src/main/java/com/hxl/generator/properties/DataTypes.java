package com.hxl.generator.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxl on 2016/9/5.
 */
@ConfigurationProperties(locations = "classpath:/datatype.yml", prefix = "dataType")
public class DataTypes {

    private Logger logger = LoggerFactory.getLogger(DataTypes.class);

    public String getJavaType(String sqlType) {
        try {
            return types.parallelStream().filter(t -> t.getSqlType().equalsIgnoreCase(sqlType)).findAny().get().getJavaType();
        } catch (Exception e) {
            logger.error("cannot find type {}", sqlType);
        }
        return sqlType;
    }

    private List<DataType> types = new ArrayList<>();

    public List<DataType> getTypes() {
        return types;
    }

    public void setTypes(List<DataType> types) {
        this.types = types;
    }

    public static class DataType {

        private String javaType;
        private String sqlType;

        public String getJavaType() {
            return javaType;
        }

        public void setJavaType(String javaType) {
            this.javaType = javaType;
        }

        public String getSqlType() {
            return sqlType;
        }

        public void setSqlType(String sqlType) {
            this.sqlType = sqlType;
        }
    }

}
