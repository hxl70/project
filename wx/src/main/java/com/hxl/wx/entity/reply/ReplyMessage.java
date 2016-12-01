package com.hxl.wx.entity.reply;

import com.hxl.wx.enumerate.ReplyMessageType;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by hxl on 2016/11/23.
 */
public class ReplyMessage {

    private String toUserName;
    private String fromUserName;
    private Long createTime;
    private ReplyMessageType messageType;

    public ReplyMessage(ReplyMessageType messageType) {
        this.messageType = messageType;
    }

    @XmlElement(name = "ToUserName")
    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    @XmlElement(name = "FromUserName")
    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    @XmlElement(name = "CreateTime")
    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @XmlElement(name = "MsgType")
    public ReplyMessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(ReplyMessageType messageType) {
        this.messageType = messageType;
    }

}
