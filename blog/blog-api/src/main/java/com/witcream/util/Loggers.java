package com.witcream.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 这个工具类相当于一个log factory的作用，在引用的系统中配置了log4j或者logback就能通过此工具类获取到Logger实例，进行日志打印
 * @author Joey
 *
 */
public class Loggers {
	private static String NAME = Loggers.class.getName();

	public static Logger getLogger() {
		return getLogger(getClassName());
	}

	public static Logger getLogger(String className) {
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

	public static void error(Logger logger, Throwable th) {
		error(th.getMessage(), logger, th);
	}

	public static void error(String message, Logger logger, Throwable th) {
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
}
