package com.witcream.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Calendars {
	public static Calendar newInstance() {
		return Calendar.getInstance();
	}

	public static Calendar newInstance(int year, int month, int date, int hourOfDay, int minute, int second,
			int millis) {
		Calendar instance = newInstance();
		instance.set(year, month, date, hourOfDay, minute, second);
		instance.set(14, 0);
		return instance;
	}

	public static Calendar newInstance(int year, int month, int date, int hourOfDay, int minute, int second) {
		return newInstance(year, month, date, hourOfDay, minute, second, 0);
	}

	public static Calendar newInstance(int year, int month, int date, int hourOfDay, int minute) {
		return newInstance(year, month, date, hourOfDay, minute, 0, 0);
	}

	public static Calendar newInstance(int year, int month, int date) {
		return newInstance(year, month, date, 0, 0, 0, 0);
	}

	public static Calendar clear(int... fields) {
		Calendar instance = newInstance();
		for (int field : fields) {
			instance.set(field, 0);
		}
		return instance;
	}

	public static void clear(Calendar instance, int... fields) {
		List<Integer> calFields = Arrays
				.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(11),
						Integer.valueOf(12), Integer.valueOf(13), Integer.valueOf(14) });
		for (int field : fields) {
			if (calFields.contains(Integer.valueOf(field))) {
				instance.set(field, 0);
			}
		}
	}

	public static String currentDate(String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.format(newInstance().getTime());
		} catch (Exception e) {
			throw e;
		}
	}

	public static String format(Date date, String pattern) {
		return new SimpleDateFormat(pattern).format(date);
	}

	public static String format(Calendar calendar, String pattern) {
		return format(calendar.getTime(), pattern);
	}

	public static String format(String source, String currentPattern, String formatPattern) {
		try {
			return format(new SimpleDateFormat(currentPattern).parse(source), formatPattern);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public static Calendar toCalendar(String source, String pattern) {
		Calendar instance = newInstance();
		instance.setTime(toDate(source, pattern));
		return instance;
	}

	public static Date toDate(String source, String pattern) {
		try {
			return new SimpleDateFormat(pattern).parse(source);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public static long currentTimeMillis() {
		return System.currentTimeMillis();
	}

	public static long getTimeMillis(String source, String pattern) {
		return toDate(source, pattern).getTime();
	}

	public static long currentTimeSeconds() {
		return (currentTimeMillis() - currentTimeMillis() % 1000L) / 1000L;
	}
}
