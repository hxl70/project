package com.hxl.wx.entity.message;

import com.hxl.wx.enumerate.MessageType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by hxl on 2016/11/22.
 */
@XmlRootElement(name = "xml")
public class LinkMessage extends Message {

    public LinkMessage() {
        super(MessageType.link);
    }

    private String title;
    private String description;
    private String url;

    @XmlElement(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement(name = "Url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
