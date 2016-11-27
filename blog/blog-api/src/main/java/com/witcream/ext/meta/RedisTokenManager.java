package com.witcream.ext.meta;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.witcream.util.Loggers;
import com.witcream.util.codec.Base64;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Calendar;
import java.util.Map;
import org.slf4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisTokenManager implements TokenManager {
	static final Logger logger = Loggers.getLogger() ;
	private String base64Salt;
	private int timeout;
	private JedisPool jedisPool;

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	public void setBase64Salt(String base64Salt) {
		this.base64Salt = base64Salt;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public String builder(Map<String, Object> subject) {
		logger.debug("Token Builder...");
		JSONObject jsonObject = new JSONObject();
		jsonObject.putAll(subject);
		Calendar nowCal = Calendar.getInstance();
		nowCal.add(13, this.timeout);
		String xToken = Jwts.builder().setSubject(jsonObject.toJSONString())
				.signWith(SignatureAlgorithm.HS512, this.base64Salt).setExpiration(nowCal.getTime()).compact();
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
		JSONObject subject = null;
		String setKey = "";
		try {
			subject = JSON.parseObject(
					((Claims) Jwts.parser().setSigningKey(this.base64Salt).parseClaimsJws(xToken).getBody())
							.getSubject());
			setKey = subject.getString("mem_id");
		} catch (Exception e) {
			if ((xToken == null) || (xToken.indexOf(".") == -1)) {
				return;
			}
			subject = JSON.parseObject(new String(Base64.decodeFast(xToken.split("\\.")[1])));
			setKey = JSON.parseObject(subject.getString("sub")).getString("mem_id");
		}
		Jedis jedis = this.jedisPool.getResource();
		long deleteCount = jedis.del(xToken).longValue();
		logger.debug("Token Remove {}, {}", Long.valueOf(deleteCount), xToken);
		long updateCount = jedis.srem(setKey, new String[] { xToken }).longValue();
		logger.debug("Token Remove {}, {}", Long.valueOf(updateCount), setKey);
		jedis.close();
	}

	public String update(String xToken) {
		try {
			JSONObject subject = JSON.parseObject(
					((Claims) Jwts.parser().setSigningKey(this.base64Salt).parseClaimsJws(xToken).getBody())
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
}
