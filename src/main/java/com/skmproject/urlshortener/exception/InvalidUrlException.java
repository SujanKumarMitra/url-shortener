package com.skmproject.urlshortener.exception;

public class InvalidUrlException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidUrlException() {
		super();
	}

	public InvalidUrlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidUrlException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidUrlException(String message) {
		super(message);
	}

	public InvalidUrlException(Throwable cause) {
		super(cause);
	}
	

}
