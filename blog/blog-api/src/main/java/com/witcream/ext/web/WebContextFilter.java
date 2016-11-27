package com.witcream.ext.web;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.Objects;

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

public class WebContextFilter
  implements Filter
{
  static final Logger logger = LoggerFactory.getLogger(WebContextFilter.class);
  
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
    throws IOException, ServletException
  {
    logger.debug("WebContextFilter doFilter...");
    HttpServletRequest request = (HttpServletRequest)servletRequest;
    HttpServletResponse response = (HttpServletResponse)servletResponse;
    CacheRequestWrapper requestWrapper = new CacheRequestWrapper(request);
    ServletResponseWrapper responseWrapper = new ServletResponseWrapper(response);
    WebWrapperHolder.hold(requestWrapper, responseWrapper);
    try
    {
      if (request.getRequestURI().contains(".")) {
        return;
      }
      chain.doFilter(requestWrapper, responseWrapper);
      OutputStream out = response.getOutputStream();
      out.write(responseWrapper.getBuffer().toByteArray());
      out.flush();
      out.close();
    }
    finally
    {
      display(requestWrapper, responseWrapper);
      WebWrapperHolder.release();
    }
  }
  
  static void display(CacheRequestWrapper request, ServletResponseWrapper response)
  {
    if (logger.isDebugEnabled())
    {
      StringBuffer sb = new StringBuffer();
      
      sb.append("\n\n").append(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>").append("\n");
      sb.append("HTTP : \n");
      sb.append("Request Remote:").append("\n")
        .append("\t").append(getRemoteAddr(request)).append("\n");
      sb.append("Request URL:").append("\n")
        .append("\t").append(request.getMethod()).append(",").append(request.getRequestURL()).append("\n");
      Enumeration<String> names = request.getHeaderNames();
      sb.append("Request Headers:").append("\n");
      while (names.hasMoreElements())
      {
        String name = (String)names.nextElement();
        sb.append("\t").append(name).append(":").append(request.getHeader(name)).append("\n");
      }
      names = request.getParameterNames();
      sb.append("Request Parameters:").append("\n");
      while (names.hasMoreElements())
      {
        String name = (String)names.nextElement();
        sb.append("\t").append(name).append(":").append(request.getParameter(name)).append("\n");
      }
      sb.append("Request Content:").append("\n");
      byte[] reqBytes = request.getContent();
      if ((Objects.nonNull(reqBytes)) && (reqBytes.length != 0)) {
        sb.append("\t").append(new String(reqBytes, Charset.forName(request.getCharacterEncoding()))).append("\n");
      }
      byte[] respBytes = response.getBuffer().toByteArray();
      String respText = new String(respBytes, Charset.forName(response.getCharacterEncoding()));
      sb.append("Response Content:").append("\n")
        .append("\t").append(respText);
      sb.append("\n").append("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<").append("\n\n");
      
      logger.debug(sb.toString());
    }
  }
  
  private static String getRemoteAddr(HttpServletRequest request)
  {
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
  
  public void init(FilterConfig filterConfig)
    throws ServletException
  {
    logger.debug("WebContextFilter init...");
  }
  
  public void destroy()
  {
    logger.debug("WebContextFilter destroy...");
  }
}

