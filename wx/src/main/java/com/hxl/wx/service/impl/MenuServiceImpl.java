package com.hxl.wx.service.impl;

import com.hxl.wx.entity.Menu;
import com.hxl.wx.entity.MenuResult;
import com.hxl.wx.entity.WXConfig;
import com.hxl.wx.service.MenuService;
import com.hxl.wx.service.HttpsService;
import com.hxl.wx.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private Logger logger = LoggerFactory.getLogger(MenuService.class);

    @Override
    public void set(Menu menu) {
        String menuJson = JsonUtils.toString(menu);
        String result = httpsService.post(String.format(createUrl, WXConfig.ACCESS_TOKEN), menuJson);
        logger.info("create menu {}: {}", menuJson, result);
    }

    @Override
    public Menu get() {
        String result = httpsService.get(String.format(getUrl, WXConfig.ACCESS_TOKEN));
        logger.info("get menu: {}", result);
        MenuResult menuResult = JsonUtils.toBean(result, MenuResult.class);
        return menuResult == null ? null : menuResult.getMenu();
    }

    @Override
    public void delete() {
        String result = httpsService.get(String.format(deleteUrl, WXConfig.ACCESS_TOKEN));
        logger.info("delete menu : {}", result);
    }
}
