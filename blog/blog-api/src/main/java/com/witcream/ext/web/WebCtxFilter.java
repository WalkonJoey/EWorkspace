package com.witcream.ext.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.witcream.core.R;
import com.witcream.util.GzipUtil;
import com.witcream.util.IOUtil;
import com.witcream.util.StringUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebCtxFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(WebCtxFilter.class);
	private String encryptSalt = "";
	private boolean isVerify = false;
	private Set<String> excludeUrls = new HashSet<String>();
	private boolean compressEnabled = false;
	private int minResponseSize = 2048;
	private List<String> mimeTypes = Arrays
			.asList(new String[] { "application/json", "application/xml", "text/html", "text/xml", "text/plain" });

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		if (this.excludeUrls.contains(((HttpServletRequest) servletRequest).getRequestURI())) {
			excludeUrlsFilter(servletRequest, servletResponse, filterChain);
		} else {
			includeUrlsFilter(servletRequest, servletResponse, filterChain);
		}
	}

	private void excludeUrlsFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String methodName = request.getMethod();

		logger.info(String.format("[%15s][%60s]", new Object[] { "Referer", getRemoteAddr(request) }));
		logger.info(String.format("[%15s][%60s]", new Object[] { "URI", request.getRequestURI() }));
		logger.info(String.format("[%15s][%60s]", new Object[] { "Method", methodName }));

		WebCtx.hold(request, response);

		logger.info(String.format("[%15s][%60s]", new Object[] { "Content-Type", request.getContentType() }));
		logger.info(String.format("[%15s][%60s]",
				new Object[] { "Content-Length", Integer.valueOf(request.getContentLength()) }));
		String query = request.getQueryString();
		if (StringUtil.isNotBlank(query)) {
			logger.info(String.format("[%15s][%60s]", new Object[] { "Query", request.getQueryString() }));
		}
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		
		for (Iterator<String> iter = requestParams.keySet().iterator();iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = valueStr + values[i] + ",";
			}
			params.put(name, valueStr);
		}
		logger.info(String.format("[%15s][%60s]", new Object[] { "Content", JSON.toJSONString(params) }));
		try {
			filterChain.doFilter(request, response);
		} finally {
			WebCtx.release();
		}
	}

	private void includeUrlsFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String methodName = request.getMethod();

		logger.info(String.format("[%15s][%60s]", new Object[] { "Referer", getRemoteAddr(request) }));
		logger.info(String.format("[%15s][%60s]", new Object[] { "URI", request.getRequestURI() }));
		logger.info(String.format("[%15s][%60s]", new Object[] { "Method", methodName }));

		WebCtx.hold(request, response);

		logger.info(String.format("[%15s][%60s]", new Object[] { "Content-Type", request.getContentType() }));
		logger.info(String.format("[%15s][%60s]",
				new Object[] { "Content-Length", Integer.valueOf(request.getContentLength()) }));
		String query = request.getQueryString();
		if (StringUtil.isNotBlank(query)) {
			logger.info(String.format("[%15s][%60s]", new Object[] { "Query", request.getQueryString() }));
		}
		try {
			request.setAttribute("$isVerify", Boolean.valueOf(this.isVerify));
			request.setAttribute("$encryptSalt", this.encryptSalt);

			ServletRequestWrapper reqWrapper = new ServletRequestWrapper(request);
			CachedResponseWrapper respWrapper = new CachedResponseWrapper(response);

			InputStream in = reqWrapper.getInputStream();

			String wrapBody = IOUtil.toString(in);

			JSONObject wrapJson = JSONObject.parseObject(wrapBody);
			JSONObject jsonObject = wrapJson.getJSONObject("payload");
			String unwrapReqJson = jsonObject == null ? "" : jsonObject.toJSONString();
			if (this.isVerify) {
				String key = request.getHeader("X-Key");
				logger.info(String.format("[%15s][%60s]", new Object[] { "X-Key", key }));
				String newKey = wrapJson.getString("X-Key");
				if (!newKey.equals(key)) {
					logger.info(String.format("[%15s][%60s]", new Object[] { "Checked", "false" }));

					response.setStatus(200);
					PrintWriter writer = response.getWriter();
					writer.write(JSON.toJSONString(R.FAIL("406", "Permission denied")));
					writer.flush();
					writer.close();
					return;
				}
			}
			if (StringUtil.isNotBlank(unwrapReqJson)) {
				logger.info(String.format("[%15s][%60s]", new Object[] { "Payload", wrapBody }));
			}
			IOUtil.close(in);

			filterChain.doFilter(reqWrapper, respWrapper);
			byte[] resp = respWrapper.getResponseData();

			logger.info(String.format("[%15s][%60s]", new Object[] { "Respond URI", request.getRequestURI() }));
			logger.info(String.format("[%15s][%60s]", new Object[] { "Respond JSON", new String(resp) }));

			byte[] bytes = resp;
			if ((this.compressEnabled) && (resp.length > this.minResponseSize)
					&& (this.mimeTypes.contains(response.getContentType().split(";")[0].toLowerCase()))) {
				bytes = GzipUtil.compressToByte(resp);
				response.setHeader("Content-Encoding", "gzip");
			}
			response.setContentLength(bytes.length);

			OutputStream out = response.getOutputStream();
			out.write(bytes);
			out.flush();
		} finally {
			WebCtx.release();
		}
		WebCtx.release();
	}

	public void init(FilterConfig config) throws ServletException {
		String isVerify = config.getInitParameter("isVerify");
		String encryptSalt = config.getInitParameter("encryptSalt");
		String excludeUrls = config.getInitParameter("excludeUrls");
		String compressEnabled = config.getInitParameter("compressEnabled");
		String minResponseSize = config.getInitParameter("minResponseSize");
		if (StringUtil.isNotBlank(minResponseSize)) {
			this.minResponseSize = Integer.valueOf(minResponseSize).intValue();
		}
		this.compressEnabled = Boolean.valueOf(compressEnabled).booleanValue();
		this.isVerify = Boolean.valueOf(isVerify).booleanValue();
		if (StringUtil.isNotBlank(isVerify)) {
			this.encryptSalt = (StringUtil.isBlank(encryptSalt) ? "" : encryptSalt);
		}
		if (StringUtil.isNotBlank(excludeUrls)) {
			String[] arrayOfString;
			int j = (arrayOfString = excludeUrls.split(",")).length;
			for (int i = 0; i < j; i++) {
				String url = arrayOfString[i];
				this.excludeUrls.add(url.trim());
			}
		}
	}

	public void destroy() {
		this.encryptSalt = "";
		this.excludeUrls.clear();
		this.isVerify = false;
	}

	private String getRemoteAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
