package com.mamba.houses.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * desc:
 * author:devzhong
 * Date:2018/4/5 17:23
 */
public class DateUtil {
    private final static Logger logger = LoggerFactory.getLogger(DateUtil.class);


    /**
     * 获取某个时间前几天的时间
     * @param day
     * @param date
     * @return
     */
    public static Date getDateBefore(int day,Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE,calendar.get(Calendar.DATE) - day);
        return calendar.getTime();
    }

    public static String formatDateYYYYMMDD(Date date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static String formatDateTime(Date date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static String todayOfStart(Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
            return sdf.format(date);
        }
        return null;
    }

    public static String todayOfEnd(Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
            return sdf.format(date);
        }
        return null;
    }

    public static String formatYYYYMMDD(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    /**
     * 所在周开始时间
     *
     * @return
     */
    public static Date getBeginDayOfWeek(Date date) {
        try {
            if (date == null) {
                return null;
            }
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
            if (dayWeek == 1) {
                dayWeek = 7;
            } else {
                dayWeek -= 1;
            }
            cal.add(Calendar.DAY_OF_MONTH, 1 - dayWeek);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf2.parse(sdf.format(cal.getTime()));
        } catch (ParseException e) {
            logger.error("DateUtil getBeginDayOfWeek ERROR:{}", e);
            return null;
        }
    }

    /**
     * 所在周结束时间
     *
     * @return
     */
    public static Date getEndDayOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getBeginDayOfWeek(date));
        cal.add(Calendar.DATE, 6);
        Date weekEndSta = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf2.parse(sdf.format(cal.getTime()));
        } catch (ParseException e) {
            logger.error("DateUtil getEndDayOfWeek ERROR:{}", e);
            return null;
        }
    }

    /**
     * 所在月第一天
     *
     * @return
     */
    public static Date getBeginDayOfMonth(Date date) {
        try {
            Calendar calendar = Calendar.getInstance();//获取当前日期
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, 0);
            calendar.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
            Date startDate = calendar.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            return sdf2.parse(sdf.format(startDate));
        } catch (ParseException e) {
            logger.error("DateUtil getBeginDayOfMonth ERROR:{}", e);
            return null;
        }
    }

    /**
     * 所在月最后一天
     *
     * @return
     */
    public static Date getEndDayOfMonth(Date date) {
        try {
            Calendar calendar = Calendar.getInstance();//获取当前日期
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, 1);
            calendar.set(Calendar.DAY_OF_MONTH, 0);
            Date startDate = calendar.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            return sdf2.parse(sdf.format(startDate));
        } catch (ParseException e) {
            logger.error("DateUtil getBeginDayOfMonth ERROR:{}", e);
            return null;
        }
    }

    /**
     * 所在天的开始时间
     *
     * @param date
     * @return
     */
    public static Date getBeginDayOfDay(Date date) {
        try {
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
            return sdf2.parse(sdf.format(date));
        } catch (ParseException e) {
            logger.error("DateUtil getBeginDayOfMonth ERROR:{}", e);
            return null;
        }
    }

    /**
     *所在天结束时间
     * @param date
     * @return
     */
    public static Date getEndDayOfDay(Date date) {
        try {
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
            return sdf2.parse(sdf.format(date));
        } catch (ParseException e) {
            logger.error("DateUtil getBeginDayOfMonth ERROR:{}", e);
            return null;
        }
    }

    /**
     * 获取前一天
     * @param date
     * @return
     */
    public static Date getBeforeDay(Date date){
        try {
            Calendar calendar = Calendar.getInstance();//获取当前日期
            calendar.setTime(date);
            calendar.add(Calendar.DATE, -1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf2.parse(sdf.format(calendar.getTime()));
        } catch (Exception e) {
            logger.error("DateUtil getBeginDayOfMonth ERROR:{}", e);
            return null;
        }
    }

    /**
     * 所在月有几天
     * @param date
     * @return
     */
    public static int daysOfMonth(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getActualMaximum(Calendar.DATE);
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf2.format(getBeforeDay(new Date())));
        System.out.println(sdf2.format(getEndDayOfWeek(new Date())));
        System.out.println(sdf2.format(getBeginDayOfMonth(new Date())));
        System.out.println(daysOfMonth(new Date(1549900800000l)));
    }
}
