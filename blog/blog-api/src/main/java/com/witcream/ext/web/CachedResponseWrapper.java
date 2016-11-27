package com.witcream.ext.web;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CachedResponseWrapper extends HttpServletResponseWrapper {
	public static final int OUTPUT_NONE = 0;
	public static final int OUTPUT_WRITER = 1;
	public static final int OUTPUT_STREAM = 2;
	private int outputType = 0;
	private int status = 200;
	private ServletOutputStream output = null;
	private PrintWriter writer = null;
	private ByteArrayOutputStream buffer = null;

	public CachedResponseWrapper(HttpServletResponse response) {
		super(response);
		this.buffer = new ByteArrayOutputStream();
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		super.setStatus(status);
	}

	public void sendError(int status, String string) throws IOException {
		super.sendError(status, string);
		this.status = status;
	}

	public void sendError(int status) throws IOException {
		super.sendError(status);
		this.status = status;
	}

	public void sendRedirect(String location) throws IOException {
		super.sendRedirect(location);
		this.status = 302;
	}

	public PrintWriter getWriter() throws IOException {
		if (this.outputType == 2) {
			throw new IllegalStateException();
		}
		if (this.outputType == 1) {
			return this.writer;
		}
		this.outputType = 1;
		this.writer = new PrintWriter(new OutputStreamWriter(this.buffer, getCharacterEncoding()));
		return this.writer;
	}

	public ServletOutputStream getOutputStream() throws IOException {
		if (this.outputType == 1) {
			throw new IllegalStateException();
		}
		if (this.outputType == 2) {
			return this.output;
		}
		this.outputType = 2;
		this.output = new WrappedOutputStream(this.buffer);
		return this.output;
	}

	public void flushBuffer() throws IOException {
		if (this.outputType == 1) {
			this.writer.flush();
		}
		if (this.outputType == 2) {
			this.output.flush();
		}
	}

	public void reset() {
		this.outputType = 0;
		this.buffer.reset();
	}

	public byte[] getResponseData() throws IOException {
		flushBuffer();
		return this.buffer.toByteArray();
	}

	class WrappedOutputStream extends ServletOutputStream {
		private ByteArrayOutputStream buffer;

		public WrappedOutputStream(ByteArrayOutputStream buffer) {
			this.buffer = buffer;
		}

		public void write(int b) throws IOException {
			this.buffer.write(b);
		}

		public byte[] toByteArray() {
			return this.buffer.toByteArray();
		}

		public boolean isReady() {
			return false;
		}

		public void setWriteListener(WriteListener writeListener) {
		}
	}
}
