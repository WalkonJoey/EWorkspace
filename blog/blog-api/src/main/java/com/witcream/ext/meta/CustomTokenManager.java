package com.witcream.ext.meta;

import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.witcream.util.Calendars;
import com.witcream.util.Loggers;
import com.witcream.util.StringUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class CustomTokenManager implements TokenManager {
	static final Logger logger = Loggers.getLogger();
	private String base64EncodedSecretKey;
	private int timeout;
	private JedisPool jedisPool;

	public String builder(Map<String, Object> subject) {
		logger.debug("Token Builder...");
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(subject);
		Calendar nowCal = Calendars.newInstance();
		nowCal.add(13, this.timeout);

		String xToken = Jwts.builder().setSubject(jsonObject.toJSONString())
				.signWith(SignatureAlgorithm.HS512, this.base64EncodedSecretKey).setExpiration(nowCal.getTime())
				.compact();
		Jedis jedis = this.jedisPool.getResource();
		jedis.set(xToken, JSON.toJSONString(subject));
		jedis.expire(xToken, this.timeout);
		jedis.sadd(subject.get("mem_id").toString(), new String[] { xToken });
		jedis.close();
		logger.debug("X-Token Builder: {}", xToken);
		return xToken;
	}

	public boolean verify(String xToken) {
		Jedis jedis = this.jedisPool.getResource();
		boolean exists = jedis.exists(xToken).booleanValue();
		logger.debug("Token Verify {}", Boolean.valueOf(exists));
		jedis.close();
		return exists;
	}

	public void remove(String xToken) {
		if (StringUtil.isBlank(xToken)) {
			return;
		}
		String[] strs = xToken.split("\\.");
		String base64UrlEncodedHeader = strs[0];
		String base64UrlEncodedPayload = strs[1];
		String base64UrlEncodedDigest = strs[2];
		try {
			Mac mac = Mac.getInstance("HmacSHA512");
			mac.init(new SecretKeySpec(TextCodec.BASE64.decode(this.base64EncodedSecretKey), "HmacSHA512"));
			String base64UrlWithoutSignture = base64UrlEncodedHeader + "." + base64UrlEncodedPayload;
			boolean isEqual = MessageDigest.isEqual(mac.doFinal(base64UrlWithoutSignture.getBytes()),
					TextCodec.BASE64URL.decode(base64UrlEncodedDigest));
			if (isEqual) {
				String payload = TextCodec.BASE64URL.decodeToString(base64UrlEncodedPayload);
				if ((payload.startsWith("{")) && (payload.endsWith("}"))) {
					JSONObject subject = JSONObject.parseObject(payload);
					if (subject.containsKey("sub")) {
						JSONObject content = subject.getJSONObject("sub");
						String setKey = content.getString("mem_id");
						Jedis jedis = this.jedisPool.getResource();
						long deleteCount = jedis.del(xToken).longValue();
						logger.debug("Token Remove {}, {}", Long.valueOf(deleteCount), xToken);
						long updateCount = jedis.srem(setKey, new String[] { xToken }).longValue();
						logger.debug("Token Remove {}, {}", Long.valueOf(updateCount), setKey);
						jedis.close();
					}
				}
			} else {
				return;
			}
		} catch (Exception localException) {
		}
	}

	public String update(String xToken) {
		if (StringUtil.isBlank(xToken)) {
			return null;
		}
		try {
			JSONObject subject = JSON.parseObject(
					((Claims) Jwts.parser().setSigningKey(this.base64EncodedSecretKey).parseClaimsJws(xToken).getBody())
							.getSubject());
			String token = builder(subject);
			Jedis jedis = this.jedisPool.getResource();
			jedis.del(xToken);
			jedis.srem(subject.getString("mem_id"), new String[] { xToken });
			jedis.close();
			return token;
		} catch (Exception e) {
		}
		return "";
	}

	public String subject(String xToken) {
		try {
			return ((Claims) Jwts.parser().setSigningKey(this.base64EncodedSecretKey).parseClaimsJws(xToken).getBody())
					.getSubject();
		} catch (Exception e) {
		}
		return null;
	}

	public String getBase64EncodedSecretKey() {
		return this.base64EncodedSecretKey;
	}

	public void setBase64EncodedSecretKey(String base64EncodedSecretKey) {
		this.base64EncodedSecretKey = base64EncodedSecretKey;
	}

	public int getTimeout() {
		return this.timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public JedisPool getJedisPool() {
		return this.jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}
}
