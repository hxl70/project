package com.hxl.wx.handler;

import java.util.Map;

/**
 * Created by hxl on 2016/11/22.
 * 事件帮助接口
 */
public interface EventHandler {


    /**
     * 关注/扫码关注处理
     * @param map
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID）
     * CreateTime	消息创建时间 （整型）
     * MsgType	消息类型，event
     * Event	事件类型，subscribe(订阅)
     * EventKey	事件KEY值，qrscene_为前缀，后面为二维码的参数值(扫描二维码时产生)
     * Ticket	二维码的ticket，可用来换取二维码图片(扫描二维码时产生)
     * @return
     */
    String handlerSubscribe(Map<String, String> map);

    /**
     * 取消关注处理
     * @param map
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID）
     * CreateTime	消息创建时间 （整型）
     * MsgType	消息类型，event
     * Event	事件类型，unsubscribe(取消订阅)
     * @return
     */
    String handlerUnSubscribe(Map<String, String> map);

    /**
     * 已关注处理
     * @param map
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID）
     * CreateTime	消息创建时间 （整型）
     * MsgType	消息类型，event
     * Event	事件类型，SCAN
     * EventKey	事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
     * Ticket	二维码的ticket，可用来换取二维码图片
     * @return
     */
    String handlerScan(Map<String, String> map);

    /**
     * 上报地理位置事件处理
     * @param map
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID）
     * CreateTime	消息创建时间 （整型）
     * MsgType	消息类型，event
     * Event	事件类型，LOCATION
     * Latitude	地理位置纬度
     * Longitude	地理位置经度
     * Precision	地理位置精度
     * @return
     */
    String handlerLocation(Map<String, String> map);

    /**
     * 自定义菜单事件处理
     * @param map
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID）
     * CreateTime	消息创建时间 （整型）
     * MsgType	消息类型，event
     * Event	事件类型，CLICK
     * EventKey	事件KEY值，与自定义菜单接口中KEY值对应
     * @return
     */
    String handlerClick(Map<String, String> map);

    /**
     * 点击菜单跳转链接时的事件处理
     * @param map
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID）
     * CreateTime	消息创建时间 （整型）
     * MsgType	消息类型，event
     * Event	事件类型，VIEW
     * EventKey	事件KEY值，设置的跳转URL
     * @return
     */
    String handlerView(Map<String, String> map);

}
