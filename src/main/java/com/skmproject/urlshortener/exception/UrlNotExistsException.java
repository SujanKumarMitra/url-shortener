package com.skmproject.urlshortener.exception;

public class UrlNotExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UrlNotExistsException() {
		super();
	}

	public UrlNotExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UrlNotExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public UrlNotExistsException(String message) {
		super(message);
	}

	public UrlNotExistsException(Throwable cause) {
		super(cause);
	}

}
