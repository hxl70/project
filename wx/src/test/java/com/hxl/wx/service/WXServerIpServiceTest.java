package com.hxl.wx.service;

import com.hxl.wx.entity.IpList;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hxl on 2016/11/22.
 */
public class WXServerIpServiceTest extends AbstractTest {

    @Autowired
    private WXServerIpService ipService;

    @Test
    public void testGet() {
        IpList ipList = ipService.get();
        Assert.assertNotNull(ipList);
    }

}
