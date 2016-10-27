package com.hxl.utils;

import com.hxl.generator.properties.DataTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * Created by hxl on 2016/10/18.
 */
@Component
@EnableConfigurationProperties(value = {DataTypes.class})
public class GeneratorUtils {

    @Autowired
    private DataTypes dataTypes;

    public String mappingType(String sqlType) {
        if (StringUtils.isNotEmpty(sqlType)) {
            Stream<DataTypes.DataType> dataTypeStream = dataTypes.getTypes().parallelStream().filter(t -> sqlType.equalsIgnoreCase(t.getSqlType()));
            return dataTypeStream.count() == 0L ? null : dataTypeStream.findFirst().get().getJavaType();
        }
        return null;
    }

}
