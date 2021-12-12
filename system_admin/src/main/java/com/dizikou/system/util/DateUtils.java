package com.dizikou.system.util;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author Just be alive
 * @version 1.0
 * @date 2021-12-11 - 12:30
 */
public class DateUtils {


    /**
     * strDate[0] 年月日
     * strDate[1] 时分秒
     * @return string[]
     */
    public static String[] getYMD() {
        Date date = new Date();
        SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd");
        String f1 = s1.format(date);
        SimpleDateFormat s2 = new SimpleDateFormat("HH:mm:ss");
        String f2 = s2.format(date);
        String[] strDate = new String[10];
        strDate[0] =f1;
        strDate[1] = f2;
        return strDate;
    }


    /**
     * 获取当前时间
     * @return 当前时间
     */
    private static String getCurrentDate(){
        SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return s1.format(new Date());
    }


}
