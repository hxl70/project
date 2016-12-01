package com.hxl.wx.entity.event;

import com.hxl.wx.entity.message.EventMessage;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by hxl on 2016/11/23.
 */
@XmlRootElement(name = "xml")
public class LocationEvent extends EventMessage {

    //地理位置纬度
    private String latitude;
    //地理位置经度
    private String longitude;
    //地理位置精度
    private String precision;

    @XmlElement(name = "Latitude")
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @XmlElement(name = "Longitude")
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @XmlElement(name = "Precision")
    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }
}
