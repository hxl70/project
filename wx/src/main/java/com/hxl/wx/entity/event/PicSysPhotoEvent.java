package com.hxl.wx.entity.event;

import com.hxl.wx.entity.message.EventMessage;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by hxl on 2016/12/1.
 */
public class PicSysPhotoEvent extends EventMessage {

    //	事件KEY值，由开发者在创建菜单时设定
    private String eventKey;
    //	发送的图片信息
    private SendPicInfo sendPicsInfo;

    @XmlElement(name = "EventKey")
    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    @XmlElement(name = "SendPicsInfo")
    public SendPicInfo getSendPicsInfo() {
        return sendPicsInfo;
    }

    public void setSendPicsInfo(SendPicInfo sendPicsInfo) {
        this.sendPicsInfo = sendPicsInfo;
    }

}
