package com.hxl.wx.service;

/**
 * Created by hxl on 2016/11/18.
 * 如果公众号基于消息接收安全上的考虑，
 * 需要获知微信服务器的IP地址列表，
 * 以便识别出哪些消息是微信官方推送给你的，
 * 哪些消息可能是他人伪造的，
 * 可以通过该接口获得微信服务器IP地址列表。
 */
public interface WXServerIpService {

    String getIpList();

}
