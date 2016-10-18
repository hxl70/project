package com.hxl.generator.properties;

import com.hxl.parser.enumeration.Database;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        private String databaseType;
        private Database database;

        public String getJavaType() {
            return javaType;
        }

        public void setJavaType(String javaType) {
            this.javaType = javaType;
        }

        public String getDatabaseType() {
            return databaseType;
        }

        public void setDatabaseType(String databaseType) {
            this.databaseType = databaseType;
        }

        public Database getDatabase() {
            return database;
        }

        public void setDatabase(Database database) {
            this.database = database;
        }
    }

}
