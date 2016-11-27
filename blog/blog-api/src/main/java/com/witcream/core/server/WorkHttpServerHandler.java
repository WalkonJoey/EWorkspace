package com.witcream.core.server;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.witcream.core.WorkXml;
import com.witcream.util.StringUtil;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderUtil;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;

public class WorkHttpServerHandler extends SimpleChannelInboundHandler<Object> {
	private static final Logger LOG = LoggerFactory.getLogger(WorkHttpServerHandler.class);
	private HttpRequest request;

	protected void messageReceived(ChannelHandlerContext ctx, Object msg) throws Exception {
		if ((msg instanceof HttpRequest)) {
			HttpRequest request = this.request = (FullHttpRequest) msg;
			if (!request.decoderResult().isSuccess()) {
				sendError(ctx);
				return;
			}
			if (LOG.isInfoEnabled()) {
				CharSequence ip = (CharSequence) request.headers().get("X-Forwarded-For");

				String referer = StringUtil.isNotBlank(ip) ? ip.toString()
						: ((InetSocketAddress) ctx.channel().remoteAddress()).getAddress().getHostAddress();
				LOG.info(String.format("[%15s][%60s]", new Object[] { "Uri", request.uri() }));
				LOG.info(String.format("[%15s][%60s]", new Object[] { "Referer", referer }));
				LOG.info(String.format("[%15s][%60s]", new Object[] { "Method", request.method() }));
				LOG.info(String.format("[%15s][%60s]", new Object[] { "ProtocolVersion", request.protocolVersion() }));
				List<Entry<CharSequence, CharSequence>> entries = request.headers().entries();
				for (Entry<CharSequence, CharSequence> entry : entries) {
					LOG.info(String.format("[%15s][%60s]", new Object[] { entry.getKey(), entry.getValue() }));
				}
			}
		}
		WorkXml respXml = null;
		if ((msg instanceof HttpContent)) {
			HttpContent httpContent = (HttpContent) msg;
			ByteBuf content = httpContent.content();
			String entity = null;
			if (content.isReadable()) {
				entity = content.toString(CharsetUtil.UTF_8);
				if (LOG.isDebugEnabled()) {
					LOG.debug("==> Request : " + entity);
				}
			}
			if (StringUtil.isNotBlank(entity)) {
				WorkXmlService openService = new WorkXmlService(entity);
				long start = System.currentTimeMillis();
				respXml = openService.service();
				LOG.debug("\n { Service executed in {} msec. }", Long.valueOf(System.currentTimeMillis() - start));
			}
		}
		if (Objects.nonNull(respXml)) {
			writeResponse(respXml, ctx);
		} else {
			sendError(ctx);
		}
	}

	private void sendError(ChannelHandlerContext ctx) {
		boolean keepAlive = HttpHeaderUtil.isKeepAlive(this.request);

		FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST,
				ctx.alloc().buffer().writeBytes("<error />".getBytes(CharsetUtil.UTF_8)));
		if (LOG.isDebugEnabled()) {
			LOG.debug("==> ERR Respond: <error />");
		}
		if (keepAlive) {
			response.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
		}
		ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
	}

	private void writeResponse(WorkXml respXml, ChannelHandlerContext ctx) {
		boolean keepAlive = HttpHeaderUtil.isKeepAlive(this.request);

		FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
				ctx.alloc().buffer().writeBytes(respXml.toString().getBytes(CharsetUtil.UTF_8)));

		response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain; charset=UTF-8");
		if (keepAlive) {
			response.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
		}
		ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
	}

	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.flush();
	}

	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		if (LOG.isErrorEnabled()) {
			LOG.error("channel context exception", cause);
		}
		ctx.close();
	}
}
