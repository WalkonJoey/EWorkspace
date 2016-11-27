package com.witcream.ext.meta;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.witcream.core.R;
import com.witcream.util.Loggers;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DisplayAspect implements Ordered {
	static final Logger logger = Loggers.getLogger();;
	private int customOrder;

	@Around("within(*) && @annotation(display)")
	public Object execute(ProceedingJoinPoint point, Display display) {
		StringBuffer buf = new StringBuffer("\n\n");
		try {
			buf.append(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
					.append("\n");

			buf.append(display.value()).append("\n");
			buf.append("Params:").append("\n").append("\t").append(Arrays.toString(point.getArgs())).append("\n");
			long time = System.currentTimeMillis();
			Object result = point.proceed();
			time = System.currentTimeMillis() - time;
			buf.append("Result:").append("\n").append("\t").append(
					JSON.toJSONString(result, new SerializerFeature[] { SerializerFeature.WriteDateUseDateFormat }))
					.append("\n");
			buf.append("Time:  ").append(time).append("ms").append("\n");

			buf.append("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<")
					.append("\n");
			logger.info(buf.toString());
			return result;
		} catch (Throwable e) {
			logger.error(display.value(), e);
		}
		return R.FAIL("SERVICE_BUSY");
	}

	public int getOrder() {
		return getCustomOrder();
	}

	public void setCustomOrder(int customOrder) {
		this.customOrder = customOrder;
	}

	public int getCustomOrder() {
		return this.customOrder;
	}
}
