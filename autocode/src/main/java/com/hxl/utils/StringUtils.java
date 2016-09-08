package com.hxl.utils;

/**
 * Created by hxl on 2016/9/5.
 */
public class StringUtils {

    public static boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public static boolean isNotEmpty(String s) {
        return s != null && s.trim().length() != 0;
    }

}
