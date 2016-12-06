package com.hxl.wx.service;

import com.hxl.wx.entity.Ticket;
import com.hxl.wx.entity.TicketResult;

/**
 * Created by hxl on 2016/12/6.
 */
public interface TicketService {

    /**
     * 创建二维码ticket
     * @param ticket
     * @return
     */
    TicketResult create(Ticket ticket);

    /**
     * 通过ticket换取二维码
     * @param ticket
     * @param filePath
     */
    void get(String ticket, String filePath);

}
