package com.hxl.wx.entity.message;

import com.hxl.wx.enumerate.MessageType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by hxl on 2016/11/22.
 */
@XmlRootElement(name = "xml")
public class VoiceMessage extends Message {

    public VoiceMessage() {
        super(MessageType.voice);
    }

    private String mediaId;
    private String format;

    @XmlElement(name = "MediaId")
    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    @XmlElement(name = "Format")
    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
