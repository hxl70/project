package com.hxl.wx.factory;

import com.hxl.wx.entity.message.Message;
import com.hxl.wx.entity.reply.ReplyMessage;

/**
 * Created by hxl on 2016/11/23.
 */
public class ReturnMessageFactory {

    public static <T extends ReplyMessage> T buildReturnMessage(T t, Message message) {
        setProperties(message, t);
        return t;
    }

    private static void setProperties(Message from, ReplyMessage to) {
        to.setFromUserName(from.getToUserName());
        to.setToUserName(from.getFromUserName());
        to.setCreateTime(Integer.valueOf(String.valueOf(System.currentTimeMillis() / 1000)));
    }

}
