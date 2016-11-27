package com.witcream.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static final String A = "yyyyMMddHHmmss";
	public static final String B = "yyyy-MM-dd HH:mm:ss";
	public static final String C = "yyyyMMddHHmmssSSS";

	public static String getCurDate() {
		return formatCurDate("yyyyMMddHHmmss");
	}

	public static String getCurDateWithSeparator() {
		return formatCurDate("yyyy-MM-dd HH:mm:ss");
	}

	public static String formatCurDate(String pattern) {
		return format(new Date(), pattern);
	}

	public static String format(Date date, String pattern) {
		return new SimpleDateFormat(pattern).format(date);
	}

	public static String format(String source, String currentPattern, String formatPattern) {
		try {
			return format(new SimpleDateFormat(currentPattern).parse(source), formatPattern);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public static Date parse(String source, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(source);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public static Date parseWithSeparator(String source) {
		return parse(source, "yyyy-MM-dd HH:mm:ss");
	}

	public static long getTimeMillis(String source, String pattern) {
		return parse(source, pattern).getTime();
	}
}
