package com.hxl.wx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by hxl on 2016/12/6.
 */
public class Ticket {

    @JsonProperty("expire_seconds")
    private Integer expireSeconds;

    @JsonProperty("action_name")
    private String actionName;
    @JsonProperty("action_info")
    private TicketActionInfo actionInfo;

    public Integer getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(Integer expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public TicketActionInfo getActionInfo() {
        return actionInfo;
    }

    public void setActionInfo(TicketActionInfo actionInfo) {
        this.actionInfo = actionInfo;
    }
}
