package com.hxl.wx.service.impl;

import com.hxl.wx.entity.WXInfo;
import com.hxl.wx.service.HttpsService;
import com.hxl.wx.service.WXServerIpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hxl on 2016/11/21.
 */
@Service
public class WXServerIpServiceImpl implements WXServerIpService {

    private String url = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=%s";
    @Autowired
    private HttpsService httpsService;

    public String getIpList() {
        String ipList = httpsService.get(String.format(url, WXInfo.ACCESS_TOKEN));
        return ipList;
    }

}
