package com.witcream.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipUtil {
	public static byte[] compressToByte(String str, String charset) {
		if ((str == null) || (str.length() == 0)) {
			return null;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			GZIPOutputStream gzip = new GZIPOutputStream(out);
			gzip.write(str.getBytes(charset));
			gzip.close();
			return out.toByteArray();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static byte[] compressToByte(String str) {
		return compressToByte(str, Charset.defaultCharset().name());
	}

	public static byte[] compressToByte(byte[] bytes) {
		if ((bytes == null) || (bytes.length == 0)) {
			return null;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			GZIPOutputStream gzip = new GZIPOutputStream(out);
			gzip.write(bytes);
			gzip.close();
			return out.toByteArray();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String uncompressToString(byte[] b) {
		return uncompressToString(b, Charset.defaultCharset().name());
	}

	public static String uncompressToString(byte[] b, String encoding) {
		if ((b == null) || (b.length == 0)) {
			return null;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = new ByteArrayInputStream(b);
		try {
			GZIPInputStream gunzip = new GZIPInputStream(in);
			byte[] buffer = new byte['?'];
			int n;
			while ((n = gunzip.read(buffer)) >= 0) {
				out.write(buffer, 0, n);
			}
			return out.toString(encoding);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
