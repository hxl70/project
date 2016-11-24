package com.hxl.wx.entity.message;

import com.hxl.wx.enumerate.MessageType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by hxl on 2016/11/22.
 */
@XmlRootElement(name = "xml")
public class TextMessage extends Message {

    public TextMessage() {
        super(MessageType.text);
    }

    private String context;

    @XmlElement(name = "Content")
    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
