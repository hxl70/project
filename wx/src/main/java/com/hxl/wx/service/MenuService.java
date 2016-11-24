package com.hxl.wx.service;

import com.hxl.wx.entity.Menu;

/**
 * Created by hxl on 2016/11/18.
 */
public interface MenuService {

    void set(Menu menu);

    Menu get();

    void delete();

}
