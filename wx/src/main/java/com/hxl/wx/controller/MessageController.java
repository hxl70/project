package com.hxl.wx.controller;

import com.hxl.wx.entity.WXInfo;
import com.hxl.wx.handler.EventHandler;
import com.hxl.wx.handler.MessageHandler;
import com.hxl.wx.utils.XmlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by hxl on 2016/11/21.
 * 消息处理类,处理所有的消息,事件
 */
@Controller
public class MessageController {

    @Autowired
    private EventHandler eventHandler;
    @Autowired
    private MessageHandler messageHandler;

    /**
     * 消息处理
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = WXInfo.WX_URI, method = RequestMethod.POST)
    public String message(HttpServletRequest request) {
        Map<String, String> map = XmlUtils.parseRequestBody(request);
        System.out.println(map);
        String type = map.get("MsgType");
        switch (type) {
            case "event":
                return handlerEvent(map);
            case "text":
                return messageHandler.handlerText(map);
            case "image":
                return messageHandler.handlerImage(map);
            case "voice":
                return messageHandler.handlerVoice(map);
            case "video":
                return messageHandler.handlerVideo(map);
            case "shortvideo":
                return messageHandler.handlerShortVideo(map);
            case "location":
                return messageHandler.handlerLocation(map);
            case "link":
                return messageHandler.handlerLink(map);
        }

        return null;
    }

    /**
     * 事件处理
     * @param map
     * @return
     */
    private String handlerEvent(Map<String, String> map) {
        String event = map.get("Event");
        switch (event) {
            case "subscribe":
                return eventHandler.handlerSubscribe(map);
            case "unsubscribe":
                return eventHandler.handlerUnSubscribe(map);
            case "SCAN":
                return eventHandler.handlerScan(map);
            case "LOCATION":
                return eventHandler.handlerLocation(map);
            case "CLICK":
                return eventHandler.handlerClick(map);
            case "VIEW":
                return eventHandler.handlerView(map);
        }
        return null;
    }


}
