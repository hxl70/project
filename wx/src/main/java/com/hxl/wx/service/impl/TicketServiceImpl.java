package com.hxl.wx.service.impl;

import com.hxl.wx.entity.Ticket;
import com.hxl.wx.entity.TicketResult;
import com.hxl.wx.entity.WXAccessToken;
import com.hxl.wx.service.HttpsService;
import com.hxl.wx.service.TicketService;
import com.hxl.wx.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hxl on 2016/12/6.
 */
@Service
public class TicketServiceImpl implements TicketService {

    private String createUrl = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=%s";

    private String getUrl = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=%s";

    @Autowired
    private HttpsService httpsService;

    @Override
    public TicketResult create(Ticket ticket) {
        String result = httpsService.post(String.format(createUrl, WXAccessToken.ACCESS_TOKEN), JsonUtils.toString(ticket));
        return JsonUtils.toBean(result, TicketResult.class);
    }

    @Override
    public void get(String ticket, String filePath) {
        httpsService.download(String.format(getUrl, ticket), filePath);
    }

}
