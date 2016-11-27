package com.witcream.ext.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebCtx {
	private static ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();
	private static ThreadLocal<HttpServletResponse> responseHolder = new ThreadLocal<HttpServletResponse>();

	public static void hold(HttpServletRequest request, HttpServletResponse response) {
		requestHolder.set(request);
		responseHolder.set(response);
	}

	public static void release() {
		requestHolder.remove();
		responseHolder.remove();
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) requestHolder.get();
	}

	public static HttpServletResponse getResponse() {
		return (HttpServletResponse) responseHolder.get();
	}
}
