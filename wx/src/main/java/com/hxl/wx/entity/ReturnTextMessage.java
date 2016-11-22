package com.hxl.wx.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by hxl on 2016/11/21.
 */
@XmlRootElement(name = "xml")
public class ReturnTextMessage {

    private String toUserName;
    private String fromUserName;
    private Integer createTime;
    private String messageType = "text";
    private String context;

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
    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    @XmlElement(name = "MsgType")
    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    @XmlElement(name = "Content")
    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
