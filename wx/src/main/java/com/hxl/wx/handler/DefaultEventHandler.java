package com.hxl.wx.handler;

import com.hxl.wx.entity.event.*;
import com.hxl.wx.entity.reply.ReplyMessage;
import com.hxl.wx.entity.reply.ReplyTextMessage;
import com.hxl.wx.factory.ReturnMessageFactory;
import org.springframework.stereotype.Component;

/**
 * Created by hxl on 2016/11/22.
 */
@Component
public class DefaultEventHandler implements EventHandler {

    public ReplyMessage handlerSubscribe(SubscribeEvent event) {
        ReplyTextMessage replyTextMessage = ReturnMessageFactory.buildReturnMessage(new ReplyTextMessage(), event);
        replyTextMessage.setContent("关注");
        return replyTextMessage;
    }

    public ReplyMessage handlerUnSubscribe(UnSubscribeEvent event) {
        ReplyTextMessage replyTextMessage = ReturnMessageFactory.buildReturnMessage(new ReplyTextMessage(), event);
        replyTextMessage.setContent("取消关注");
        return replyTextMessage;
    }

    public ReplyMessage handlerScan(ScanEvent event) {
        ReplyTextMessage replyTextMessage = ReturnMessageFactory.buildReturnMessage(new ReplyTextMessage(), event);
        replyTextMessage.setContent("已关注");
        return replyTextMessage;
    }

    public ReplyMessage handlerLocation(LocationEvent event) {
        ReplyTextMessage replyTextMessage = ReturnMessageFactory.buildReturnMessage(new ReplyTextMessage(), event);
        replyTextMessage.setContent("上报地理位置");
        return replyTextMessage;
    }

    @Override
    public ReplyMessage handlerClick(ClickEvent event) {
        ReplyTextMessage replyTextMessage = ReturnMessageFactory.buildReturnMessage(new ReplyTextMessage(), event);
        replyTextMessage.setContent("点击事件");
        return replyTextMessage;
    }

    @Override
    public ReplyMessage handlerView(ViewEvent event) {
        ReplyTextMessage replyTextMessage = ReturnMessageFactory.buildReturnMessage(new ReplyTextMessage(), event);
        replyTextMessage.setContent("查看事件");
        return replyTextMessage;
    }

    @Override
    public ReplyMessage handlerScanCodePush(ScanCodePushEvent event) {
        ReplyTextMessage replyTextMessage = ReturnMessageFactory.buildReturnMessage(new ReplyTextMessage(), event);
        replyTextMessage.setContent("扫码事件");
        return replyTextMessage;
    }

    @Override
    public ReplyMessage handlerScanCodeWaitMsg(ScanCodeWaitMsgEvent event) {
        ReplyTextMessage replyTextMessage = ReturnMessageFactory.buildReturnMessage(new ReplyTextMessage(), event);
        replyTextMessage.setContent("扫码且等待消息事件");
        return replyTextMessage;
    }

    @Override
    public ReplyMessage handlerPicSysPhoto(PicSysPhotoEvent event) {
        ReplyTextMessage replyTextMessage = ReturnMessageFactory.buildReturnMessage(new ReplyTextMessage(), event);
        replyTextMessage.setContent("系统拍照事件");
        return replyTextMessage;
    }

    @Override
    public ReplyMessage handlerPicPhotoOrAlbum(PicPhotoOrAlbumEvent event) {
        ReplyTextMessage replyTextMessage = ReturnMessageFactory.buildReturnMessage(new ReplyTextMessage(), event);
        replyTextMessage.setContent("拍照事件");
        return replyTextMessage;
    }

    @Override
    public ReplyMessage handlerPicWeiXin(PicWeiXinEvent event) {
        ReplyTextMessage replyTextMessage = ReturnMessageFactory.buildReturnMessage(new ReplyTextMessage(), event);
        replyTextMessage.setContent("微信拍照事件");
        return replyTextMessage;
    }

    @Override
    public ReplyMessage handlerLocationSelect(LocationSelectEvent event) {
        ReplyTextMessage replyTextMessage = ReturnMessageFactory.buildReturnMessage(new ReplyTextMessage(), event);
        replyTextMessage.setContent("选择地理位置事件");
        return replyTextMessage;
    }

    @Override
    public ReplyMessage handlerQualificationVerifySuccess(QualificationVerifySuccessEvent event) {
        return null;
    }

    @Override
    public ReplyMessage handlerQualificationVerifyFail(QualificationVerifyFailEvent event) {
        return null;
    }

    @Override
    public ReplyMessage handlerNamingVerifySuccess(NamingVerifySuccessEvent event) {
        return null;
    }

    @Override
    public ReplyMessage handlerNamingVerifyFail(NamingVerifyFailEvent event) {
        return null;
    }

    @Override
    public ReplyMessage handlerAnnualRenew(AnnualRenewEvent event) {
        return null;
    }

    @Override
    public ReplyMessage handlerVerifyExpired(VerifyExpiredEvent event) {
        return null;
    }

}
