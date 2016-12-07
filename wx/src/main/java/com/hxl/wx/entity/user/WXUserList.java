package com.hxl.wx.entity.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxl on 2016/12/7.
 */
public class WXUserList {

    @JsonProperty("user_list")
    private List<WXUserListItem> userList = new ArrayList<>();

    public List<WXUserListItem> getUserList() {
        return userList;
    }

    public void setUserList(List<WXUserListItem> userList) {
        this.userList = userList;
    }

    public WXUserList addUser(String openId, String lang) {
        userList.add(new WXUserListItem(openId, lang));
        return this;
    }

}
