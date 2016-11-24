package com.hxl.wx.entity.reply;

import com.hxl.wx.enumerate.ReplyMessageType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxl on 2016/11/24.
 */
@XmlRootElement(name = "xml")
public class ReplyNewsMessage extends ReplyMessage {

    public ReplyNewsMessage() {
        super(ReplyMessageType.news);
    }

    private Integer articleCount;
    private List<Article> articles = new ArrayList<>();

    @XmlElement(name = "ArticleCount")
    public Integer getArticleCount() {
        return articles == null ? 0 : articles.size();
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    @XmlElementWrapper(name = "Articles")
    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void addArticle(String title, String description, String picUrl, String url) {
        articles.add(new Article(title, description, picUrl, url));
    }

}
