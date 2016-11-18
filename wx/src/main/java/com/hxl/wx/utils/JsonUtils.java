package com.hxl.wx.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hxl on 2016/11/18.
 */
public class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String object2String(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map string2Map(String s) {
        try {
            TypeFactory typeFactory = objectMapper.getTypeFactory();
            return objectMapper.readValue(s, HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
