package com.hxl.wx.handler;

import com.hxl.wx.entity.ReturnTextMessage;
import com.hxl.wx.utils.XmlUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by hxl on 2016/11/22.
 */
@Component
public class DefaultMessageHandler implements MessageHandler {

    public String handlerText(Map<String, String> map) {
        ReturnTextMessage textMessage = new ReturnTextMessage();
        textMessage.setFromUserName(map.get("ToUserName"));
        textMessage.setToUserName(map.get("FromUserName"));
        textMessage.setCreateTime(Integer.valueOf(String.valueOf(System.currentTimeMillis() / 1000)));
        textMessage.setContext("文本");
        return XmlUtils.marshal(textMessage);
    }

    public String handlerImage(Map<String, String> map) {
        ReturnTextMessage textMessage = new ReturnTextMessage();
        textMessage.setFromUserName(map.get("ToUserName"));
        textMessage.setToUserName(map.get("FromUserName"));
        textMessage.setCreateTime(Integer.valueOf(String.valueOf(System.currentTimeMillis() / 1000)));
        textMessage.setContext("图片");
        return XmlUtils.marshal(textMessage);
    }

    public String handlerVoice(Map<String, String> map) {
        ReturnTextMessage textMessage = new ReturnTextMessage();
        textMessage.setFromUserName(map.get("ToUserName"));
        textMessage.setToUserName(map.get("FromUserName"));
        textMessage.setCreateTime(Integer.valueOf(String.valueOf(System.currentTimeMillis() / 1000)));
        textMessage.setContext("语音");
        return XmlUtils.marshal(textMessage);
    }

    public String handlerVideo(Map<String, String> map) {
        ReturnTextMessage textMessage = new ReturnTextMessage();
        textMessage.setFromUserName(map.get("ToUserName"));
        textMessage.setToUserName(map.get("FromUserName"));
        textMessage.setCreateTime(Integer.valueOf(String.valueOf(System.currentTimeMillis() / 1000)));
        textMessage.setContext("视频");
        return XmlUtils.marshal(textMessage);
    }

    public String handlerShortVideo(Map<String, String> map) {
        ReturnTextMessage textMessage = new ReturnTextMessage();
        textMessage.setFromUserName(map.get("ToUserName"));
        textMessage.setToUserName(map.get("FromUserName"));
        textMessage.setCreateTime(Integer.valueOf(String.valueOf(System.currentTimeMillis() / 1000)));
        textMessage.setContext("小视频");
        return XmlUtils.marshal(textMessage);
    }

    public String handlerLocation(Map<String, String> map) {
        ReturnTextMessage textMessage = new ReturnTextMessage();
        textMessage.setFromUserName(map.get("ToUserName"));
        textMessage.setToUserName(map.get("FromUserName"));
        textMessage.setCreateTime(Integer.valueOf(String.valueOf(System.currentTimeMillis() / 1000)));
        textMessage.setContext("地理位置");
        return XmlUtils.marshal(textMessage);
    }

    public String handlerLink(Map<String, String> map) {
        ReturnTextMessage textMessage = new ReturnTextMessage();
        textMessage.setFromUserName(map.get("ToUserName"));
        textMessage.setToUserName(map.get("FromUserName"));
        textMessage.setCreateTime(Integer.valueOf(String.valueOf(System.currentTimeMillis() / 1000)));
        textMessage.setContext("链接");
        return XmlUtils.marshal(textMessage);
    }

}
