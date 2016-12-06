package com.hxl.wx.entity.media;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by hxl on 2016/12/6.
 */
public class MediaItem {

    //素材
    @JsonProperty("media_id")
    private String mediaId;
    //文件名称
    private String name;
    @JsonProperty("update_time")
    //这篇图文消息素材的最后更新时间
    private String updateTime;
    //图文页的URL，或者，当获取的列表是图片素材列表时，该字段是图片的URL
    private String url;
    //图文消息素材列表
    private MediaContent content;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MediaContent getContent() {
        return content;
    }

    public void setContent(MediaContent content) {
        this.content = content;
    }
}
