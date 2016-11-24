package com.hxl.wx.entity.reply;

import com.hxl.wx.enumerate.ReplyMessageType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxl on 2016/11/24.
 */
@XmlRootElement(name = "xml")
public class ReplyVideoMessage extends ReplyMessage {

    public ReplyVideoMessage() {
        super(ReplyMessageType.video);
    }

    private List<Video> videos = new ArrayList<>();

    @XmlElement(name = "Video")
    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public void addVideo(String title, String mediaId, String description) {
        videos.add(new Video(mediaId, title, description));
    }
}
