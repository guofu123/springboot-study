package com.kkb.my.travle.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtil {


    /**
     * 将时间格式化为yyyy-MM-dd
     * @param date
     * @return
     */
    public static String strToDateTime(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }
}
