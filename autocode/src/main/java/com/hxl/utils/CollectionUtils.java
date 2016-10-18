package com.hxl.utils;

import java.util.List;

/**
 * Created by hxl on 2016/9/5.
 */
public class CollectionUtils {

    public static boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean isNotEmpty(List<?> list) {
        return list != null && list.size() != 0;
    }

}
