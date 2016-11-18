package com.hxl.wx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by hxl on 2016/11/18.
 */
@Controller
public class InitController {

    /**
     * 加密/校验流程如下：
     * 1. 将token、timestamp、nonce三个参数进行字典序排序
     * 2. 将三个参数字符串拼接成一个字符串进行sha1加密
     * 3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
     * @param signature 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     * @param timestamp 时间戳
     * @param nonce 随机数
     * @param echostr 随机字符串
     * @return 原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败。
     */
    @ResponseBody
    @RequestMapping("/init")
    public String init(@RequestParam("signature") String signature,
                       @RequestParam("timestamp") String timestamp,
                       @RequestParam("nonce") String nonce,
                       @RequestParam("echostr") String echostr) {
        String token = "xling";
        String sort = sort(token, timestamp, nonce);
        String sha1 = sha1(sort);
        if (sha1 != null && sha1.equals(signature)) {
            return echostr;
        }
        return "";
    }

    private String sort(String token, String timestamp, String nonce) {
        String[] arrays = new String[]{token, timestamp, nonce};
        Arrays.sort(arrays);
        StringBuffer sb = new StringBuffer();
        Arrays.asList(arrays).stream().forEach(sb::append);
        return sb.toString();
    }

    private String sha1(String s) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(s.getBytes());
            byte[] digest = instance.digest();
            StringBuffer sb = new StringBuffer(digest.length * 2);
            for (byte b : digest) {
                String shaHex = Integer.toHexString(b & 0xFF);
                if (shaHex.length() < 2) {
                    sb.append(0);
                }
                sb.append(shaHex);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
