package com.hxl.wx.service.impl;

import com.hxl.wx.entity.AccessToken;
import com.hxl.wx.entity.WXConfig;
import com.hxl.wx.service.AccessTokenService;
import com.hxl.wx.service.HttpsService;
import com.hxl.wx.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

/**
 * Created by hxl on 2016/11/21.
 */
@Service
@EnableConfigurationProperties(WXConfig.class)
public class AccessTokenServiceImpl implements AccessTokenService {

    private static String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
    @Autowired
    private HttpsService httpsService;
    @Autowired
    private WXConfig wxConfig;

    @Override
    public AccessToken get() {
        String accessToken = httpsService.get(String.format(url, wxConfig.getAppId(), wxConfig.getAppSecret()));
        return JsonUtils.toBean(accessToken, AccessToken.class);
    }

}
