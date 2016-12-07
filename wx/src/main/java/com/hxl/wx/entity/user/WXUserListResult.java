package com.hxl.wx.entity.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxl on 2016/12/7.
 */
public class WXUserListResult {

    @JsonProperty("user_info_list")
    private List<WXUser> users = new ArrayList<>();

    public List<WXUser> getUsers() {
        return users;
    }

    public void setUsers(List<WXUser> users) {
        this.users = users;
    }
}
