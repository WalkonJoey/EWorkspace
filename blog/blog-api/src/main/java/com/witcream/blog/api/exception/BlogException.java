package com.witcream.blog.api.exception;

public class BlogException extends RuntimeException {
	private static final long serialVersionUID = -6761959840068520735L;
	
	public BlogException(String message) {
		super(message);
	}
	public BlogException(String message, Throwable cause) {
		super(message, cause);
	}
}
