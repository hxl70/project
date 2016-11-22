package com.hxl.wx.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by hxl on 2016/11/21.
 * 加密工具类
 */
public class EncryptUtils {

    /**
     * MD5加密
     * @param s 加密的字符串
     * @return md5
     */
    public static String md5(String s) {
        return encrypt("MD5", s);
    }

    /**
     * SHA1 加密
     * @param s 加密的字符串
     * @return sha1
     */
    public static String sha1(String s) {
        return encrypt("SHA-1", s);
    }

    public static String encrypt(String algorithm, String s) {
        try {
            MessageDigest instance = MessageDigest.getInstance(algorithm);
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
            return null;
        }
    }

}
