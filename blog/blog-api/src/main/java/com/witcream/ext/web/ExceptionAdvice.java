package com.witcream.ext.web;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.witcream.core.R;
import com.witcream.util.Loggers;

@ControllerAdvice
@ResponseBody
public class ExceptionAdvice
{
  private static Logger logger = Loggers.getLogger();
  
  @ResponseStatus(HttpStatus.OK)
  @ExceptionHandler({MissingServletRequestParameterException.class})
  public R handleMissingServletRequestParameterException(MissingServletRequestParameterException e)
  {
    Loggers.error("缺少请求参数|" + e.getMessage(), logger, e);
    return R.FAIL("900", "缺少请求参数");
  }
  
  @ResponseStatus(HttpStatus.OK)
  @ExceptionHandler({HttpMessageNotReadableException.class})
  public R handleHttpMessageNotReadableException(HttpMessageNotReadableException e)
  {
    Loggers.error("参数解析失败|" + e.getMessage(), logger, e);
    return R.FAIL("901", "参数解析失败");
  }
  
  @ResponseStatus(HttpStatus.OK)
  @ExceptionHandler({TokenException.class})
  public R handleTokenException(TokenException e)
  {
    Loggers.error("令牌验证失败|" + e.getMessage(), logger, e);
    return R.FAIL("903", "令牌验证失败");
  }
  
  @ResponseStatus(HttpStatus.OK)
  @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
  public R handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e)
  {
    Loggers.error("不支持的请求方法|" + e.getMessage(), logger, e);
    return R.FAIL("904", "不支持的请求方法");
  }
  
  @ResponseStatus(HttpStatus.OK)
  @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
  public R handleHttpMediaTypeNotSupportedException(Exception e)
  {
    Loggers.error("不支持当前媒体类型|" + e.getMessage(), logger, e);
    return R.FAIL("905", "不支持当前媒体类型");
  }
  
  @ResponseStatus(HttpStatus.OK)
  @ExceptionHandler({ServiceException.class})
  public R handleServiceException(ServiceException e)
  {
    Loggers.error("服务运行异常|" + e.getMessage(), logger, e);
    return R.FAIL("999", "服务运行异常");
  }
  
  @ResponseStatus(HttpStatus.OK)
  @ExceptionHandler({Exception.class})
  public R handleException(Exception e)
  {
    e.printStackTrace();
    Loggers.error("系统繁忙|" + e.getMessage(), logger, e);
    return R.FAIL("998", "系统繁忙");
  }
}
