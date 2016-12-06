package com.hxl.wx.entity.event;

import com.hxl.wx.entity.message.EventMessage;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by hxl on 2016/12/6.
 */
@XmlRootElement(name = "xml")
public class QualificationVerifySuccessEvent extends EventMessage {

    //有效期 (整形)，指的是时间戳，将于该时间戳认证过期
    private Long expiredTime;

    @XmlElement(name = "ExpiredTime")
    public Long getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Long expiredTime) {
        this.expiredTime = expiredTime;
    }
}
