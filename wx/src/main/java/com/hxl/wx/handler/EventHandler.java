package com.hxl.wx.handler;

import com.hxl.wx.entity.event.*;
import com.hxl.wx.entity.reply.ReplyMessage;

/**
 * Created by hxl on 2016/11/22.
 * 事件帮助接口
 */
public interface EventHandler {


    /**
     * 关注/扫码关注处理
     * @param event
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
    ReplyMessage handlerSubscribe(SubscribeEvent event);

    /**
     * 取消关注处理
     * @param event
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID）
     * CreateTime	消息创建时间 （整型）
     * MsgType	消息类型，event
     * Event	事件类型，unsubscribe(取消订阅)
     * @return
     */
    ReplyMessage handlerUnSubscribe(UnSubscribeEvent event);

    /**
     * 已关注处理
     * @param event
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
    ReplyMessage handlerScan(ScanEvent event);

    /**
     * 上报地理位置事件处理
     * @param event
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
    ReplyMessage handlerLocation(LocationEvent event);

    /**
     * 自定义菜单事件处理
     * @param event
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID）
     * CreateTime	消息创建时间 （整型）
     * MsgType	消息类型，event
     * Event	事件类型，CLICK
     * EventKey	事件KEY值，与自定义菜单接口中KEY值对应, 设置的跳转URL
     * @return
     */
    ReplyMessage handlerClick(ClickEvent event);

    /**
     * 自定义菜单事件处理
     * @param event
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID）
     * CreateTime	消息创建时间 （整型）
     * MsgType	消息类型，event
     * Event	事件类型，VIEW
     * EventKey	事件KEY值，与自定义菜单接口中KEY值对应, 设置的跳转URL
     * @return
     */
    ReplyMessage handlerView(ViewEvent event);

    /**
     * 扫码推事件的事件推送
     * @param event
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID）
     * CreateTime	消息创建时间（整型）
     * MsgType	消息类型，event
     * Event	事件类型，scancode_push
     * EventKey	事件KEY值，由开发者在创建菜单时设定
     * ScanCodeInfo	扫描信息
     * ScanType	扫描类型，一般是qrcode
     * ScanResult	扫描结果，即二维码对应的字符串信息
     * @return
     */
    ReplyMessage handlerScanCodePush(ScanCodePushEvent event);

    /**
     * 扫码推事件且弹出“消息接收中”提示框的事件推送
     * @param event
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID）
     * CreateTime	消息创建时间（整型）
     * MsgType	消息类型，event
     * Event	事件类型，scancode_push,scancode_waitmsg
     * EventKey	事件KEY值，由开发者在创建菜单时设定
     * ScanCodeInfo	扫描信息
     * ScanType	扫描类型，一般是qrcode
     * ScanResult	扫描结果，即二维码对应的字符串信息
     * @return
     */
    ReplyMessage handlerScanCodeWaitMsg(ScanCodeWaitMsgEvent event);

    /**
     * 弹出系统拍照发图的事件推送
     * @param event
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID）
     * CreateTime	消息创建时间 （整型）
     * MsgType	消息类型，event
     * Event	事件类型，pic_sysphoto
     * EventKey	事件KEY值，由开发者在创建菜单时设定
     * SendPicsInfo	发送的图片信息
     * Count	发送的图片数量
     * PicList	图片列表
     * PicMd5Sum	图片的MD5值，开发者若需要，可用于验证接收到图片
     * @return
     */
    ReplyMessage handlerPicSysPhoto(PicSysPhotoEvent event);

    /**
     * 弹出拍照或者相册发图的事件推送
     * @param event
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID）
     * CreateTime	消息创建时间 （整型）
     * MsgType	消息类型，event
     * Event	事件类型，pic_photo_or_album
     * EventKey	事件KEY值，由开发者在创建菜单时设定
     * SendPicsInfo	发送的图片信息
     * Count	发送的图片数量
     * PicList	图片列表
     * PicMd5Sum	图片的MD5值，开发者若需要，可用于验证接收到图片
     * @return
     */
    ReplyMessage handlerPicPhotoOrAlbum(PicPhotoOrAlbumEvent event);

