package com.hxl.wx.task;

import com.hxl.wx.entity.AccessToken;
import com.hxl.wx.entity.WXConfig;
import com.hxl.wx.service.AccessTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by hxl on 2016/12/1.
 * 微信获取AccessToken任务,每7000s获取一次
 */
@Component
public class AccessTokenTask extends Thread implements InitializingBean {

    private Long ms = 7000000L;
    private Logger logger = LoggerFactory.getLogger(AccessTokenTask.class);
    @Autowired
    private AccessTokenService accessTokenService;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                AccessToken accessToken = accessTokenService.get();
                WXConfig.ACCESS_TOKEN = accessToken.getAccessToken();
                logger.info("set AccessToken: {}", WXConfig.ACCESS_TOKEN);
                Thread.sleep(ms);
            } catch (Exception e) {
                logger.error("set AccessToken Error: {}", e);
                try {
                    //获取出错,3s后继续获取
                    Thread.sleep(3000L);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

}
