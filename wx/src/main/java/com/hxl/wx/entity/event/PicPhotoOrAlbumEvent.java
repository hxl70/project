package com.hxl.wx.entity.event;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by hxl on 2016/12/1.
 * 弹出拍照或者相册发图的事件推送
 */
@XmlRootElement(name = "xml")
public class PicPhotoOrAlbumEvent extends EventMessage {

    //事件KEY值，由开发者在创建菜单时设定
    private String eventKey;
    //弹出拍照或者相册发图的事件推送
    private SendPicInfo sendPicInfo;

    @XmlElement(name = "EventKey")
    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    @XmlElement(name = "SendPicsInfo")
    public SendPicInfo getSendPicInfo() {
        return sendPicInfo;
    }

    public void setSendPicInfo(SendPicInfo sendPicInfo) {
        this.sendPicInfo = sendPicInfo;
    }
}
