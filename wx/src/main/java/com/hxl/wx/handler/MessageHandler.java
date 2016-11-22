package com.hxl.wx.handler;

import java.util.Map;

/**
 * Created by hxl on 2016/11/22.
 * 消息帮助接口
 */
public interface MessageHandler {

    /**
     * 文本消息处理
     * @param map
     * 参数           描述
     * ToUserName   开发者微信号
     * FromUserName 发送方帐号（一个OpenID）
     * CreateTime   消息创建时间 （整型）
     * MsgType  text
     * Content  文本消息内容
     * MsgId    消息id，64位整型
     * @return
     */
    String handlerText(Map<String, String> map);

    /**
     * 图片消息处理
     * @param map
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID）
     * CreateTime	消息创建时间 （整型）
     * MsgType	image
     * PicUrl	图片链接
     * MediaId	图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
     * MsgId	消息id，64位整型
     * @return
     */
    String handlerImage(Map<String, String> map);

    /**
     * 语音消息处理
     * @param map
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID）
     * CreateTime	消息创建时间 （整型）
     * MsgType	语音为voice
     * MediaId	语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
     * Format	语音格式，如amr，speex等
     * MsgID	消息id，64位整型
     * Recongnition 开通语音识别后，Recognition为语音识别结果
     * @return
     */
    String handlerVoice(Map<String, String> map);

    /**
     * 视频消息处理
     * @param map
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID）
     * CreateTime	消息创建时间 （整型）
     * MsgType	视频为video
     * MediaId	视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
     * ThumbMediaId	视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
     * MsgId	消息id，64位整型
     * @return
     */
    String handlerVideo(Map<String, String> map);

    /**
     * 小视频消息处理
     * @param map
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID）
     * CreateTime	消息创建时间 （整型）
     * MsgType	小视频为shortvideo
     * MediaId	视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
     * ThumbMediaId	视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
     * MsgId	消息id，64位整型
     * @return
     */
    String handlerShortVideo(Map<String, String> map);

    /**
     * 地理位置消息处理
     * @param map
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID）
     * CreateTime	消息创建时间 （整型）
     * MsgType	location
     * Location_X	地理位置维度
     * Location_Y	地理位置经度
     * Scale	地图缩放大小
     * Label	地理位置信息
     * MsgId	消息id，64位整型
     * @return
     */
    String handlerLocation(Map<String, String> map);

    /**
     * 链接消息处理
     * @param map
     * 参数	描述
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID）
     * CreateTime	消息创建时间 （整型）
     * MsgType	消息类型，link
     * Title	消息标题
     * Description	消息描述
     * Url	消息链接
     * MsgId	消息id，64位整型
     * @return
     */
    String handlerLink(Map<String, String> map);

}
