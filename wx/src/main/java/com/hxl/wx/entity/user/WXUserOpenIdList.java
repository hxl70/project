package com.hxl.wx.entity.user;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by hxl on 2016/12/7.
 */
public class WXUserOpenIdList {

    //关注该公众账号的总用户数
    private Integer total;
    //拉取的OPENID个数，最大值为10000
    private Integer count;
    //拉取列表的最后一个用户的OPENID
    @JsonProperty("next_openid")
    private String nextOpenId;

    @JsonProperty("data")
    private WXUserOpenId data;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNextOpenId() {
        return nextOpenId;
    }

    public void setNextOpenId(String nextOpenId) {
        this.nextOpenId = nextOpenId;
    }

    public WXUserOpenId getData() {
        return data;
    }

    public void setData(WXUserOpenId data) {
        this.data = data;
    }
}
