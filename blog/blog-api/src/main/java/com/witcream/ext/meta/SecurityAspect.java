package com.witcream.ext.meta;

import com.alibaba.fastjson.JSON;
import com.witcream.core.R;
import com.witcream.ext.web.CacheRequestWrapper;
import com.witcream.ext.web.WebWrapperHolder;
import com.witcream.util.Loggers;
import com.witcream.util.StringUtil;
import com.witcream.util.codec.MD5;

import java.util.Objects;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {
	private static final Logger logger = Loggers.getLogger();
	private String securityKey = "Mai$Xian";
	private TokenManager tokenManager;

	@Around("within(*) && @annotation(security)")
	public Object aroundMethod(ProceedingJoinPoint point, Security security) throws Throwable {
		StringBuffer sb = new StringBuffer();
		sb.append("\n");

		sb.append("\t").append("Security ==>").append("\n");
		boolean needKey = security.key();
		boolean needToken = security.token();
		String schema = security.schema();

		sb.append("\t").append("key:" + needKey).append(", ").append("token:" + needToken).append(", ")
				.append("schema:" + schema).append("\n");

		CacheRequestWrapper request = WebWrapperHolder.getRequestWrapper();
		String token = "";
		if (needToken) {
			token = request.getHeader("X-Token");
			if ((StringUtil.isBlank(token)) || (!this.tokenManager.verify(token))) {
				R r = R.FAIL("9970", "ILLEGAL_SESSION");
				sb.append("\t").append("result:").append(JSON.toJSONString(r)).append("\n");
				return r;
			}
		}
		byte[] bytes = request.getContent();
		String content = new String(bytes);
		if (needKey) {
			String key = request.getHeader("X-Key");
			if ((StringUtil.isBlank(key)) || (!MD5.md5(MD5.md5(content) + this.securityKey).equals(key))) {
				R r = R.FAIL("406", "ILLEGAL_SIGN");
				sb.append("\t").append("result:").append(JSON.toJSONString(r)).append("\n");
				return r;
			}
		}
		org.json.JSONObject reqObj = new org.json.JSONObject(StringUtil.isBlank(content) ? "{}" : content);

		sb.append("\t").append("Request -> ").append(reqObj).append("\n");

		Object[] args = point.getArgs();
		MethodSignature ms = (MethodSignature) point.getSignature();
		Class<?>[] types = ms.getParameterTypes();
		int i;
		if (Objects.nonNull(types)) {
			for (i = 0; i < types.length; i++) {
				if ((types[i].equals(com.alibaba.fastjson.JSONObject.class)) && (Objects.isNull(args[i]))) {
					args[i] = new com.alibaba.fastjson.JSONObject();
				}
			}
		}
		if (Objects.nonNull(args)) {
			for (Object arg : args) {
				if ((arg instanceof com.alibaba.fastjson.JSONObject)) {
					com.alibaba.fastjson.JSONObject body = (com.alibaba.fastjson.JSONObject) arg;
					body.put("$city_id", request.getHeader("X-City"));
					body.put("$prov_id", request.getHeader("X-Prov"));
					body.put("$terminal", request.getHeader("X-Terminal"));

					reqObj.put("$city_id", request.getHeader("X-City"));
					reqObj.put("$prov_id", request.getHeader("X-Prov"));
					reqObj.put("$terminal", request.getHeader("X-Terminal"));
					if (!needToken) {
						break;
					}
					CustomTokenManager customTokenManager = (CustomTokenManager) this.tokenManager;
					String subject = customTokenManager.subject(token);
					if ((StringUtil.isBlank(token)) || (StringUtil.isBlank(subject))) {
						R r = R.FAIL("9970", "ILLEGAL_SESSION");
						sb.append("\t").append("Result -> ").append(JSON.toJSONString(r)).append("\n");
						return r;
					}
					com.alibaba.fastjson.JSONObject subObj = com.alibaba.fastjson.JSONObject.parseObject(subject);
					body.put("$mem_id", subObj.getString("mem_id"));
					body.put("$account", subObj.getString("account"));

					reqObj.put("$mem_id", subObj.getString("mem_id"));
					reqObj.put("$account", subObj.getString("account"));

					break;
				}
			}
		}
		if (StringUtil.isNotBlank(schema)) {
			org.json.JSONObject rawSchema = new org.json.JSONObject(new JSONTokener(schema));
			Schema loadSchema = SchemaLoader.load(rawSchema);
			try {
				loadSchema.validate(reqObj);
			} catch (ValidationException e) {
				logger.error(e.getMessage(), e);
				R r = R.FAIL("10000", "ILLEGAL_PARAMETER[" + e.getMessage() + "]");
				sb.append("\t").append("result:").append(JSON.toJSONString(r)).append("\n");
				return r;
			}
		}
		sb.append("\t").append("Reward -> ").append(reqObj).append("\n");

		Object result = point.proceed(args);

		sb.append("\t").append("Result -> ").append(JSON.toJSONString(result)).append("\n");
		return result;
	}

	public void setSecurityKey(String securityKey) {
		this.securityKey = securityKey;
	}

	public void setTokenManager(TokenManager tokenManager) {
		this.tokenManager = tokenManager;
	}
}
