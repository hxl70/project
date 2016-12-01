package com.hxl.wx.entity.event;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by hxl on 2016/12/1.
 * 发送的位置信息
 */
public class SendLocationInfo {

    //	X坐标信息
    private String locationX;
    //	Y坐标信息
    private String locationY;
    //	精度，可理解为精度或者比例尺、越精细的话 scale越高
    private String scale;
    //	地理位置的字符串信息
    private String label;
    //	朋友圈POI的名字，可能为空
    private String poiName;

    @XmlElement(name = "Location_X")
    public String getLocationX() {
        return locationX;
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    @XmlElement(name = "Location_Y")
    public String getLocationY() {
        return locationY;
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }

    @XmlElement(name = "Scale")
    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    @XmlElement(name = "Label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @XmlElement(name = "Poiname")
    public String getPoiName() {
        return poiName;
    }

    public void setPoiName(String poiName) {
        this.poiName = poiName;
    }
}