    /**
     * 弹出微信相册发图器的事件推送
     * @param event
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID）
     * CreateTime	消息创建时间 （整型）
     * MsgType	消息类型，event
     * Event	事件类型，pic_weixin
     * EventKey	事件KEY值，由开发者在创建菜单时设定
     * SendPicsInfo	发送的图片信息
     * Count	发送的图片数量
     * PicList	图片列表
     * PicMd5Sum	图片的MD5值，开发者若需要，可用于验证接收到图片
     * @return
     */
    ReplyMessage handlerPicWeiXin(PicWeiXinEvent event);

    /**
     * 弹出地理位置选择器的事件推送
     * @param event
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID）
     * CreateTime	消息创建时间 （整型）
     * MsgType	消息类型，event
     * Event	事件类型，location_select
     * EventKey	事件KEY值，由开发者在创建菜单时设定
     * SendLocationInfo	发送的位置信息
     * Location_X	X坐标信息
     * Location_Y	Y坐标信息
     * Scale	精度，可理解为精度或者比例尺、越精细的话 scale越高
     * Label	地理位置的字符串信息
     * Poiname	朋友圈POI的名字，可能为空
     * @return
     */
    ReplyMessage handlerLocationSelect(LocationSelectEvent event);

    /**
     * 资质认证成功
     * @param event
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID，此时发送方是系统帐号）
     * CreateTime	消息创建时间 （整型），时间戳
     * MsgType	消息类型，event
     * Event	事件类型 qualification_verify_success
     * ExpiredTime	有效期 (整形)，指的是时间戳，将于该时间戳认证过期
     * @return
     */
    ReplyMessage handlerQualificationVerifySuccess(QualificationVerifySuccessEvent event);

    /**
     * 资质认证失败
     * @param event
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID，此时发送方是系统帐号）
     * CreateTime	消息创建时间 （整型），时间戳
     * MsgType	消息类型，event
     * Event	事件类型 qualification_verify_fail
     * FailTime	失败发生时间 (整形)，时间戳
     * FailReason	认证失败的原因
     * @return
     */
    ReplyMessage handlerQualificationVerifyFail(QualificationVerifyFailEvent event);

    /**
     * 名称认证成功
     * @param event
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID，此时发送方是系统帐号）
     * CreateTime	消息创建时间 （整型），时间戳
     * MsgType	消息类型，event
     * Event	事件类型 naming_verify_success
     * ExpiredTime	有效期 (整形)，指的是时间戳，将于该时间戳认证过期
     * @return
     */
    ReplyMessage handlerNamingVerifySuccess(NamingVerifySuccessEvent event);

    /**
     * 名称认证失败
     * @param event
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID，此时发送方是系统帐号）
     * CreateTime	消息创建时间 （整型），时间戳
     * MsgType	消息类型，event
     * Event	事件类型 naming_verify_fail
     * FailTime	失败发生时间 (整形)，时间戳
     * FailReason	认证失败的原因
     * @return
     */
    ReplyMessage handlerNamingVerifyFail(NamingVerifyFailEvent event);

    /**
     * 年审通知
     * @param event
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID，此时发送方是系统帐号）
     * CreateTime	消息创建时间 （整型），时间戳
     * MsgType	消息类型，event
     * Event	事件类型 annual_renew
     * ExpiredTime	有效期 (整形)，指的是时间戳，将于该时间戳认证过期
     * @return
     */
    ReplyMessage handlerAnnualRenew(AnnualRenewEvent event);

    /**
     * 认证过期失效通知
     * @param event
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID，此时发送方是系统帐号）
     * CreateTime	消息创建时间 （整型），时间戳
     * MsgType	消息类型，event
     * Event	事件类型 verify_expired
     * ExpiredTime	有效期 (整形)，指的是时间戳，将于该时间戳认证过期
     * @return
     */
    ReplyMessage handlerVerifyExpired(VerifyExpiredEvent event);

}
