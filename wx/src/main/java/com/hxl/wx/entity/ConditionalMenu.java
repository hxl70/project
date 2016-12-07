package com.hxl.wx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by hxl on 2016/12/7.
 */
public class ConditionalMenu extends Menu {

    /**
     * 	菜单匹配规则
     */
    @JsonProperty("matchrule")
    private MatchRule matchRule;

    public MatchRule getMatchRule() {
        return matchRule;
    }

    public void setMatchRule(MatchRule matchRule) {
        this.matchRule = matchRule;
    }

}
