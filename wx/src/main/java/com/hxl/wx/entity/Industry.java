package com.hxl.wx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by hxl on 2016/12/7.
 */
public class Industry {

    //帐号设置的主营行业
    @JsonProperty("first_class")
    private String firstClass;
    //	帐号设置的副营行业
    @JsonProperty("second_class")
    private String secondClass;

    public String getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(String firstClass) {
        this.firstClass = firstClass;
    }

    public String getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(String secondClass) {
        this.secondClass = secondClass;
    }

}
