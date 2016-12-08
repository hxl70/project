package com.hxl.wx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by hxl on 2016/12/7.
 */
public class IndustryResult {

    //帐号设置的主营行业
    @JsonProperty("primary_industry")
    private Industry primaryIndustry;
    //	帐号设置的副营行业
    @JsonProperty("secondary_industry")
    private Industry secondaryIndustry;

    public Industry getPrimaryIndustry() {
        return primaryIndustry;
    }

    public void setPrimaryIndustry(Industry primaryIndustry) {
        this.primaryIndustry = primaryIndustry;
    }

    public Industry getSecondaryIndustry() {
        return secondaryIndustry;
    }

    public void setSecondaryIndustry(Industry secondaryIndustry) {
        this.secondaryIndustry = secondaryIndustry;
    }
}
