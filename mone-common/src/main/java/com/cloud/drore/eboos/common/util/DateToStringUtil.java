package com.cloud.drore.eboos.common.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 将日期类型转化为字符串的工具类<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/2 10:51 <br>
 * @Author: <a href="747639122@qq.com">冯腾</a>
 */
public class DateToStringUtil {

    private static final String dateString = "yyyy-MM-dd";

    private static final String dateTimeSting = "yyyy-MM-dd HH:mm:ss";

    /**
     * @param date
     * @ClassName: DateToStringUtil
     * @Return: java.lang.String
     * @Decription:将Date转化为yyyy-MM-dd类型的字符串的方法
     * @CreateDate: Created in 2018/2/2 11:01
     * @Author: <a href="747639122@qq.com">冯腾</a>
     * @Modify:
     */
    public static String getStringDate(Date date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateString);
        Instant instant = date.toInstant();
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        String stringDate = localDate.format(formatter);
        return stringDate;
    }

    /**
     * @param date
     * @ClassName: DateToStringUtil
     * @Return: java.lang.String
     * @Decription:将Date转化为yyyy-MM-dd HH-mm-ss类型的字符串的方法
     * @CreateDate: Created in 2018/2/2 11:03
     * @Author: <a href="747639122@qq.com">冯腾</a>
     * @Modify:
     */
    public static String getStringDateTime(Date date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeSting);
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        String stringDateTime = localDateTime.format(formatter);
        return stringDateTime;
    }

    /**
     * @ClassName: DateToStringUtil
     * @param timeString
     * @Return: java.util.Date
     * @Decription: string类型的日期转化为HH:mm:ss类型
     * @CreateDate: Created in 2018/3/15 0015 上午 9:30
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public static Date getTimeShort(String timeString) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(timeString, pos);
        return strtodate;
    }
}
