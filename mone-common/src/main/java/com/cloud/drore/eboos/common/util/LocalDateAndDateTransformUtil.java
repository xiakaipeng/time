package com.cloud.drore.eboos.common.util;

import java.time.*;
import java.util.Date;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: localDate和Date相互转换的工具类:LocalDateTime包含时分秒,<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/2/2 10:51 <br>
 * @Author: <a href="4105089661@qq.com">夏凯</a>
 */
public class LocalDateAndDateTransformUtil {

    /**
     * @param date
     * @ClassName: LocalDateAndDateTransformUtil
     * @Return: java.util.Date
     * @Decription: 01.java.util.Date --> java.time.LocalDateTime
     * @CreateDate: Created in 2018/2/2 0002 下午 2:13
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime;
    }

    /**
     * @param date
     * @ClassName: LocalDateAndDateTransformUtil
     * @Return: java.time.LocalDate
     * @Decription: 02. java.util.Date --> java.time.LocalDate
     * @CreateDate: Created in 2018/2/2 0002 下午 2:23
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public static LocalDate dateToLocalDate(Date date) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate localDate = localDateTime.toLocalDate();
        return localDate;
    }

    /**
     * @param date
     * @ClassName: LocalDateAndDateTransformUtil
     * @Return: java.time.LocalTime
     * @Decription: 03. java.util.Date --> java.time.LocalTime
     * @CreateDate: Created in 2018/2/2 0002 下午 2:26
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public static LocalTime dateToLocalTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalTime localTime = localDateTime.toLocalTime();
        return localTime;
    }

    /**
     * @param localDateTime
     * @ClassName: LocalDateAndDateTransformUtil
     * @Return: java.util.Date
     * @Decription: 04. java.time.LocalDateTime --> java.util.Date
     * @CreateDate: Created in 2018/2/2 0002 下午 2:27
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
        return date;
    }


    /**
     * @param localDate
     * @ClassName: LocalDateAndDateTransformUtil
     * @Return: java.util.Date
     * @Decription: 05. java.time.LocalDate --> java.util.Date
     * @CreateDate: Created in 2018/2/2 0002 下午 2:38
     * @Author: <a href="410508961@qq.com">夏凯</a>
     * @Modify:
     */
    public static Date localDateToDate(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        Date date = Date.from(instant);
        return date;
    }
    
}
