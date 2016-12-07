package com.hxl.wx.service.impl;

import com.hxl.wx.entity.*;
import com.hxl.wx.service.HttpsService;
import com.hxl.wx.service.MenuService;
import com.hxl.wx.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hxl on 2016/11/21.
 * 菜单操作
 */
@Service
public class MenuServiceImpl implements MenuService {

    //POST
    private String createUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s";
    //GET
    private String getUrl = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=%s";
    //GET
    private String deleteUrl = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=%s";
    @Autowired
    private HttpsService httpsService;

    private String createConditionalUrl = "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=%s";

    private String deleteConditionalUrl = "https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=%s";
    private String deleteConditionalParam = "{\"menuid\":\"%s\"}";

    private String tryMatchUrl = "https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token=%s";
    private String tryMatchParam = "{\"user_id\":\"%s\"}";

    private String selfMenuUrl = "https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=%s";

    @Override
    public void create(Menu menu) {
        String menuJson = JsonUtils.toString(menu);
        httpsService.post(String.format(createUrl, WXAccessToken.ACCESS_TOKEN), menuJson);
    }

    @Override
    public Menu get() {
        String result = httpsService.get(String.format(getUrl, WXAccessToken.ACCESS_TOKEN));
        MenuResult menuResult = JsonUtils.toBean(result, MenuResult.class);
        return menuResult == null ? null : menuResult.getMenu();
    }

    @Override
    public void delete() {
        httpsService.get(String.format(deleteUrl, WXAccessToken.ACCESS_TOKEN));
    }

    @Override
    public void createConditional(ConditionalMenu menu) {
        httpsService.post(String.format(createConditionalUrl, WXAccessToken.ACCESS_TOKEN), JsonUtils.toString(menu));
    }

    @Override
    public void deleteConditional(String menuId) {
        httpsService.post(String.format(deleteConditionalUrl, WXAccessToken.ACCESS_TOKEN), String.format(deleteConditionalParam, menuId));
    }

    @Override
    public Menu tryMatch(String userId) {
        String result = httpsService.post(String.format(tryMatchUrl, WXAccessToken.ACCESS_TOKEN), String.format(tryMatchParam, userId));
        return JsonUtils.toBean(result, Menu.class);
    }

    @Override
    public SelfMenuInfo selfMenu() {
        String result = httpsService.get(String.format(selfMenuUrl, WXAccessToken.ACCESS_TOKEN));
        return JsonUtils.toBean(result, SelfMenuInfo.class);
    }
}
