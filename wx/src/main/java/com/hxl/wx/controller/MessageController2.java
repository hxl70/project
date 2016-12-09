package com.hxl.wx.controller;

import com.hxl.wx.entity.WXUri;
import com.hxl.wx.entity.event.*;
import com.hxl.wx.entity.message.*;
import com.hxl.wx.entity.reply.ReplyMessage;
import com.hxl.wx.handler.DefaultHandler;
import com.hxl.wx.utils.XmlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hxl on 2016/11/21.
 * 消息处理类,处理所有的消息,事件
 */
@Controller
public class MessageController2 {

    private Logger logger = LoggerFactory.getLogger(MessageController2.class);

    private DefaultHandler handler = new DefaultHandler();

    private Map<String, Class<? extends Message>> messageMapper = new HashMap<>();
    private Map<String, Class<? extends EventMessage>> eventMapper = new HashMap<>();

    public MessageController2() {
        messageMapper.put("text", TextMessage.class);
        messageMapper.put("image", ImageMessage.class);
        messageMapper.put("voice", VoiceMessage.class);
        messageMapper.put("video", VideoMessage.class);
        messageMapper.put("shortvideo", ShortVideoMessage.class);
        messageMapper.put("location", LocationMessage.class);
        messageMapper.put("link", LinkMessage.class);

        eventMapper.put("subscribe", SubscribeEvent.class);
        eventMapper.put("unsubscribe", UnSubscribeEvent.class);
        eventMapper.put("SCAN", ScanEvent.class);
        eventMapper.put("LOCATION", LocationEvent.class);
        eventMapper.put("CLICK", ClickEvent.class);
        eventMapper.put("VIEW", ViewEvent.class);
        eventMapper.put("scancode_push", ScanCodePushEvent.class);
        eventMapper.put("scancode_waitmsg", ScanCodeWaitMsgEvent.class);
        eventMapper.put("pic_sysphoto", PicSysPhotoEvent.class);
        eventMapper.put("pic_photo_or_album", PicPhotoOrAlbumEvent.class);
        eventMapper.put("pic_weixin", PicWeiXinEvent.class);
        eventMapper.put("location_select", LocationSelectEvent.class);
        eventMapper.put("qualification_verify_success", QualificationVerifySuccessEvent.class);
        eventMapper.put("qualification_verify_fail", QualificationVerifyFailEvent.class);
        eventMapper.put("naming_verify_success", NamingVerifySuccessEvent.class);
        eventMapper.put("naming_verify_fail", NamingVerifyFailEvent.class);
        eventMapper.put("annual_renew", AnnualRenewEvent.class);
        eventMapper.put("verify_expired", VerifyExpiredEvent.class);
    }

    /**
     * 消息处理
     * @param requestBody
     * @return
     */
    @ResponseBody
    @RequestMapping(value = WXUri.URI, method = RequestMethod.POST)
    public String message(@RequestBody String requestBody) {
        Map<String, String> map = XmlUtils.parseRequestBody(requestBody);
        logger.info(requestBody);
        String type = map.get("MsgType");
        ReplyMessage result = null;

        if (type.equals("event")) {
            String event = map.get("Event");
            Class<? extends EventMessage> eventClass = eventMapper.get(event);
            if (eventClass != null) {
                result = handler.handler(XmlUtils.toBean(requestBody, eventClass));
            } else {
                logger.error("unknown event: {}", event);
            }
        } else {
            Class<? extends Message> messageClass = messageMapper.get(type);
            if (messageClass != null) {
                result = handler.handler(XmlUtils.toBean(requestBody, messageClass));
            } else {
                logger.error("unknown type: {}", type);
            }
        }

        if (result == null) {
            return "";
        }

        String marshal = XmlUtils.marshal(result);
        logger.info("return {}", marshal);
        return marshal;
    }

}
