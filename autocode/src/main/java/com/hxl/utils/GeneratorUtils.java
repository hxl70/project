package com.hxl.utils;

import com.hxl.generator.properties.DataTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by hxl on 2016/10/18.
 */
@Component
@EnableConfigurationProperties(value = {DataTypes.class})
public class GeneratorUtils {

    private Logger logger = LoggerFactory.getLogger(GeneratorUtils.class);

    @Autowired
    private DataTypes dataTypes;

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
     * @param code 带下划线字符串
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

    public String getter(String code, String type) {
        return ("boolean".equalsIgnoreCase(type) ? "is" : "get") + code.substring(0, 1).toUpperCase() + code.substring(1);
    }

    public String setter(String code) {
        return "set" + code.substring(0, 1).toUpperCase() + code.substring(1);
    }

}
