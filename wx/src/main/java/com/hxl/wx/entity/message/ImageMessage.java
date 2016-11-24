package com.hxl.wx.entity.message;

import com.hxl.wx.enumerate.MessageType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by hxl on 2016/11/22.
 */
@XmlRootElement(name = "xml")
public class ImageMessage extends Message {

    public ImageMessage() {
        super(MessageType.image);
    }

    private String picUrl;
    private String mediaId;

    @XmlElement(name = "PicUrl")
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @XmlElement(name = "MediaId")
    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
