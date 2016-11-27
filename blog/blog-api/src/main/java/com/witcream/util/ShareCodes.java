package com.witcream.util;

import java.util.Random;

public class ShareCodes {
	private static final char[] r = "mqba2efd3knps4c5jg6htru7vw8xi9yz".toCharArray();
	private static final char b = 'o';
	private static final int binLen = r.length;
	private static final int s = 6;

	public static String encode(long id) {
		char[] buf = new char[32];
		int charPos = 32;
		while (id / binLen > 0L) {
			int ind = (int) (id % binLen);
			buf[(--charPos)] = r[ind];
			id /= binLen;
		}
		buf[(--charPos)] = r[((int) (id % binLen))];
		String str = new String(buf, charPos, 32 - charPos);
		if (str.length() < s) {
			StringBuilder sb = new StringBuilder();
			sb.append(b);
			Random rnd = new Random();
			for (int i = 1; i < s - str.length(); i++) {
				sb.append(r[rnd.nextInt(binLen)]);
			}
			str = str + sb.toString();
		}
		return str;
	}

	public static long decode(String code) {
		char[] chs = code.toCharArray();
		long res = 0L;
		for (int i = 0; i < chs.length; i++) {
			int ind = 0;
			for (int j = 0; j < binLen; j++) {
				if (chs[i] == r[j]) {
					ind = j;
					break;
				}
			}
			if (chs[i] == b) {
				break;
			}
			if (i > 0) {
				res = res * binLen + ind;
			} else {
				res = ind;
			}
		}
		return res;
	}
}
