package com.witcream.core.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class WorkHttpServer
{
  private static final Logger logger = LoggerFactory.getLogger(WorkHttpServer.class);
  private final String host;
  private final int port;
  
  public WorkHttpServer(String host, int port)
  {
    this.host = host;
    this.port = port;
  }
  
  public void run()
    throws Exception
  {
    EventLoopGroup bossGroup = new NioEventLoopGroup(1);
    EventLoopGroup workerGroup = new NioEventLoopGroup();
    try
    {
      ServerBootstrap b = new ServerBootstrap();
      
      ((ServerBootstrap)((ServerBootstrap)((ServerBootstrap)((ServerBootstrap)((ServerBootstrap)((ServerBootstrap)b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)).handler(new LoggingHandler(LogLevel.INFO))).childHandler(new WorkHttpServerInitializer()).option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)).option(ChannelOption.SO_BACKLOG, Integer.valueOf(128))).option(ChannelOption.SO_RCVBUF, Integer.valueOf(262144))).option(ChannelOption.SO_SNDBUF, Integer.valueOf(262144)))
        .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
        .childOption(ChannelOption.SO_KEEPALIVE, Boolean.valueOf(true))
        .childOption(ChannelOption.CONNECT_TIMEOUT_MILLIS, Integer.valueOf(10000))
        .childOption(ChannelOption.TCP_NODELAY, Boolean.valueOf(true));
      
      Channel ch = b.bind(this.port).sync().channel();
      if (logger.isDebugEnabled()) {
        logger.debug("The server is run [ http://" + this.host + ":" + this.port + "/ ]");
      }
      ch.closeFuture().sync();
    }
    finally
    {
      bossGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }
  }
}
