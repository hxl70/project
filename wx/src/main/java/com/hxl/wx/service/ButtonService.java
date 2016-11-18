package com.hxl.wx.service;

import com.hxl.wx.entity.WXInfo;
import com.hxl.wx.utils.JsonUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hxl on 2016/11/18.
 */
public class ButtonService {

    private String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s";

    public void setButtons() {

        Map<String, List<Map<String, String>>> map = new HashMap<>();
        Map<String, String> buttons = new HashMap<>();
        buttons.put("name", "发送位置");
        buttons.put("type", "location_select");
        buttons.put("key", "rselfmenu_2_0");
        map.put("button", Arrays.asList(buttons));
        String content = JsonUtils.object2String(map);

        String result = HttpsService.post(String.format(url, WXInfo.ACCESS_TOKEN), content);
        System.out.println(result);
    }

    public static void main(String[] args) {
        ButtonService service = new ButtonService();
        service.setButtons();
    }

}
