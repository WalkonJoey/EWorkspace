package com.witcream.core;

public class WorkException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public WorkException() {
	}

	public WorkException(Throwable cause) {
		super(cause);
	}

	public WorkException(String message) {
		super(message);
	}

	public WorkException(String message, Throwable cause) {
		super(message, cause);
	}
}
