package com.hxl.wx.handler;

import com.hxl.wx.entity.event.EventMessage;
import com.hxl.wx.entity.message.Message;
import com.hxl.wx.entity.reply.ReplyMessage;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Created by hxl on 2016/12/9.
 */
public class DefaultHandler {

    public <T extends Message> ReplyMessage handler(T message) {
        return null;
    }

    public <T extends EventMessage> ReplyMessage handler(T event) {
        return null;
    }

    public static void main(String[] args) {
        Class<?>[] declaredClasses = Message.class.getDeclaredClasses();
        try {
            Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources("com/hxl/wx/entity/message");
            if (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                System.out.println(url);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
