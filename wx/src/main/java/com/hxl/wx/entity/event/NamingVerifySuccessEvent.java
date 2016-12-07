package com.hxl.wx.entity.event;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by hxl on 2016/12/6.
 */
@XmlRootElement(name = "xml")
public class NamingVerifySuccessEvent extends EventMessage {

    public Long getExpiredTime() {
        return expiredTime;
    }

    @XmlElement(name = "ExpiredTime")
    public void setExpiredTime(Long expiredTime) {
        this.expiredTime = expiredTime;
    }

    private Long expiredTime;

}
