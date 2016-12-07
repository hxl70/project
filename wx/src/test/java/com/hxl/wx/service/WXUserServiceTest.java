package com.hxl.wx.service;

import com.hxl.wx.entity.user.WXUser;
import com.hxl.wx.entity.user.WXUserList;
import com.hxl.wx.entity.user.WXUserListResult;
import com.hxl.wx.entity.user.WXUserOpenIdList;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hxl on 2016/12/7.
 */
public class WXUserServiceTest extends AbstractTest {

    @Autowired
    private WXUserService userService;

    @Test
    public void updateRemark() throws Exception {
        userService.updateRemark("oV3WzwkYX3MlIJ3LRUpqerzdYuRQ", "Admin");
    }

    @Test
    public void get() throws Exception {
        WXUserOpenIdList wxUserOpenIdList = userService.get("");
        Assert.assertNotNull(wxUserOpenIdList);
    }

    @Test
    public void get1() throws Exception {
        String openId = "oV3WzwkYX3MlIJ3LRUpqerzdYuRQ";
        WXUser wxUser = userService.get(openId, null);
        Assert.assertNotNull(wxUser);
    }

    @Test
    public void get2() throws Exception {
        WXUserListResult result = userService.get(new WXUserList().addUser("oV3WzwkYX3MlIJ3LRUpqerzdYuRQ", ""));
        Assert.assertNotNull(result);
    }

}