package com.hxl.wx.service;

import com.hxl.wx.entity.IndustryResult;
import com.hxl.wx.enumerate.Industry;

/**
 * Created by hxl on 2016/12/7.
 */
public interface TemplateService {

    /**
     * 设置所属行业
     * @param primary 主营行业
     * @param secondary 副营行业
     */
    void setIndustry(Industry primary, Industry secondary);

    /**
     * 获取设置的行业信息
     * @return
     */
    IndustryResult getIndustry();

    String getTemplateId(String templateIdShort);

}
