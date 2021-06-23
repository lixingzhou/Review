package com.mccree.review.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

public class ToolUtils {

    private static Pattern p = Pattern.compile("^(1[0-9])\\d{9}$");

    /**
     * 将时间戳转换为时间
     */
    public static String stampToDate(long lt, int type) {
        String format = "yyyy-MM-dd HH:mm:ss";
        if (type == 1) {
            format = "yyyy-MM-dd HH:mm";
        } else if (type == 2) {
            format = "yyyy-MM-dd";
        } else if (type == 3) {
            format = "yyyy-MM";
        } else if (type == 4) {
            format = "MM-dd HH:mm";
        } else if (type == 5) {
            format = "MM-dd";
        } else if (type == 6) {
            format = "HH:mm";
        } else if (type == 7) {
            format = "dd";
        } else if (type == 8) {
            format = "yy/MM/dd";
        } else if (type == 9) {
            format = "mm:ss";
        }
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.CHINA);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
}
