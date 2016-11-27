package com.witcream.core.http;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class Response {
	private int code;
	private Map<String, List<String>> headers;
	private InputStream inputStream;
	private String content;

	public Response(int code, Map<String, List<String>> headers, InputStream inputStream) {
		this.code = code;
		this.headers = headers;
		this.inputStream = inputStream;
	}

	public int code() {
		return this.code;
	}

	public Map<String, List<String>> headers() {
		return this.headers;
	}

	public String header(String key) {
		if (!this.headers.containsKey(key)) {
			return null;
		}
		return this.headers.get(key).get(0);
	}

	public List<String> headerList(String key) {
		if (!this.headers.containsKey(key)) {
			return null;
		}
		return this.headers.get(key);
	}

	public InputStream contentStream() {
		return this.inputStream;
	}

	public InputStream bufferedContent() {
		return new BufferedInputStream(contentStream());
	}

	public String content() throws IOException {
		if ((this.content == null) && (this.inputStream != null)) {
			byte[] b = new byte[65536];
			StringBuilder sb = new StringBuilder();
			int len = 0;
			while (-1 != (len = this.inputStream.read(b))) {
				sb.append(new String(b, 0, len));
			}
			this.inputStream.close();
			this.content = sb.toString();
		}
		return this.content;
	}
}
