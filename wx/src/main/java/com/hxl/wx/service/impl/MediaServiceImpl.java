package com.hxl.wx.service.impl;

import com.hxl.wx.entity.WXAccessToken;
import com.hxl.wx.entity.media.*;
import com.hxl.wx.entity.reply.Media;
import com.hxl.wx.enumerate.MediaType;
import com.hxl.wx.enumerate.UploadType;
import com.hxl.wx.service.HttpsService;
import com.hxl.wx.service.MediaService;
import com.hxl.wx.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hxl on 2016/12/6.
 */
@Service
public class MediaServiceImpl implements MediaService {

    @Autowired
    private HttpsService httpsService;
    private String uploadUrl = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=%s&type=%s";

    private String downloadUrl = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=%s&media_id=%s";

    private String countUrl = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=%s";

    private String batchGetUrl = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=%s";

    private String addMediaUrl = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=%s";

    private String uploadImageUrl = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=%s";

    private String uploadMediaUrl = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=%s";

    private String getUrl = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=%s";
    private String getRequestBody = "{\"media_id\": \"%s\"}";

    private String deleteUrl = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=%s";
    private String deleteRequestBody = "{\"media_id\": \"%s\"}";

    private String updateUrl = "https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=%s";

    @Override
    public String upload(UploadType type, File file) {
        Map<String, File> fileMap = new HashMap<>();
        fileMap.put("media", file);
        return httpsService.upload(String.format(uploadUrl, WXAccessToken.ACCESS_TOKEN, type.getName()), fileMap, null);
    }

    @Override
    public void download(String mediaId, String filePath) {
        httpsService.download(String.format(downloadUrl, WXAccessToken.ACCESS_TOKEN, mediaId), filePath);
    }

    @Override
    public String upload(Media media) {
        return httpsService.post(String.format(addMediaUrl, WXAccessToken.ACCESS_TOKEN), JsonUtils.toString(media));
    }

    @Override
    public String uploadImage(File file) {
        Map<String, File> fileMap = new HashMap<>();
        fileMap.put("media", file);
        String result = httpsService.upload(String.format(uploadImageUrl, WXAccessToken.ACCESS_TOKEN), fileMap, null);
        return JsonUtils.toBean(result, HashMap.class).get("media_id").toString();
    }

    @Override
    public MediaResult upload(UploadType type, File file, String title, String introduction) {
        Map<String, String> description = null;
        if (title != null && introduction != null) {
            description = new HashMap<>();
            description.put("title", title);
            description.put("introduction", introduction);
        }

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("type", type.getName());
        paramMap.put("description", JsonUtils.toString(description));

        Map<String, File> fileMap = new HashMap<>();
        fileMap.put("media", file);

        httpsService.upload(String.format(uploadMediaUrl, WXAccessToken.ACCESS_TOKEN), fileMap, paramMap);
        return null;
    }

    @Override
    public MediaList getNews(String mediaId) {
        String result = httpsService.post(String.format(getUrl, WXAccessToken.ACCESS_TOKEN), String.format(getRequestBody, mediaId));
        return JsonUtils.toBean(result, MediaList.class);
    }

    @Override
    public MediaVideoResult getVideo(String mediaId) {
        String result = httpsService.post(String.format(getUrl, WXAccessToken.ACCESS_TOKEN), String.format(getRequestBody, mediaId));
        return JsonUtils.toBean(result, MediaVideoResult.class);
    }

    @Override
    public void get(String mediaId, String filePath) {
        httpsService.download(String.format(getUrl, WXAccessToken.ACCESS_TOKEN), filePath);
    }

    @Override
    public void delete(String mediaId) {
        httpsService.post(String.format(deleteUrl, WXAccessToken.ACCESS_TOKEN), String.format(deleteRequestBody, mediaId));
    }

    @Override
    public void update(MediaUpdate mediaUpdate) {
        httpsService.post(String.format(updateUrl, WXAccessToken.ACCESS_TOKEN), JsonUtils.toString(mediaUpdate));
    }

    @Override
    public MediaCount count() {
        String result = httpsService.get(String.format(countUrl, WXAccessToken.ACCESS_TOKEN));
        return JsonUtils.toBean(result, MediaCount.class);
    }

    @Override
    public MediaList batchGet(MediaType type, int offset, int count) {
        String result = httpsService.get(String.format(batchGetUrl, WXAccessToken.ACCESS_TOKEN));
        return JsonUtils.toBean(result, MediaList.class);
    }
}
