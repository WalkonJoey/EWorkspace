package com.witcream.ext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextHolder
  implements ApplicationContextAware
{
  private static ApplicationContext applicationContext = null;
  
  public static Object getBean(String name)
  {
    return applicationContext.getBean(name);
  }
  
  public static <T> T getBean(String name, Class<T> clazz)
  {
    return (T)applicationContext.getBean(name, clazz);
  }
  
  public void setApplicationContext(ApplicationContext context)
    throws BeansException
  {
    applicationContext = context;
  }
  
  public static ApplicationContext getApplicationContext()
  {
    return applicationContext;
  }
}
