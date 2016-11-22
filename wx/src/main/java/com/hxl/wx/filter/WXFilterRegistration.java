package com.hxl.wx.filter;

import com.hxl.wx.entity.WXInfo;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
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
        urlPatterns.add(WXInfo.WX_URI);
        filterRegistrationBean.setUrlPatterns(urlPatterns);
        filterRegistrationBean.setName("wxIllegalFilter");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    /**
     * filter
     * @return
     */
    @Bean(name = "wxIllegalFilter")
    public Filter wxIllegalFilter() {
        return new WXFilter();
    }

}

