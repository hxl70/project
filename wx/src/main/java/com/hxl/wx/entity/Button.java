package com.hxl.wx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hxl.wx.enumerate.ButtonType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxl on 2016/11/22.
 */
public class Button {

    /**
     * 菜单的响应动作类型
     */
    private ButtonType type;
    /**
     * 菜单标题，不超过16个字节，子菜单不超过40个字节
     */
    private String name;
    /**
     * 菜单KEY值，用于消息接口推送，不超过128字节
     */
    private String key;
    /**
     * 网页链接，用户点击菜单可打开链接，不超过1024字节
     */
    private String url;
    /**
     *
     */
    @JsonProperty("media_id")
    private String mediaId;
    /**
     * 二级菜单数组，个数应为1~5个
     */
    @JsonProperty("sub_button")
    private List<Button> subButtons = new ArrayList<>(5);

    @JsonProperty("news_info")
    private MenuNewsInfo newsInfo;

    public ButtonType getType() {
        return type;
    }

    public void setType(ButtonType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public List<Button> getSubButtons() {
        return subButtons;
    }

    public void setSubButtons(List<Button> subButtons) {
        this.subButtons = subButtons;
    }

    public MenuNewsInfo getNewsInfo() {
        return newsInfo;
    }

    public void setNewsInfo(MenuNewsInfo newsInfo) {
        this.newsInfo = newsInfo;
    }
}
