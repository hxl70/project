package com.hxl.wx.entity.reply;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by hxl on 2016/11/24.
 */
public class Media {

    public Media() {
    }

    public Media(String mediaId) {
        this.mediaId = mediaId;
    }

    private String mediaId;

    @XmlElement(name = "MediaId")
    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
