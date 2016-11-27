package com.witcream.util;

import java.util.regex.Pattern;

public class StringUtil {
	public static final String SPACE = " ";
	public static final String EMPTY = "";
	private static final Pattern WHITESPACE_PATTERN = Pattern.compile("(?: |\\u00A0|\\s|[\\s&&[^ ]])\\s*");
	public static final int INDEX_NOT_FOUND = -1;

	public static boolean isEmpty(CharSequence cs) {
		return (cs == null) || (cs.length() == 0);
	}

	public static boolean isNotEmpty(CharSequence cs) {
		return !isEmpty(cs);
	}

	public static boolean isBlank(CharSequence cs) {
		int strLen;
		if ((cs == null) || ((strLen = cs.length()) == 0)) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isNotBlank(CharSequence cs) {
		return !isBlank(cs);
	}

	public static String trim(String str) {
		return str == null ? null : str.trim();
	}

	public static String trimToNull(String str) {
		String ts = trim(str);
		return isEmpty(ts) ? null : ts;
	}

	public static String trimToEmpty(String str) {
		return str == null ? "" : str.trim();
	}

	public static String strip(String str) {
		return strip(str, null);
	}

	public static String stripToNull(String str) {
		if (str == null) {
			return null;
		}
		str = strip(str, null);
		return str.isEmpty() ? null : str;
	}

	public static String stripToEmpty(String str) {
		return str == null ? "" : strip(str, null);
	}

	public static String strip(String str, String stripChars) {
		if (isEmpty(str)) {
			return str;
		}
		str = stripStart(str, stripChars);
		return stripEnd(str, stripChars);
	}

	public static String stripStart(String str, String stripChars) {
		int strLen;
		if ((str == null) || ((strLen = str.length()) == 0)) {
			return str;
		}
		int start = 0;
		if (stripChars == null) {
			while ((start != strLen) && (Character.isWhitespace(str.charAt(start)))) {
				start++;
			}
		}
		if (stripChars.isEmpty()) {
			return str;
		}
		while ((start != strLen) && (stripChars.indexOf(str.charAt(start)) != -1)) {
			start++;
		}
		return str.substring(start);
	}

	public static String stripEnd(String str, String stripChars) {
		int end;
		if ((str == null) || ((end = str.length()) == 0)) {
			return str;
		}
		if (stripChars == null) {
			while ((end != 0) && (Character.isWhitespace(str.charAt(end - 1)))) {
				end--;
			}
		}
		if (stripChars.isEmpty()) {
			return str;
		}
		while ((end != 0) && (stripChars.indexOf(str.charAt(end - 1)) != -1)) {
			end--;
		}
		return str.substring(0, end);
	}

	public static String[] stripAll(String... strs) {
		return stripAll(strs, null);
	}

	public static String[] stripAll(String[] strs, String stripChars) {
		int strsLen;
		if ((strs == null) || ((strsLen = strs.length) == 0)) {
			return strs;
		}
		String[] newArr = new String[strsLen];
		for (int i = 0; i < strsLen; i++) {
			newArr[i] = strip(strs[i], stripChars);
		}
		return newArr;
	}

	public static String normalizeSpace(String str) {
		if (str == null) {
			return null;
		}
		return WHITESPACE_PATTERN.matcher(trim(str)).replaceAll(" ");
	}

	public static boolean isNumeric(CharSequence cs) {
		if (isEmpty(cs)) {
			return false;
		}
		int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isDigit(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isNumericSpace(CharSequence cs) {
		if (cs == null) {
			return false;
		}
		int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if ((!Character.isDigit(cs.charAt(i))) && (cs.charAt(i) != ' ')) {
				return false;
			}
		}
		return true;
	}

	public static boolean isWhitespace(CharSequence cs) {
		if (cs == null) {
			return false;
		}
		int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isWhitespace(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isAllLowerCase(CharSequence cs) {
		if ((cs == null) || (isEmpty(cs))) {
			return false;
		}
		int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isLowerCase(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isAllUpperCase(CharSequence cs) {
		if ((cs == null) || (isEmpty(cs))) {
			return false;
		}
		int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isUpperCase(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static String defaultString(String str) {
		return str == null ? "" : str;
	}

	public static String defaultString(String str, String defaultStr) {
		return str == null ? defaultStr : str;
	}

	public static <T extends CharSequence> T defaultIfBlank(T str, T defaultStr) {
		return isBlank(str) ? defaultStr : str;
	}

	public static <T extends CharSequence> T defaultIfEmpty(T str, T defaultStr) {
		return isEmpty(str) ? defaultStr : str;
	}

	public static String reverse(String str) {
		if (str == null) {
			return null;
		}
		return new StringBuilder(str).reverse().toString();
	}

	public static String startUppper(String src, int len) {
		if (isBlank(src)) {
			return src;
		}
		if (len >= src.length()) {
			return src.toUpperCase();
		}
		return src.substring(0, len).toUpperCase() + src.substring(len);
	}

	public static boolean isBlank(String... strs) {
		for (String param : strs) {
			if (isBlank(param)) {
				return true;
			}
		}
		return false;
	}
}
