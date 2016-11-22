package com.hxl.wx.service.impl;

import com.hxl.wx.entity.WXInfo;
import com.hxl.wx.service.AccessTokenService;
import com.hxl.wx.service.HttpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hxl on 2016/11/21.
 */
@Service
public class AccessTokenServiceImpl implements AccessTokenService {

    private static String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
    @Autowired
    private HttpsService httpsService;

    public void setAccessToken() {
        String accessToken = httpsService.get(String.format(url, WXInfo.APP_ID, WXInfo.APP_SECRET));
        WXInfo.ACCESS_TOKEN = accessToken;
        System.out.println("set accessToken : " + accessToken);
    }

}
