package com.hxl.wx.controller;

import com.hxl.wx.entity.WXUri;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hxl on 2016/11/18.
 * 微信接入控制
 */
@Controller
public class InitController {

    private Logger logger = LoggerFactory.getLogger(InitController.class);

    /**
     * 返回echostr表示接入成功
     * @param echostr echostr
     * @return echostr
     */
    @ResponseBody
    @RequestMapping(value = WXUri.URI, method = RequestMethod.GET)
    public String init(@RequestParam("echostr") String echostr) {
        logger.info("微信接入成功");
        return echostr;
    }

}
