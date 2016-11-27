package com.witcream.util;

import java.util.Random;

public class RandomUtil {
	public static String createNum(int len) {
		char[] chars = "0123456789".toCharArray();
		Random random = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			sb.append(chars[random.nextInt(10)]);
		}
		return sb.toString();
	}
}
