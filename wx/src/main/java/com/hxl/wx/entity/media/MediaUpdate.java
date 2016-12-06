package com.hxl.wx.entity.media;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by hxl on 2016/12/6.
 */
public class MediaUpdate {

    @JsonProperty("media_id")
    private String mediaId;
    private Integer index;
    private MediaArticle articles;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public MediaArticle getArticles() {
        return articles;
    }

    public void setArticles(MediaArticle articles) {
        this.articles = articles;
    }
}
