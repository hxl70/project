package com.hxl.wx.entity.reply;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by hxl on 2016/11/24.
 */
public class Music {

    private String title;

    private String description;

    private String musicUrl;

    private String hqMusicUrl;

    private String thumbMediaId;

    public Music() {
    }

    public Music(String title, String description, String musicUrl, String hqMusicUrl, String thumbMediaId) {
        this.title = title;
        this.description = description;
        this.musicUrl = musicUrl;
        this.hqMusicUrl = hqMusicUrl;
        this.thumbMediaId = thumbMediaId;
    }

    @XmlElement(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement(name = "MusicUrl")
    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    @XmlElement(name = "HQMusicUrl")
    public String getHqMusicUrl() {
        return hqMusicUrl;
    }

    public void setHqMusicUrl(String hqMusicUrl) {
        this.hqMusicUrl = hqMusicUrl;
    }

    @XmlElement(name = "ThumbMediaId")
    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
}
