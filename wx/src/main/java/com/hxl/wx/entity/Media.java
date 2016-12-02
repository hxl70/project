package com.hxl.wx.entity;

import java.io.InputStream;

/**
 * Created by hxl on 2016/12/1.
 */
public class Media {

    private String type;
    private InputStream media;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public InputStream getMedia() {
        return media;
    }

    public void setMedia(InputStream media) {
        this.media = media;
    }
}
