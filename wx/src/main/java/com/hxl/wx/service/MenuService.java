package com.hxl.wx.service;

import com.hxl.wx.entity.ConditionalMenu;
import com.hxl.wx.entity.Menu;
import com.hxl.wx.entity.SelfMenuInfo;

/**
 * Created by hxl on 2016/11/18.
 */
public interface MenuService {

    /**
     * 自定义菜单创建接口
     * @param menu
     */
    void create(Menu menu);

    /**
     * 自定义菜单查询接口
     * @return
     */
    Menu get();

    /**
     * 自定义菜单删除接口
     */
    void delete();

    /**
     * 创建个性化菜单
     * @param menu
     */
    void createConditional(ConditionalMenu menu);

    /**
     * 删除个性化菜单
     * @param menuId
     */
    void deleteConditional(String menuId);

    /**
     * 测试个性化菜单匹配结果
     * @param userId
     * @return
     */
    Menu tryMatch(String userId);

    SelfMenuInfo selfMenu();

}
