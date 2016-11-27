package com.witcream.util;

import org.slf4j.LoggerFactory;

public class LogUtil {
	private static String NAME = LogUtil.class.getName();

	public static org.apache.log4j.Logger logLogger() {
		return logLogger(getClassName());
	}

	public static org.apache.log4j.Logger logLogger(String className) {
		return org.apache.log4j.Logger.getLogger(className);
	}

	public static org.slf4j.Logger slfLogger() {
		return slfLogger(getClassName());
	}

	public static org.slf4j.Logger slfLogger(String className) {
		return LoggerFactory.getLogger(className);
	}

	private static String getClassName() {
		StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
		for (int i = 1; i < stacks.length; i++) {
			if (!NAME.equals(stacks[i].getClassName())) {
				return stacks[i].getClassName();
			}
		}
		return NAME;
	}

	public static void error(org.slf4j.Logger logger, Throwable th) {
		error(th.getMessage(), logger, th);
	}

	public static void error(String message, org.slf4j.Logger logger, Throwable th) {
		logger.error("{}, {}", message, th.getMessage());
		StackTraceElement[] stack = th.getStackTrace();
		logger.error("{}", th.fillInStackTrace().toString());
		int len = stack.length;
		for (int i = 0; i < len; i++) {
			StackTraceElement ele = stack[i];
			logger.error(String.format("[%02d][%s->%s:%s]", new Object[] { Integer.valueOf(i), ele.getClassName(),
					ele.getMethodName(), Integer.valueOf(ele.getLineNumber()) }));
		}
	}

	public static void error(org.apache.log4j.Logger logger, Throwable th) {
		error(th.getMessage(), logger, th);
	}

	public static void error(String message, org.apache.log4j.Logger logger, Throwable th) {
		logger.error(message + ", " + th.getMessage());
		StackTraceElement[] stack = th.getStackTrace();
		logger.error(th.fillInStackTrace().toString());
		int len = stack.length;
		for (int i = 0; i < len; i++) {
			StackTraceElement ele = stack[i];
			logger.error(String.format("[%02d][%s->%s:%s]", new Object[] { Integer.valueOf(i), ele.getClassName(),
					ele.getMethodName(), Integer.valueOf(ele.getLineNumber()) }));
		}
	}
}
