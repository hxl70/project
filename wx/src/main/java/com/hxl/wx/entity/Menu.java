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
    /**
     * 	菜单匹配规则
     */
    @JsonProperty("matchrule")
    private MatchRule matchRule;

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    public MatchRule getMatchRule() {
        return matchRule;
    }

    public void setMatchRule(MatchRule matchRule) {
        this.matchRule = matchRule;
    }
}
