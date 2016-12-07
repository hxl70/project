package com.hxl.wx.service.impl;

import com.hxl.wx.entity.IpList;
import com.hxl.wx.entity.WXAccessToken;
import com.hxl.wx.service.HttpsService;
import com.hxl.wx.service.WXServerIpService;
import com.hxl.wx.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hxl on 2016/11/21.
 */
@Service
public class WXServerIpServiceImpl implements WXServerIpService {

    //GET
    private String url = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=%s";
    @Autowired
    private HttpsService httpsService;

    public IpList get() {
        String result = httpsService.get(String.format(url, WXAccessToken.ACCESS_TOKEN));
        IpList ipList = JsonUtils.toBean(result, IpList.class);
        return ipList;
    }

}
