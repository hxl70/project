package com.hxl.wx.filter;

import com.hxl.wx.entity.WXConfig;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxl on 2016/11/22.
 * 注册微信Filter
 */
@Configuration
public class WXFilterRegistration {

    /**
     * filterRegistrationBean
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WXFilter());
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add(WXConfig.WX_URI);
        filterRegistrationBean.setUrlPatterns(urlPatterns);
        filterRegistrationBean.setName("wxIllegalFilter");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

}

