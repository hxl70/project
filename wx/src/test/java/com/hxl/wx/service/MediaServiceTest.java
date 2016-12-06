package com.hxl.wx.service;

import com.hxl.wx.enumerate.UploadType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

/**
 * Created by hxl on 2016/12/6.
 */
public class MediaServiceTest extends AbstractTest {

    @Autowired
    private MediaService mediaService;

    @Test
    public void upload() throws Exception {
        mediaService.upload(UploadType.IMAGE, new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg"));
    }

    @Test
    public void download() throws Exception {
        //{"type":"image","media_id":"8d515iwrAc1Qfb_D_XyaX5ACPylihGLG0_S9CN_qLkFgDwjRsLFgF1JfWtQRdWGe","created_at":1480993241}
        mediaService.download("8d515iwrAc1Qfb_D_XyaX5ACPylihGLG0_S9CN_qLkFgDwjRsLFgF1JfWtQRdWGe", "F:/a.jpg");
    }

}