package com.jiuling.core.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * 时间日期帮助类
 * @author Administrator
 *
 */
public class DateTimeUtils {

	public static final String DEFAULT_FORMAT_DATE_WITHOUT_TIME = "yyyy-MM-dd";
	public static final String DEFAULT_FORMAT_DATE = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_DATE_STYLE1 = "yyyyMMddHHmmss";
	public static final Pattern DATE_PATTERN = Pattern.compile("^(?:(?!0000)[0-9]{4}([-/.]?)(?:(?:0?[1-9]|1[0-2])([-/.]?)(?:0?[1-9]|1[0-9]|2[0-8])|(?:0?[13-9]|1[0-2])([-/.]?)(?:29|30)|(?:0?[13578]|1[02])([-/.]?)31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)([-/.]?)0?2([-/.]?)29)$");

	/**
	 * 校验时间格式
	 * @param dateText
	 * @return
	 */
	public static boolean validateDateFormat(String dateText){
		return DATE_PATTERN.matcher(dateText).matches();
	}
	
	/**
	 * 获取当前时间
	 * @return
	 */
	public static Timestamp now(){
		return new Timestamp(System.currentTimeMillis());
	}
	
	 /**
     * 获取当前时间字符串
     * 
     * @param args
     */
    public static String getNowTime() {
        return formatDate(new Date(), null);
    }

	
	public static Date resetTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
	
	/**
	 * 比较两个时间，如果endtime晚于begintime，则返回true，否则返回false
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public static boolean compareTime(String beginTime, String endTime) {
		long begin = DateTime.dateTimeParse(beginTime, DEFAULT_FORMAT_DATE);
		long end = DateTime.dateTimeParse(endTime, DEFAULT_FORMAT_DATE);
		if (end > begin) {
			return true;
		}
		return false;
	}
	
	/**
	 * 比较两个时间，如果endtime晚于begintime，则返回true，否则返回false
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public static boolean compareTime(String beginTime, String endTime,String dateformat) {
		long begin = DateTime.dateTimeParse(beginTime, dateformat);
		long end = DateTime.dateTimeParse(endTime, dateformat);
		if (end > begin) {
			return true;
		}
		return false;
	}

	/**
	 * date转string
	 * @param date
	 * @param formatStr
	 * @return
	 */
	public static String formatDate(Date date, String formatStr) {
		return (new SimpleDateFormat((formatStr == null ? DEFAULT_FORMAT_DATE
				: formatStr))).format(date);
	}

	/**
	 *  string转date
	 * @param dateStr
	 * @param formatStr
	 * @return
	 * @throws ParseException
	 */
	public static Date formatDate(String dateStr, String formatStr)
			throws ParseException {
		return (new SimpleDateFormat((formatStr == null ? DEFAULT_FORMAT_DATE
				: formatStr))).parse(dateStr);
	}
	/*
	 * type 1年 2月 3日
	 */
	public static String getNowFolder(Integer type){
		String nowTime = getNowTime();
		String []  data = nowTime.substring(0,10).split("-"); 
		if(1 == type){
			return data[0];
		}else if( 2 == type){
			return data[1];
		}else if(3 == type){
			return data[2];
		}
		return null;
	}
	public static void main(String[] args) {
		System.out.println(getNowFolder(3));
	}

}
