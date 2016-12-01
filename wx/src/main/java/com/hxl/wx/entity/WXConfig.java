package com.hxl.wx.entity;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by hxl on 2016/11/18.
 * 微信配置信息
 */
public class WXConfig {

    public static final String APP_ID;
    public static final String APP_SECRET;
    public static String ACCESS_TOKEN;
    public static final String TOKEN;
    public static final String WX_URI = "/wx";

    static {
        Properties properties = new Properties();
        try {
            properties.load(WXConfig.class.getClassLoader().getResourceAsStream("wx.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        APP_ID = properties.getProperty("wx.appId");
        APP_SECRET = properties.getProperty("wx.appSecret");
        TOKEN = properties.getProperty("wx.token");
    }

}
