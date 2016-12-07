package com.hxl.wx.service;

import com.hxl.wx.entity.user.WXUser;
import com.hxl.wx.entity.user.WXUserList;
import com.hxl.wx.entity.user.WXUserListResult;
import com.hxl.wx.entity.user.WXUserOpenIdList;

/**
 * Created by hxl on 2016/12/7.
 */
public interface WXUserService {

    /**
     * 设置备注名
     * @param openId 用户标识
     * @param remark 新的备注名，长度必须小于30字符
     */
    void updateRemark(String openId, String remark);

    /**
     * 获取用户基本信息
     * @param openId 普通用户的标识，对当前公众号唯一
     * @param lang 返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
     * @return
     */
    WXUser get(String openId, String lang);

    /**
     * 批量获取用户基本信息
     * @param userList 用户的标识，对当前公众号唯一
     * @return 国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语，默认为zh-CN
     */
    WXUserListResult get(WXUserList userList);

    /**
     * 获取用户列表
     * @param openId 第一个拉取的OPENID，不填默认从头开始拉取
     * @return
     */
    WXUserOpenIdList get(String openId);

}
