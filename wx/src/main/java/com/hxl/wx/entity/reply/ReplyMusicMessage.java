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
public class ReplyMusicMessage extends ReplyMessage {

    public ReplyMusicMessage() {
        super(ReplyMessageType.music);
    }

    private List<Music> musics = new ArrayList<>();

    @XmlElement(name = "Music")
    public List<Music> getMusics() {
        return musics;
    }

    public void setMusics(List<Music> musics) {
        this.musics = musics;
    }

    public void addMusic(String title, String description, String musicUrl, String hqMusicUrl, String thumbMediaId) {
        musics.add(new Music(title, description, musicUrl, hqMusicUrl, thumbMediaId));
    }

}
