package com.witcream.util;

import java.net.URLDecoder;
import java.net.URLEncoder;

import com.witcream.core.Consts;

public class CodecUtil {
	public static String encodeURL(String str) {
		String target;
		try {
			target = URLEncoder.encode(str, Consts.UTF_8.name());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return target;
	}

	public static String decodeURL(String str) {
		String target;
		try {
			target = URLDecoder.decode(str, Consts.UTF_8.name());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return target;
	}
}
