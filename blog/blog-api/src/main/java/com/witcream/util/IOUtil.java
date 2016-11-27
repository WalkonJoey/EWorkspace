package com.witcream.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class IOUtil {
	public static void close(Closeable o) {
		if (o != null) {
			try {
				o.close();
			} catch (IOException localIOException) {
			}
		}
	}

	public static byte[] toByteArray(InputStream in) {
		if (in == null) {
			return null;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		byte[] buf = new byte['?'];
		try {
			int len;
			while ((len = in.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
			return out.toByteArray();
		} catch (IOException localIOException1) {
		} finally {
			close(out);
		}
		return null;
	}

	public static String toString(InputStream in, Charset cs) {
		InputStreamReader isReader;
		if (cs != null) {
			isReader = new InputStreamReader(in, cs);
		} else {
			isReader = new InputStreamReader(in);
		}
		BufferedReader bufReader = new BufferedReader(isReader);

		char[] cbuf = new char['?'];
		StringBuilder sb = new StringBuilder(64);
		try {
			int len;
			while ((len = bufReader.read(cbuf)) != -1) {
				sb.append(cbuf, 0, len);
			}
			return sb.toString();
		} catch (IOException localIOException1) {
		} finally {
			close(isReader);
			close(bufReader);
		}
		return null;
	}

	public static String toString(InputStream in) {
		return toString(in, (Charset) null);
	}

	public static String toString(InputStream in, String encoding) {
		return StringUtil.isNotBlank(encoding) ? toString(in, Charset.forName(encoding)) : toString(in);
	}
}
