package com.hxl.wx.entity.media;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxl on 2016/12/6.
 */
public class Media {

    private List<MediaArticle> articles = new ArrayList<>();

    public List<MediaArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<MediaArticle> articles) {
        this.articles = articles;
    }
}
