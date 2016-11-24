package com.hxl.wx.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hxl.wx.entity.Button;
import com.hxl.wx.entity.Menu;
import com.hxl.wx.enumerate.ButtonType;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hxl on 2016/11/18.
 * json工具类,使用jackson实现
 */
public class JsonUtils {

    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static String toString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T>T toBean(String s, Class<T> clazz) {
        try {
            return objectMapper.readValue(s, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        Menu menu = new Menu();
        Button button = new Button();
        button.setName("扫码带提示");
        button.setType(ButtonType.scancode_waitmsg);
        button.setKey("rselfmenu_0_0");
        menu.getButtons().add(button);
        System.out.println(JsonUtils.toString(menu));
    }

}
