package com.hxl.wx.entity.media;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by hxl on 2016/12/6.
 */
public class MediaNewsItem {

    // 图文消息的标题
    private String title;
    // 图文消息的封面图片素材id（必须是永久mediaID）
    @JsonProperty("thumb_media_id")
    private String thumbMediaId;
    //图文消息的封面图片的地址，第三方开发者也可以使用这个URL下载图片到自己服务器中，然后显示在自己网站上
    @JsonProperty("thumb_url")
    private String thumbUrl;
    //是否显示封面，0为false，即不显示，1为true，即显示
    @JsonProperty("show_cover_pic")
    private Integer showCoverPic;
    //作者
    private String author;
    //图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
    private String digest;
    //图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
    private String content;
    //图文页的URL，或者，当获取的列表是图片素材列表时，该字段是图片的URL
    private String url;
    //图文消息的原文地址，即点击“阅读原文”后的URL
    @JsonProperty("content_source_url")
    private String contentSourceUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public Integer getShowCoverPic() {
        return showCoverPic;
    }

    public void setShowCoverPic(Integer showCoverPic) {
        this.showCoverPic = showCoverPic;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContentSourceUrl() {
        return contentSourceUrl;
    }

    public void setContentSourceUrl(String contentSourceUrl) {
        this.contentSourceUrl = contentSourceUrl;
    }
}
