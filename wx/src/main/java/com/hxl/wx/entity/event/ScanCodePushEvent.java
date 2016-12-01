package com.hxl.wx.entity.event;

import com.hxl.wx.entity.message.EventMessage;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by hxl on 2016/12/1.
 */
@XmlRootElement(name = "xml")
public class ScanCodePushEvent extends EventMessage {

    private String eventKey;
    private String scanCodeInfo;
    private String scanType;
    private String scanResult;

    @XmlElement(name = "EventKey")
    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    @XmlElement(name = "ScanCodeInfo")
    public String getScanCodeInfo() {
        return scanCodeInfo;
    }

    public void setScanCodeInfo(String scanCodeInfo) {
        this.scanCodeInfo = scanCodeInfo;
    }

    @XmlElement(name = "ScanType")
    public String getScanType() {
        return scanType;
    }

    public void setScanType(String scanType) {
        this.scanType = scanType;
    }

    @XmlElement(name = "ScanResult")
    public String getScanResult() {
        return scanResult;
    }

    public void setScanResult(String scanResult) {
        this.scanResult = scanResult;
    }
}
