package com.hxl.wx.service;

import com.hxl.wx.entity.WXInfo;

/**
 * Created by hxl on 2016/11/18.
 * 如果公众号基于消息接收安全上的考虑，
 * 需要获知微信服务器的IP地址列表，
 * 以便识别出哪些消息是微信官方推送给你的，
 * 哪些消息可能是他人伪造的，
 * 可以通过该接口获得微信服务器IP地址列表。
 */
public class WXServerIpService {

    private String url = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=%s";

    public String getIpList() {
        String ipList = HttpsService.get(String.format(url, WXInfo.ACCESS_TOKEN));
        return ipList;
    }

    public static void main(String[] args) {
        WXServerIpService serverIpService = new WXServerIpService();
        String ipList = serverIpService.getIpList();
        System.out.println(ipList);
    }

}
