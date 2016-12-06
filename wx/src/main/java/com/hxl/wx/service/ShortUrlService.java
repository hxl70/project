package com.hxl.wx.service;

/**
 * Created by hxl on 2016/12/6.
 */
public interface ShortUrlService {

    /**
     * 将一条长链接转成短链接
     * @param longUrl
     * @return
     */
    String shortUrl(String longUrl);

}
