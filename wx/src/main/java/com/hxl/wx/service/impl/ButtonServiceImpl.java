package com.hxl.wx.service.impl;

import com.hxl.wx.entity.WXInfo;
import com.hxl.wx.service.ButtonService;
import com.hxl.wx.service.HttpsService;
import com.hxl.wx.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hxl on 2016/11/21.
 */
@Service
public class ButtonServiceImpl implements ButtonService {

    private String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s";
    @Autowired
    private HttpsService httpsService;

    public void setButtons(String s) {
        Map<String, List<Map<String, String>>> map = new HashMap<>();
        Map<String, String> buttons = new HashMap<>();
        buttons.put("name", "发送位置");
        buttons.put("type", "location_select");
        buttons.put("key", "rselfmenu_2_0");
        map.put("button", Arrays.asList(buttons));
        String content = JsonUtils.toString(map);

        String result = httpsService.post(String.format(url, WXInfo.ACCESS_TOKEN), content);
        System.out.println(result);
    }

}
