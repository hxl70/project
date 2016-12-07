package com.hxl.wx.service.impl;

import com.hxl.wx.entity.WXAccessToken;
import com.hxl.wx.entity.user.WXUser;
import com.hxl.wx.entity.user.WXUserList;
import com.hxl.wx.entity.user.WXUserListResult;
import com.hxl.wx.entity.user.WXUserOpenIdList;
import com.hxl.wx.service.HttpsService;
import com.hxl.wx.service.WXUserService;
import com.hxl.wx.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hxl on 2016/12/7.
 */
@Service
public class WXUserServiceImpl implements WXUserService {

    @Autowired
    private HttpsService httpsService;

    private String updateRemarkUrl = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=%s";

    private String userInfoUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=%s";

    private String batchGetUrl = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=%s";

    private String getUrl = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=%s&next_openid=%s";

    @Override
    public void updateRemark(String openId, String remark) {
        Map<String, String> map = new HashMap<>();
        map.put("openid", openId);
        map.put("remark", remark);
        httpsService.post(String.format(updateRemarkUrl, WXAccessToken.ACCESS_TOKEN), JsonUtils.toString(map));
    }

    @Override
    public WXUser get(String openId, String lang) {
        if (lang == null) {
            lang = "zh_CN";
        }
        String result = httpsService.get(String.format(userInfoUrl, WXAccessToken.ACCESS_TOKEN, openId, lang));
        return JsonUtils.toBean(result, WXUser.class);
    }

    @Override
    public WXUserListResult get(WXUserList userList) {
        String result = httpsService.post(String.format(batchGetUrl, WXAccessToken.ACCESS_TOKEN), JsonUtils.toString(userList));
        return JsonUtils.toBean(result, WXUserListResult.class);
    }

    @Override
    public WXUserOpenIdList get(String openId) {
        if (openId == null) {
            openId = "";
        }
        String result = httpsService.get(String.format(getUrl, WXAccessToken.ACCESS_TOKEN, openId));
        return JsonUtils.toBean(result, WXUserOpenIdList.class);
    }

}
