package com.hxl.wx.handler;

import com.hxl.wx.utils.JsonUtils;

import java.util.HashMap;

/**
 * Created by hxl on 2016/11/21.
 * 操作结果帮助类
 */
public class ResultHandler {

    public static String handler(String result) throws Exception {
        HashMap hashMap = JsonUtils.toBean(result, HashMap.class);
        //{"errcode":45009,"errmsg":"api freq out of limit"}
        Object errcode = hashMap.get("errcode");
        if (errcode == null) {
            return result;
        }
        if (errcode.toString().equals("0")) {
            return result;
        } else {
            throw new Exception(result);
        }
    }

}
