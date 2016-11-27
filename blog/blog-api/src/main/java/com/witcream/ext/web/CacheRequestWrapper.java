package com.witcream.ext.web;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CacheRequestWrapper extends HttpServletRequestWrapper {
	private final byte[] payload;

	public CacheRequestWrapper(HttpServletRequest request) throws IOException {
		super(request);
		InputStream in = request.getInputStream();
		byte[] buf = new byte['?'];

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int len;
		while ((len = in.read(buf)) != -1) {
			out.write(buf, 0, len);
		}
		this.payload = out.toByteArray();
	}

	public ServletInputStream getInputStream() throws IOException {
		final ByteArrayInputStream in = new ByteArrayInputStream(this.payload);

		return new ServletInputStream() {
			public int read() throws IOException {
				return in.read();
			}

			public boolean isFinished() {
				return false;
			}

			public boolean isReady() {
				return false;
			}

			public void setReadListener(ReadListener readListener) {
			}
		};
	}

	public byte[] getContent() {
		return this.payload;
	}
}
