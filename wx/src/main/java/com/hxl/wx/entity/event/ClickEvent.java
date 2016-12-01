package com.hxl.wx.entity.event;

import com.hxl.wx.entity.message.EventMessage;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by hxl on 2016/11/23.
 */
@XmlRootElement(name = "xml")
public class ClickEvent extends EventMessage {

    //事件KEY值，与自定义菜单接口中KEY值对应
    private String eventKey;

    @XmlElement(name = "EventKey")
    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
}
