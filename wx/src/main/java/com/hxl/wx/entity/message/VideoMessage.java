package com.hxl.wx.entity.message;

import com.hxl.wx.enumerate.MessageType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by hxl on 2016/11/22.
 */
@XmlRootElement(name = "xml")
public class VideoMessage extends Message {

    public VideoMessage() {
        super(MessageType.video);
    }

    private String mediaId;
    private String thumbMediaId;

    @XmlElement(name = "MediaId")
    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    @XmlElement(name = "ThumbMediaId")
    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
}
