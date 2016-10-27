package com.hxl.generator.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxl on 2016/9/5.
 */
@ConfigurationProperties(locations = "classpath:/datatype.yml", prefix = "dataType")
public class DataTypes {

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
