package com.jxlianlian.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

  public static String FORMAT_SECONDS = "yyyy-MM-dd HH:mm:ss";
  public static String FORMAT_MILLISECONDS = "yyyy-MM-dd HH:mm:ss.SSS";

  /**
   * 时间戳转换成日期格式字符串
   * 
   * @param time
   *          毫秒时间戳
   * @param formatStr
   * @return
   */
  public static String timeStamp2Date(long time, String format) {
    if (format == null || format.isEmpty())
      format = FORMAT_MILLISECONDS;
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    return sdf.format(new Date(time));
  }

  /**
   * 日期格式字符串转换成时间戳
   * 
   * @param date
   *          字符串日期
   * @param format
   *          如：yyyy-MM-dd HH:mm:ss
   * @return
   */
  public static long date2TimeStamp(String date_str, String format) {
    if (format == null || format.isEmpty())
      format = FORMAT_MILLISECONDS;
    try {
      SimpleDateFormat sdf = new SimpleDateFormat(format);
      return sdf.parse(date_str).getTime();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return -1L;
  }

  /**
   * 取得当前时间戳（精确到毫秒）
   * 
   * @return
   */
  public static long timeStamp() {
    return System.currentTimeMillis();
  }

  // 输出结果：
  // timeStamp=1417792627
  // date=2014-12-05 23:17:07
  // 1417792627
  public static void main(String[] args) {
    long timeStamp = timeStamp();
    System.out.println("timeStamp=" + timeStamp);

    String date = timeStamp2Date(timeStamp, "yyyy-MM-dd HH:mm:ss");
    System.out.println("date=" + date);

    long timeStamp2 = date2TimeStamp(date, "yyyy-MM-dd HH:mm:ss");
    System.out.println(timeStamp2);
  }
}
