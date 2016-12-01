package com.hxl.wx.entity.event;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by hxl on 2016/12/1.
 * 图片的MD5值，开发者若需要，可用于验证接收到图片
 */
@XmlRootElement(name = "item")
public class PicItem {

    //图片的MD5值，开发者若需要，可用于验证接收到图片
    private String picMd5Sum;

    @XmlElement(name = "PicMd5Sum")
    public String getPicMd5Sum() {
        return picMd5Sum;
    }

    public void setPicMd5Sum(String picMd5Sum) {
        this.picMd5Sum = picMd5Sum;
    }
}
