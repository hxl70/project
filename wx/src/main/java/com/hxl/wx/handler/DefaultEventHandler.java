package com.hxl.wx.handler;

import com.hxl.wx.entity.ReturnTextMessage;
import com.hxl.wx.utils.XmlUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by hxl on 2016/11/22.
 */
@Component
public class DefaultEventHandler implements EventHandler {

    public String handlerSubscribe(Map<String, String> map) {
        ReturnTextMessage textMessage = new ReturnTextMessage();
        textMessage.setFromUserName(map.get("ToUserName"));
        textMessage.setToUserName(map.get("FromUserName"));
        textMessage.setCreateTime(Integer.valueOf(String.valueOf(System.currentTimeMillis() / 1000)));
        textMessage.setContext("关注");
        return XmlUtils.marshal(textMessage);
    }

    public String handlerUnSubscribe(Map<String, String> map) {
        ReturnTextMessage textMessage = new ReturnTextMessage();
        textMessage.setFromUserName(map.get("ToUserName"));
        textMessage.setToUserName(map.get("FromUserName"));
        textMessage.setCreateTime(Integer.valueOf(String.valueOf(System.currentTimeMillis() / 1000)));
        textMessage.setContext("取消关注");
        return XmlUtils.marshal(textMessage);
    }

    public String handlerScan(Map<String, String> map) {
        ReturnTextMessage textMessage = new ReturnTextMessage();
        textMessage.setFromUserName(map.get("ToUserName"));
        textMessage.setToUserName(map.get("FromUserName"));
        textMessage.setCreateTime(Integer.valueOf(String.valueOf(System.currentTimeMillis() / 1000)));
        textMessage.setContext("已关注");
        return XmlUtils.marshal(textMessage);
    }

    public String handlerLocation(Map<String, String> map) {
        ReturnTextMessage textMessage = new ReturnTextMessage();
        textMessage.setFromUserName(map.get("ToUserName"));
        textMessage.setToUserName(map.get("FromUserName"));
        textMessage.setCreateTime(Integer.valueOf(String.valueOf(System.currentTimeMillis() / 1000)));
        textMessage.setContext("上报地理位置");
        return XmlUtils.marshal(textMessage);
    }

    public String handlerClick(Map<String, String> map) {
        ReturnTextMessage textMessage = new ReturnTextMessage();
        textMessage.setFromUserName(map.get("ToUserName"));
        textMessage.setToUserName(map.get("FromUserName"));
        textMessage.setCreateTime(Integer.valueOf(String.valueOf(System.currentTimeMillis() / 1000)));
        textMessage.setContext("自定义菜单");
        return XmlUtils.marshal(textMessage);
    }

    public String handlerView(Map<String, String> map) {
        ReturnTextMessage textMessage = new ReturnTextMessage();
        textMessage.setFromUserName(map.get("ToUserName"));
        textMessage.setToUserName(map.get("FromUserName"));
        textMessage.setCreateTime(Integer.valueOf(String.valueOf(System.currentTimeMillis() / 1000)));
        textMessage.setContext("点击菜单");
        return XmlUtils.marshal(textMessage);
    }

}
