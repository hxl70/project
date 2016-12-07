package com.hxl.wx.service;

import java.io.File;
import java.util.Map;

/**
 * Created by hxl on 2016/11/18.
 * HTTPS 请求服务
 */
public interface HttpsService {

    String get(String url);

    String post(String url, String requestBody);

    String upload(String url, Map<String, File> files, Map<String, String> param);

    void download(String url, String filePath);

}
