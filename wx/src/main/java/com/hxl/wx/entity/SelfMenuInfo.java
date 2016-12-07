package com.hxl.wx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by hxl on 2016/12/7.
 */
public class SelfMenuInfo {

    //菜单是否开启，0代表未开启，1代表开启
    @JsonProperty("is_menu_open")
    private Integer isMenuOpen;

    @JsonProperty("selfmenu_info")
    private Menu selfMenuInfo;

    public Integer getIsMenuOpen() {
        return isMenuOpen;
    }

    public void setIsMenuOpen(Integer isMenuOpen) {
        this.isMenuOpen = isMenuOpen;
    }

    public Menu getSelfMenuInfo() {
        return selfMenuInfo;
    }

    public void setSelfMenuInfo(Menu selfMenuInfo) {
        this.selfMenuInfo = selfMenuInfo;
    }

}
