package com.hxl.wx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxl on 2016/11/22.
 * 菜单
 */
public class Menu {

    /**
     * 一级菜单数组，个数应为1~3个
     */
    @JsonProperty("button")
    private List<Button> buttons = new ArrayList<>(3);

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }
}
