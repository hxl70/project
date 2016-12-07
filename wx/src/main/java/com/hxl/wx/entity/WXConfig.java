package com.hxl.wx.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by hxl on 2016/11/18.
 * 微信配置信息
 */
@ConfigurationProperties(locations = "${wx.configs}", prefix = "wx")
public class WXConfig {

    private String appId;
    private String appSecret;
    private String token;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
