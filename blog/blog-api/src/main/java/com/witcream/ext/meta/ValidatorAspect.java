package com.witcream.ext.meta;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.witcream.core.R;
import com.witcream.util.Loggers;
import com.witcream.util.StringUtil;

@Aspect
@Component
public class ValidatorAspect
  implements Ordered
{
  private static final Logger logger = Loggers.getLogger();
  private int customOrder;
  
  @Around("within(*) && @annotation(validator)")
  public Object aroundMethod(ProceedingJoinPoint point, Validator validator)
    throws Throwable
  {
    String schema = validator.value();
    logger.debug("Schema: {}", schema);
    if (StringUtil.isNotBlank(schema))
    {
      com.alibaba.fastjson.JSONObject body = null;
      Object[] args = point.getArgs();
      for (Object arg : args) {
        if ((arg instanceof com.alibaba.fastjson.JSONObject))
        {
          body = (com.alibaba.fastjson.JSONObject)arg;
          break;
        }
      }
      org.json.JSONObject rawSchema = new org.json.JSONObject(new JSONTokener(schema));
      Schema loadSchema = SchemaLoader.load(rawSchema);
      try
      {
        loadSchema.validate(new org.json.JSONObject(body));
      }
      catch (ValidationException e)
      {
        logger.error(e.getMessage(), e);
        return R.FAIL("10000", "ILLEGAL_PARAMETER[" + e.getMessage() + "]");
      }
    }
    return point.proceed();
  }
  
  public int getOrder()
  {
    return getCustomOrder();
  }
  
  public void setCustomOrder(int customOrder)
  {
    this.customOrder = customOrder;
  }
  
  public int getCustomOrder()
  {
    return this.customOrder;
  }
}

