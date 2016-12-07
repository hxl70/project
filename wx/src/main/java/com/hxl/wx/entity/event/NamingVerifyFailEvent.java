package com.hxl.wx.entity.event;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by hxl on 2016/12/6.
 */
@XmlRootElement(name = "xml")
public class NamingVerifyFailEvent extends EventMessage {

    private Long failTime;
    private String failReason;

    @XmlElement(name = "FailTime")
    public Long getFailTime() {
        return failTime;
    }

    public void setFailTime(Long failTime) {
        this.failTime = failTime;
    }

    @XmlElement(name = "FailReason")
    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }
}
