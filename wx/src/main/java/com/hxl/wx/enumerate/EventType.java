package com.hxl.wx.enumerate;

/**
 * Created by hxl on 2016/11/22.
 */
public enum EventType {

    //订阅
    subscribe,
    //取消订阅
    unsubscribe,
    //用户已关注时的事件推送
    SCAN,
    //上报地理位置事件
    LOCATION,
    //自定义菜单事件
    CLICK

}
