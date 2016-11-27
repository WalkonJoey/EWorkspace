package com.witcream.core.server;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

public class WorkHttpServerInitializer
  extends ChannelInitializer<SocketChannel>
{
  public void initChannel(SocketChannel ch)
  {
    ChannelPipeline p = ch.pipeline();
    p.addLast(new ChannelHandler[] { new HttpRequestDecoder() });
    
    p.addLast(new ChannelHandler[] { new HttpObjectAggregator(1048576) });
    p.addLast(new ChannelHandler[] { new HttpResponseEncoder() });
    
    p.addLast(new ChannelHandler[] { new HttpContentCompressor() });
    p.addLast(new ChannelHandler[] { new ChunkedWriteHandler() });
    p.addLast(new ChannelHandler[] { new WorkHttpServerHandler() });
  }
}