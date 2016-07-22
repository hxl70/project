package com.hxl.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hxl on 2016/5/17.
 */
@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index");
        registry.addViewController("/hello");
        registry.addViewController("/login");

    }

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {

            private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            @Override
            public String getAsText() {
                return dateFormat.format(getValue());
            }

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                try {
                    setValue(dateFormat.parse(text));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
