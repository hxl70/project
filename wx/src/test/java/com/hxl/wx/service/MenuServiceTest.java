package com.hxl.wx.service;

import com.hxl.wx.entity.Button;
import com.hxl.wx.entity.Menu;
import com.hxl.wx.enumerate.ButtonType;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hxl on 2016/11/22.
 */
public class MenuServiceTest extends AbstractTest {

    @Autowired
    private MenuService menuService;

    @Test
    public void testSetMenu() {
        Menu menu = new Menu();
        Button button = new Button();
        button.setName("扫码带提示");
        button.setType(ButtonType.scancode_waitmsg);
        button.setKey("rselfmenu_0_0");
        menu.getButtons().add(button);
        menuService.create(menu);
    }

    @Test
    public void testGet() {
        Menu menu = menuService.get();
        Assert.assertNotNull(menu);
    }

    @Test
    public void testDelete() {
        menuService.delete();
    }
}
