package com.hxl.wx.entity.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxl on 2016/12/7.
 */
public class WXUserOpenId {

    @JsonProperty("openid")
    private List<String> openIds = new ArrayList<>();

    public List<String> getOpenIds() {
        return openIds;
    }

    public void setOpenIds(List<String> openIds) {
        this.openIds = openIds;
    }
}
