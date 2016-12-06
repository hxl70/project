package com.hxl.wx.service.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hxl.wx.entity.WXAccessToken;
import com.hxl.wx.service.HttpsService;
import com.hxl.wx.service.ShortUrlService;
import com.hxl.wx.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by hxl on 2016/12/6.
 */
@Service
public class ShortUrlServiceImpl implements ShortUrlService {

    private String shortUrl = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=%s";

    @Autowired
    private HttpsService httpsService;

    @Override
    public String shortUrl(String longUrl) {
        String result = httpsService.post(String.format(shortUrl, WXAccessToken.ACCESS_TOKEN), JsonUtils.toString(new ShortUrl(longUrl)));
        return (String)JsonUtils.toBean(result, HashMap.class).get("short_url");
    }

    private static class ShortUrl {
        private String action = "long2short";
        @JsonProperty("long_url")
        private String longUrl;

        public ShortUrl(String longUrl) {
            this.longUrl = longUrl;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getLongUrl() {
            return longUrl;
        }

        public void setLongUrl(String longUrl) {
            this.longUrl = longUrl;
        }
    }
}
