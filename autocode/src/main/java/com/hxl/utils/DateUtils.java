package com.hxl.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by hxl on 2016/10/8.
 */
public class DateUtils {

    private  static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String currentDateString() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(dateTimeFormatter);
    }

    public static LocalDateTime currentDate() {
        return LocalDateTime.now();
    }

    public static LocalDateTime parseString(String date) {
        return StringUtils.isEmpty(date) ? null : LocalDateTime.parse(date, dateTimeFormatter);
    }

    public static String formatDate(LocalDateTime dateTime, String pattern) {
        return StringUtils.isEmpty(pattern) || dateTime == null ? null : DateTimeFormatter.ofPattern(pattern).format(dateTime);
    }

}
