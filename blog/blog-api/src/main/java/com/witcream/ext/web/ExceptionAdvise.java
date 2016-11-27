package com.witcream.ext.web;


import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.witcream.util.Loggers;

@ControllerAdvice
@ResponseBody
public class ExceptionAdvise
{
  Logger logger = Loggers.getLogger();
  
  @ResponseStatus(HttpStatus.OK)
  @ExceptionHandler({Exception.class})
  public Object handleException(Exception e)
  {
    this.logger.error("系统繁忙, " + e.getMessage(), e);
    return "{\"meta\":{\"code\":\"998\", \"msg\": \"系统繁忙\"}}";
  }
}
