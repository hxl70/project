package com.hxl.wx.handler;

import com.hxl.wx.entity.message.*;
import com.hxl.wx.entity.reply.ReplyMessage;
import com.hxl.wx.entity.reply.ReplyTextMessage;
import com.hxl.wx.factory.ReturnMessageFactory;
import org.springframework.stereotype.Component;

/**
 * Created by hxl on 2016/11/22.
 */
@Component
public class DefaultEventHandler implements EventHandler {

    public ReplyMessage handlerSubscribe(SubscribeEventMessage message) {
        ReplyTextMessage replyTextMessage = ReturnMessageFactory.buildReturnMessage(new ReplyTextMessage(), message);
        replyTextMessage.setContent("关注");
        return replyTextMessage;
    }

    public ReplyMessage handlerUnSubscribe(UnSubscribeEventMessage message) {
        ReplyTextMessage replyTextMessage = ReturnMessageFactory.buildReturnMessage(new ReplyTextMessage(), message);
        replyTextMessage.setContent("取消关注");
        return replyTextMessage;
    }

    public ReplyMessage handlerScan(ScanEventMessage message) {
        ReplyTextMessage replyTextMessage = ReturnMessageFactory.buildReturnMessage(new ReplyTextMessage(), message);
        replyTextMessage.setContent("已关注");
        return replyTextMessage;
    }

    public ReplyMessage handlerLocation(LocationEventMessage message) {
        ReplyTextMessage replyTextMessage = ReturnMessageFactory.buildReturnMessage(new ReplyTextMessage(), message);
        replyTextMessage.setContent("上报地理位置");
        return replyTextMessage;
    }

    @Override
    public ReplyMessage handlerMenu(MenuEventMessage message) {
        ReplyTextMessage replyTextMessage = ReturnMessageFactory.buildReturnMessage(new ReplyTextMessage(), message);
        replyTextMessage.setContent("菜单事件");
        return replyTextMessage;
    }
}
