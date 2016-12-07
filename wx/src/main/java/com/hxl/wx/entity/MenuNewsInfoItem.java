package com.hxl.wx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by hxl on 2016/12/7.
 * 图文消息的信息
 */
public class MenuNewsInfoItem {

    //图文消息的标题
    private String title;
    //	摘要
    private String digest;
    //	作者
    private String author;
    //是否显示封面，0为不显示，1为显示
    @JsonProperty("show_cover")
    private Integer showCover;
    //封面图片的URL
    @JsonProperty("cover_url")
    private String coverUrl;
    //正文的URL
    @JsonProperty("content_url")
    private String contentUrl;
    //原文的URL，若置空则无查看原文入口
    @JsonProperty("source_url")
    private String sourceUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getShowCover() {
        return showCover;
    }

    public void setShowCover(Integer showCover) {
        this.showCover = showCover;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }
}
