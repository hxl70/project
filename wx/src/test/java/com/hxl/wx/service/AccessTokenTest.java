package com.hxl.wx.service;

import com.hxl.wx.entity.AccessToken;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * Created by hxl on 2016/11/22.
 */
public class AccessTokenTest extends AbstractTest {

    @Autowired
    private AccessTokenService accessTokenService;

    @Test
    public void testGet() {
        AccessToken accessToken = accessTokenService.get();
        Assert.notNull(accessToken);
    }

}
