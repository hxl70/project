package com.hxl.wx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by hxl on 2016/11/22.
 */
public class IpList {

    @JsonProperty("ip_list")
    private List<String> ipList;

    public List<String> getIpList() {
        return ipList;
    }

    public void setIpList(List<String> ipList) {
        this.ipList = ipList;
    }

}
