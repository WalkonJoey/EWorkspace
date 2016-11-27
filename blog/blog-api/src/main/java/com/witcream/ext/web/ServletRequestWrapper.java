package com.witcream.ext.web;

import com.alibaba.fastjson.JSONObject;
import com.witcream.util.IOUtil;
import com.witcream.util.StringUtil;
import com.witcream.util.codec.MD5;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map.Entry;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServletRequestWrapper extends HttpServletRequestWrapper {
	private static final Logger logger = LoggerFactory.getLogger(ServletRequestWrapper.class);
	private final byte[] wrapPayload;
	private final boolean isVerify;
	private final String encryptSalt;

	public ServletRequestWrapper(HttpServletRequest request) throws IOException {
		super(request);
		this.isVerify = ((Boolean) request.getAttribute("$isVerify")).booleanValue();
		this.encryptSalt = ((String) request.getAttribute("$encryptSalt"));
		InputStream in = request.getInputStream();
		String payload = IOUtil.toString(in);
		IOUtil.close(in);
		JSONObject wrapJson = new JSONObject();
		wrapJson.put("payload", JSONObject.parseObject(payload));
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			logger.debug("{} | {} | {}", new Object[] { "headerName",
					String.format("%18s", new Object[] { headerName }), request.getHeader(headerName) });
			if (headerName.toUpperCase().startsWith("X-")) {
				if (headerName.equalsIgnoreCase("X-Token")) {
					String webToken = request.getHeader(headerName);
					if (StringUtil.isNotBlank(webToken)) {
						try {
							String subject = ((Claims) Jwts.parser().setSigningKey("Y29tLm1haXhpYW4uYXBwLk1haSRYaWFu")
									.parseClaimsJws(webToken).getBody()).getSubject();
							logger.debug("{} | {}", "Subject", subject);
							JSONObject subjectJson = JSONObject.parseObject(subject);
							for (Entry<String, Object> entry : subjectJson.entrySet()) {
								wrapJson.put((String) entry.getKey(), entry.getValue());
							}
						} catch (Exception e) {
							logger.warn("token parser execption, {}", e.getMessage());
						}
					}
				}
				wrapJson.put(StringUtil.startUppper(headerName, 3), request.getHeader(headerName));
			}
		}
		if (this.isVerify) {
			wrapJson.put("X-Key", MD5.md5(MD5.md5(payload) + this.encryptSalt));
		}
		this.wrapPayload = wrapJson.toJSONString().getBytes();
	}

	public ServletInputStream getInputStream() throws IOException {
		final ByteArrayInputStream in = new ByteArrayInputStream(this.wrapPayload);

		int todo;
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
}
