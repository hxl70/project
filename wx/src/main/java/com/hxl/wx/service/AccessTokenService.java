package com.hxl.wx.service;

import com.hxl.wx.entity.WXInfo;

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
public class AccessTokenService {

    private static String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

    public void setAccessToken() {
        String accessToken = HttpsService.get(String.format(url, WXInfo.APP_ID, WXInfo.APP_SECRET));
        WXInfo.ACCESS_TOKEN = accessToken;
        System.out.println("set accessToken : " + accessToken);
    }


    public static void main(String[] args) {
        AccessTokenService service = new AccessTokenService();
        service.setAccessToken();
    }

}
