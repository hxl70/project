package com.hxl.wx.entity.reply;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by hxl on 2016/11/24.
 */
public class Video {

    private String mediaId;

    private String title;

    private String description;

    public Video() {
    }

    public Video(String mediaId, String title, String description) {
        this.mediaId = mediaId;
        this.title = title;
        this.description = description;
    }

    @XmlElement(name = "MediaId")
    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
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
}
