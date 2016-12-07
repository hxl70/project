package com.hxl.wx.handler;

import com.hxl.wx.entity.event.*;
import com.hxl.wx.entity.message.*;
import com.hxl.wx.entity.reply.ReplyMessage;

/**
 * Created by hxl on 2016/12/7.
 */
public interface Handler {

    ReplyMessage handler(TextMessage message);
    ReplyMessage handler(ImageMessage message);
    ReplyMessage handler(VoiceMessage message);
    ReplyMessage handler(VideoMessage message);
    ReplyMessage handler(ShortVideoMessage message);
    ReplyMessage handler(LocationMessage message);
    ReplyMessage handler(LinkMessage message);
    ReplyMessage handler(AnnualRenewEvent event);
    ReplyMessage handler(ClickEvent event);
    ReplyMessage handler(LocationSelectEvent event);
    ReplyMessage handler(NamingVerifyFailEvent event);
    ReplyMessage handler(NamingVerifySuccessEvent event);
    ReplyMessage handler(PicPhotoOrAlbumEvent event);
    ReplyMessage handler(PicSysPhotoEvent event);
    ReplyMessage handler(PicWeiXinEvent event);
    ReplyMessage handler(QualificationVerifyFailEvent event);
    ReplyMessage handler(QualificationVerifySuccessEvent event);
    ReplyMessage handler(ScanCodePushEvent event);
    ReplyMessage handler(ScanCodeWaitMsgEvent event);
    ReplyMessage handler(ScanEvent event);
    ReplyMessage handler(SubscribeEvent event);
    ReplyMessage handler(UnSubscribeEvent event);
    ReplyMessage handler(VerifyExpiredEvent event);
    ReplyMessage handler(ViewEvent event);

}
