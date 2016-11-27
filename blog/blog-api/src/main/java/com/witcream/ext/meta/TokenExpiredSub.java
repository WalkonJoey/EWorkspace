package com.witcream.ext.meta;


import org.slf4j.Logger;

import com.witcream.util.Loggers;

import redis.clients.jedis.JedisPubSub;

public class TokenExpiredSub
  extends JedisPubSub
{
  static final Logger logger = Loggers.getLogger();
  TokenManager tokenManager;
  
  public void setTokenManager(TokenManager tokenManager)
  {
    this.tokenManager = tokenManager;
  }
  
  public void onPMessage(String pattern, String channel, String message)
  {
    logger.debug("==> onPMessage, Pattern: {}, Channel: {}, Message: {}", new Object[] { pattern, channel, message });
    this.tokenManager.remove(message);
  }
}
