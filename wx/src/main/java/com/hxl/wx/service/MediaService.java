package com.hxl.wx.service;

import com.hxl.wx.entity.media.*;
import com.hxl.wx.entity.reply.Media;
import com.hxl.wx.enumerate.MediaType;
import com.hxl.wx.enumerate.UploadType;

import java.io.File;

/**
 * Created by hxl on 2016/12/1.
 */
public interface MediaService {

    /**
     * 上传的临时多媒体文件
     * 媒体文件在后台保存时间为3天，即3天后media_id失效。
     * @param type 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
     * @param file 上传的文件
     * @return
     */
    String upload(UploadType type, File file);

    /**
     * 获取临时素材
     * 视频文件不支持https下载，调用该接口需http协议
     * @param mediaId 媒体文件ID
     * @param filePath 存储路径
     */
    void download(String mediaId, String filePath);

    /**
     * 新增永久图文素材
     * 参数	是否必须	说明
     * title	是	标题
     * thumb_media_id	是	图文消息的封面图片素材id（必须是永久mediaID）
     * author	是	作者
     * digest	是	图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
     * show_cover_pic	是	是否显示封面，0为false，即不显示，1为true，即显示
     * content	是	图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
     * content_source_url	是	图文消息的原文地址，即点击“阅读原文”后的URL
     * @return 新增的图文消息素材的media_id
     */
    String upload(Media media);

    /**
     * 上传图文消息内的图片获取URL
     * 请注意，本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。
     * 图片仅支持jpg/png格式，大小必须在1MB以下
     * @param file 图片
     * @return 上传图片的URL
     */
    String uploadImage(File file);

    /**
     * 新增其他类型永久素材
     * @param type 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
     * @param file 上传的文件
     * @param title 视频素材的标题
     * @param introduction 视频素材的描述
     * @return
     */
    MediaResult upload(UploadType type, File file, String title, String introduction);

    /**
     * 获取永久素材 图文消息
     * @param mediaId 素材的media_id
     * @return
     */
    MediaList getNews(String mediaId);

    /**
     * 获取永久素材 视频消息素材
     * @param mediaId 素材的media_id
     * @return
     */
    MediaVideoResult getVideo(String mediaId);

    /**
     * 获取永久素材 其他类型的素材消息，则响应的直接为素材的内容
     * @param mediaId 素材的media_id
     * @param filePath 存储路径
     */
    void get(String mediaId, String filePath);

    /**
     * 删除永久素材
     * @param mediaId 素材的media_id
     */
    void delete(String mediaId);

    /**
     * 修改永久图文素材
     * @param mediaUpdate
     */
    void update(MediaUpdate mediaUpdate);

    /**
     * 永久素材的总数
     * 图片和图文消息素材（包括单图文和多图文）的总数上限为5000，其他素材的总数上限为1000
     * @return
     */
    MediaCount count();

    /**
     * 在新增了永久素材后，开发者可以分类型获取永久素材的列表。
     * @param type 素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
     * @param offset 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
     * @param count 返回素材的数量，取值在1到20之间
     * @return
     */
    MediaList batchGet(MediaType type, int offset, int count);

}
