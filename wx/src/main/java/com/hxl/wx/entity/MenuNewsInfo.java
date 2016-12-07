package com.hxl.wx.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxl on 2016/12/7.
 * 图文消息的信息
 */
public class MenuNewsInfo {
    private List<MenuNewsInfoItem> list = new ArrayList<>();

    public List<MenuNewsInfoItem> getList() {
        return list;
    }

    public void setList(List<MenuNewsInfoItem> list) {
        this.list = list;
    }
}
