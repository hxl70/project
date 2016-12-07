package com.hxl.wx.entity.user;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by hxl on 2016/12/7.
 */
public class WXUserListItem {

    @JsonProperty("openid")
    private String openId;
    private String lang;

    public WXUserListItem() {
    }

    public WXUserListItem(String openId, String lang) {
        this.openId = openId;
        this.lang = lang;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
