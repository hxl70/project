package com.hxl.wx.handler;

import com.hxl.wx.entity.message.*;
import com.hxl.wx.entity.reply.*;
import com.hxl.wx.factory.ReturnMessageFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by hxl on 2016/11/22.
 */
@Component
public class DefaultMessageHandler implements MessageHandler {

    public ReplyMessage handlerText(TextMessage message) {
        ReplyTextMessage replyTextMessage = ReturnMessageFactory.buildReturnMessage(new ReplyTextMessage(), message);
        replyTextMessage.setContent("文本");
        return replyTextMessage;
    }

    public ReplyMessage handlerImage(ImageMessage message) {
        ReplyImageMessage replyImageMessage = ReturnMessageFactory.buildReturnMessage(new ReplyImageMessage(), message);
        replyImageMessage.addMedia(message.getMediaId());
        return replyImageMessage;
    }

    public ReplyMessage handlerVoice(VoiceMessage message) {
        ReplyVoiceMessage replyVoiceMessage = ReturnMessageFactory.buildReturnMessage(new ReplyVoiceMessage(), message);
        replyVoiceMessage.addMedia(message.getMediaId());
        return replyVoiceMessage;
    }

    public ReplyMessage handlerVideo(VideoMessage message) {
        ReplyVideoMessage replyVideoMessage = ReturnMessageFactory.buildReturnMessage(new ReplyVideoMessage(), message);
        replyVideoMessage.addVideo("视屏", message.getMediaId(), message.getThumbMediaId());
        return replyVideoMessage;
    }

    public ReplyMessage handlerShortVideo(ShortVideoMessage message) {
        ReplyTextMessage replyTextMessage = ReturnMessageFactory.buildReturnMessage(new ReplyTextMessage(), message);
        replyTextMessage.setContent("小视屏");
        return replyTextMessage;
    }

    public ReplyMessage handlerLocation(LocationMessage message) {
        ReplyTextMessage replyTextMessage = ReturnMessageFactory.buildReturnMessage(new ReplyTextMessage(), message);
        replyTextMessage.setContent("地理位置");
        return replyTextMessage;
    }

    public ReplyMessage handlerLink(LinkMessage message) {
        ReplyTextMessage replyTextMessage = ReturnMessageFactory.buildReturnMessage(new ReplyTextMessage(), message);
        replyTextMessage.setContent("链接");
        return replyTextMessage;
    }

}
