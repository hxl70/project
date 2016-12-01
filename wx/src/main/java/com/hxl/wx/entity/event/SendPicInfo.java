package com.hxl.wx.entity.event;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxl on 2016/12/1.
 * 	发送的图片信息
 */
public class SendPicInfo {

    //	发送的图片数量
    private Integer count;
    //	图片列表
    private List<PicItem> picList = new ArrayList<>();

    @XmlElement(name = "Count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @XmlElement(name = "PicList")
    public List<PicItem> getPicList() {
        return picList;
    }

    public void setPicList(List<PicItem> picList) {
        this.picList = picList;
    }
}
