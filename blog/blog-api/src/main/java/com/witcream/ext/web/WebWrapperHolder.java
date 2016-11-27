package com.witcream.ext.web;

public class WebWrapperHolder {
	private static ThreadLocal<CacheRequestWrapper> requestWrapperHolder = new ThreadLocal<CacheRequestWrapper>();
	private static ThreadLocal<ServletResponseWrapper> responseWrapperHolder = new ThreadLocal<ServletResponseWrapper>();

	public static void hold(CacheRequestWrapper request, ServletResponseWrapper response) {
		requestWrapperHolder.set(request);
		responseWrapperHolder.set(response);
	}

	public static void release() {
		requestWrapperHolder.remove();
		responseWrapperHolder.remove();
	}

	public static CacheRequestWrapper getRequestWrapper() {
		return (CacheRequestWrapper) requestWrapperHolder.get();
	}

	public static ServletResponseWrapper getResponseWrapper() {
		return (ServletResponseWrapper) responseWrapperHolder.get();
	}
}
