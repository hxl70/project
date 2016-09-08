package com.hxl.parser;

import com.hxl.parser.entity.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by hxl on 2016/7/21.
 */
@Component
public class DatabaseParser {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static Table parse(String tableName) {
        return null;
    }

}
