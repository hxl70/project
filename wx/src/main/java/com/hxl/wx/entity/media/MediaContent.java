package com.hxl.wx.entity.media;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxl on 2016/12/6.
 */
public class MediaContent {

    @JsonProperty("news_item")
    private List<MediaNewsItem> newsItems = new ArrayList<>();

    public List<MediaNewsItem> getNewsItems() {
        return newsItems;
    }

    public void setNewsItems(List<MediaNewsItem> newsItems) {
        this.newsItems = newsItems;
    }
}
