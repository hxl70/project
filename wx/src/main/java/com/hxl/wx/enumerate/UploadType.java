package com.hxl.wx.enumerate;

/**
 * Created by hxl on 2016/12/6.
 */
public enum  UploadType {

    IMAGE("image", "bmp/png/jpeg/jpg/gif"),
    VOICE("voice", "AMR\\MP3"),
    VEDIO("vedio", "mp4"),
    THUMB("thumb", "jps");


    private String name;
    private String mimeType;

    UploadType(String name, String mimeType) {
        this.name = name;
        this.mimeType = mimeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
}
