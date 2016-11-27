package com.witcream.ext.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.witcream.util.CollectionUtil;
import com.witcream.util.StringUtil;

public class CorsFilter implements Filter {
	private String allowOrigin;
	private String allowMethods;
	private String allowCredentials;
	private String allowHeaders;
	private String exposeHeaders;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.allowOrigin = filterConfig.getInitParameter("allowOrigin");
		this.allowMethods = filterConfig.getInitParameter("allowMethods");
		this.allowCredentials = filterConfig.getInitParameter("allowCredentials");
		this.allowHeaders = filterConfig.getInitParameter("allowHeaders");
		this.exposeHeaders = filterConfig.getInitParameter("exposeHeaders");
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		if (StringUtil.isNotBlank(this.allowOrigin)) {
			List<String> allowOriginList = Arrays.asList(this.allowOrigin.split(","));
			if (CollectionUtil.isNotEmpty(allowOriginList)) {
				String currentOrigin = request.getHeader("Origin");
				if (allowOriginList.contains(currentOrigin)) {
					response.setHeader("Access-Control-Allow-Origin", currentOrigin);
				}
			}
		} else {
			response.setHeader("Access-Control-Allow-Origin", "*");
		}
		if (StringUtil.isNotBlank(this.allowMethods)) {
			response.setHeader("Access-Control-Allow-Methods", this.allowMethods);
		}
		if (StringUtil.isNotBlank(this.allowCredentials)) {
			response.setHeader("Access-Control-Allow-Credentials", this.allowCredentials);
		}
		if (StringUtil.isNotBlank(this.allowHeaders)) {
			response.setHeader("Access-Control-Allow-Headers", this.allowHeaders);
		}
		if (StringUtil.isNotBlank(this.exposeHeaders)) {
			response.setHeader("Access-Control-Expose-Headers", this.exposeHeaders);
		}
		chain.doFilter(req, res);
	}

	public void destroy() {
	}
}
