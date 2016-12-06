package com.hxl.wx.entity.media;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by hxl on 2016/12/6.
 */
public class MediaCount {

    @JsonProperty("voice_count")
    private Integer voiceCount;
    @JsonProperty("video_count")
    private Integer videoCount;
    @JsonProperty("image_count")
    private Integer imageCount;
    @JsonProperty("news_count")
    private Integer newsCount;

    public Integer getVoiceCount() {
        return voiceCount;
    }

    public void setVoiceCount(Integer voiceCount) {
        this.voiceCount = voiceCount;
    }

    public Integer getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(Integer videoCount) {
        this.videoCount = videoCount;
    }

    public Integer getImageCount() {
        return imageCount;
    }

    public void setImageCount(Integer imageCount) {
        this.imageCount = imageCount;
    }

    public Integer getNewsCount() {
        return newsCount;
    }

    public void setNewsCount(Integer newsCount) {
        this.newsCount = newsCount;
    }
}
