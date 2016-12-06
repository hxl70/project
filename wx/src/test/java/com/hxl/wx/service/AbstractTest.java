package com.hxl.wx.service;

import com.hxl.wx.Application;
import com.hxl.wx.entity.WXAccessToken;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hxl on 2016/11/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public abstract class AbstractTest {

    @Before
    public void setUp() throws Exception {
        while (WXAccessToken.ACCESS_TOKEN == null) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
