package com.hxl.wx.service.impl;

import com.hxl.wx.entity.IndustryResult;
import com.hxl.wx.entity.WXAccessToken;
import com.hxl.wx.enumerate.Industry;
import com.hxl.wx.service.HttpsService;
import com.hxl.wx.service.TemplateService;
import com.hxl.wx.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by hxl on 2016/12/7.
 */
@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private HttpsService httpsService;

    private String setIndustryUrl = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=%s";
    private String setIndustryParam = "{\"industry_id1\":\"%s\",\"industry_id2\":\"%s\"}";

    private String getIndustryUrl = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=%s";

    private String getTemplateIdUrl = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=%s";
    private String getTemplateIdParam = "{\"template_id_short\":\"%s\"}";

    @Override
    public void setIndustry(Industry primary, Industry secondary) {
        httpsService.post(String.format(setIndustryUrl, WXAccessToken.ACCESS_TOKEN), String.format(setIndustryParam, primary.getCode(), secondary.getCode()));
    }

    @Override
    public IndustryResult getIndustry() {
        String result = httpsService.get(String.format(getIndustryUrl, WXAccessToken.ACCESS_TOKEN));
        return JsonUtils.toBean(result, IndustryResult.class);
    }

    @Override
    public String getTemplateId(String templateIdShort) {
        String result = httpsService.post(String.format(getTemplateIdUrl, WXAccessToken.ACCESS_TOKEN), String.format(getTemplateIdParam, templateIdShort));
        return (String)JsonUtils.toBean(result, HashMap.class).get("template_id");
    }
}
