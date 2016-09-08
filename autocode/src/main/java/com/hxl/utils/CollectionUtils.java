package com.hxl.utils;

import java.util.List;

/**
 * Created by hxl on 2016/9/5.
 */
public class CollectionUtils {

    public static <T> boolean isEmpty(List<T> list) {
        return list == null || list.isEmpty();
    }

    public static <T> boolean isNotEmpty(List<T> list) {
        return list != null && list.size() != 0;
    }

}
