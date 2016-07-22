package com.hxl;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

/**
 * Created by hxl on 2016/7/19.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        //display banner
        app.setBannerMode(Banner.Mode.OFF);
        ConfigurableApplicationContext context = app.run(Application.class, args);
        Arrays.asList(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
