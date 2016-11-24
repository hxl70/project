package com.hxl.wx.entity.message;

import com.hxl.wx.enumerate.MessageType;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by hxl on 2016/11/23.
 * subscribe(订阅)、unsubscribe(取消订阅)
 */
public class EventMessage extends Message {

    public EventMessage() {
        super(MessageType.event);
    }

    private String event;

    @XmlElement(name = "Event")
    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
