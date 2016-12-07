package com.hxl.wx.entity.event;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by hxl on 2016/12/1.
 * 弹出地理位置选择器的事件推送
 */
@XmlRootElement(name = "xml")
public class LocationSelectEvent extends EventMessage {

    //	事件KEY值，由开发者在创建菜单时设定
    private String eventKey;
    //	发送的位置信息
    private SendLocationInfo sendLocationInfo;

    @XmlElement(name = "EventKey")
    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    @XmlElement(name = "SendLocationInfo")
    public SendLocationInfo getSendLocationInfo() {
        return sendLocationInfo;
    }

    public void setSendLocationInfo(SendLocationInfo sendLocationInfo) {
        this.sendLocationInfo = sendLocationInfo;
    }
}
