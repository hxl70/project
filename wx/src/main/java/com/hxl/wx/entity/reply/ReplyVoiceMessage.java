package com.hxl.wx.entity.reply;

import com.hxl.wx.enumerate.ReplyMessageType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxl on 2016/11/24.
 */
@XmlRootElement(name = "xml")
public class ReplyVoiceMessage extends ReplyMessage {

    public ReplyVoiceMessage() {
        super(ReplyMessageType.voice);
    }

    private List<Media> mediaIds = new ArrayList<>();

    @XmlElement(name = "Voice")
    public List<Media> getMediaIds() {
        return mediaIds;
    }

    public void setMediaIds(List<Media> mediaIds) {
        this.mediaIds = mediaIds;
    }

    public void addMedia(String mediaId) {
        mediaIds.add(new Media(mediaId));
    }
}
