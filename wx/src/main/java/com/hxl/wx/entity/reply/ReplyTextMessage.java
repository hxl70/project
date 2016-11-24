package com.hxl.wx.entity.reply;

import com.hxl.wx.enumerate.ReplyMessageType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by hxl on 2016/11/23.
 */
@XmlRootElement(name = "xml")
public class ReplyTextMessage extends ReplyMessage {

    public ReplyTextMessage() {
        super(ReplyMessageType.text);
    }

    private String content;

    @XmlElement(name = "Content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
