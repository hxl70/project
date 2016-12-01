package com.hxl.wx.controller;

import com.hxl.wx.entity.*;
import com.hxl.wx.entity.message.*;
import com.hxl.wx.entity.reply.ReplyMessage;
import com.hxl.wx.handler.EventHandler;
import com.hxl.wx.handler.MessageHandler;
import com.hxl.wx.utils.XmlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by hxl on 2016/11/21.
 * 消息处理类,处理所有的消息,事件
 */
@Controller
public class MessageController {

    private Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private EventHandler eventHandler;
    @Autowired
    private MessageHandler messageHandler;

    /**
     * 消息处理
     * @param requestBody
     * @return
     */
    @ResponseBody
    @RequestMapping(value = WXConfig.WX_URI, method = RequestMethod.POST)
    public String message(@RequestBody String requestBody) {
        Map<String, String> map = XmlUtils.parseRequestBody(requestBody);
        logger.info(requestBody);
        String type = map.get("MsgType");
        ReplyMessage result = null;
        switch (type) {
            case "event":
                String event = map.get("Event");
                result = handlerEvent(requestBody, event);
                break;
            case "text":
                result = messageHandler.handlerText(XmlUtils.toBean(requestBody, TextMessage.class));
                break;
            case "image":
                result = messageHandler.handlerImage(XmlUtils.toBean(requestBody, ImageMessage.class));
                break;
            case "voice":
                result = messageHandler.handlerVoice(XmlUtils.toBean(requestBody, VoiceMessage.class));
                break;
            case "video":
                result = messageHandler.handlerVideo(XmlUtils.toBean(requestBody, VideoMessage.class));
                break;
            case "shortvideo":
                result = messageHandler.handlerShortVideo(XmlUtils.toBean(requestBody, ShortVideoMessage.class));
                break;
            case "location":
                result = messageHandler.handlerLocation(XmlUtils.toBean(requestBody, LocationMessage.class));
                break;
            case "link":
                result = messageHandler.handlerLink(XmlUtils.toBean(requestBody, LinkMessage.class));
                break;
            default:
                logger.error("unknow type " + type);
        }
        if (result == null) {
            logger.info("return null");
            return "";
        }
        String marshal = XmlUtils.marshal(result);
        logger.info("return {}", marshal);
        return marshal;
    }

    /**
     * 事件处理
     * @param event 事件类型
     * @return
     */
    private ReplyMessage handlerEvent(String requestBody, String event) {
        switch (event) {
            case "subscribe":
                return eventHandler.handlerSubscribe(XmlUtils.toBean(requestBody, SubscribeEventMessage.class));
            case "unsubscribe":
                return eventHandler.handlerUnSubscribe(XmlUtils.toBean(requestBody, UnSubscribeEventMessage.class));
            case "SCAN":
                return eventHandler.handlerScan(XmlUtils.toBean(requestBody, ScanEventMessage.class));
            case "LOCATION":
                return eventHandler.handlerLocation(XmlUtils.toBean(requestBody, LocationEventMessage.class));
            case "CLICK":
                return eventHandler.handlerMenu(XmlUtils.toBean(requestBody, MenuEventMessage.class));
            case "VIEW":
                return eventHandler.handlerMenu(XmlUtils.toBean(requestBody, MenuEventMessage.class));
            default:
                logger.error("unknown event {}", event);
        }
        return null;
    }

}
