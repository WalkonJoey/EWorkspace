package com.witcream.core;

import java.util.Objects;

import com.witcream.util.StringUtil;

public abstract class Assert {
	public static void isNull(Object object, String message) {
		if (Objects.nonNull(object)) {
			throw new RuntimeException(message);
		}
	}

	public static void notNull(Object object, String message) {
		if (Objects.isNull(object)) {
			throw new RuntimeException(message);
		}
	}

	public static void isEmpty(String text, String message) {
		if (StringUtil.isNotEmpty(text)) {
			throw new RuntimeException(message);
		}
	}

	public static void isNotEmpty(String text, String message) {
		if (StringUtil.isEmpty(text)) {
			throw new RuntimeException(message);
		}
	}

	public static void isBlank(String arg, String message) {
		if (StringUtil.isNotBlank(arg)) {
			throw new RuntimeException(message);
		}
	}

	public static void isNotBlank(String arg, String message) {
		if (StringUtil.isBlank(arg)) {
			throw new RuntimeException(message);
		}
	}

	public static void anyNotNull(String message, Object... objects) {
		boolean b = false;
		for (Object obj : objects) {
			if (Objects.nonNull(obj)) {
				b = true;
				break;
			}
		}
		if (!b) {
			throw new RuntimeException(message);
		}
	}

	public static void allNotNull(String message, Object... objects) {
		boolean b = true;
		for (Object obj : objects) {
			if (Objects.isNull(obj)) {
				b = false;
				break;
			}
		}
		if (!b) {
			throw new RuntimeException(message);
		}
	}
}
