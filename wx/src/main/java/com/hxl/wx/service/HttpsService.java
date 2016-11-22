package com.hxl.wx.service;

/**
 * Created by hxl on 2016/11/18.
 * HTTPS 请求服务
 */
public interface HttpsService {

    String get(String url);

    String post(String url, String requestBody);

}
