package com.witcream.blog.api.exception;

public class BlogContentException extends RuntimeException {
	private static final long serialVersionUID = -6761959840068520735L;
	
	public BlogContentException(String message) {
		super(message);
	}
	public BlogContentException(String message, Throwable cause) {
		super(message, cause);
	}
}
