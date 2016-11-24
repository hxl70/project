package com.hxl.wx.service;

import com.hxl.wx.entity.AccessToken;

/**
 * Created by hxl on 2016/11/18.
 * access_token是公众号的全局唯一票据，
 * 公众号调用各接口时都需使用access_token。
 * 开发者需要进行妥善保存。
 * access_token的存储至少要保留512个字符空间。
 * access_token的有效期目前为2个小时，
 * 需定时刷新，
 * 重复获取将导致上次获取的access_token失效。
 * 公众平台会保证在access_token刷新后，
 * 旧的access_token在5分钟内仍能使用，
 * 以确保第三方在更新access_token时不会发生第三方调用微信api的失败。
 */
public interface AccessTokenService {

    AccessToken get();

}
