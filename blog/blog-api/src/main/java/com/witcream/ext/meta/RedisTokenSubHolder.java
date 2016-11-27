package com.witcream.ext.meta;

import org.slf4j.Logger;
import com.witcream.util.Loggers;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisTokenSubHolder {
	private static final Logger logger = Loggers.getLogger();

	private final JedisPool jedisPool;
	TokenExpiredSub tokenExpiredSub;

	public void init() {
		logger.debug("RedisTokenSubHolder init...");
		logger.debug("jedisPool: " + jedisPool);
		new Thread(new Runnable() {
			@Override
			public void run() {
				Jedis jedis = jedisPool.getResource();
				jedis.psubscribe(tokenExpiredSub, "*");
				jedis.close();
			}
		}).start();
	}

	public RedisTokenSubHolder(JedisPool jedisPool, TokenExpiredSub tokenExpiredSub) {
		this.jedisPool = jedisPool;
		this.tokenExpiredSub = tokenExpiredSub;
	}
}
