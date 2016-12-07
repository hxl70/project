package com.hxl.wx.entity.user;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxl on 2016/12/5.
 */
public class GroupListResult {

    private List<Group> groups = new ArrayList<>();

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
