package com.skmproject.urlshortener.dto;

import java.util.Map;

import com.skmproject.urlshortener.util.DefaultRestResponseBuilder;

public class DefaultRestResponse implements RestResponse {
	private String status;
	private String message;
	private Map<String, Object> data;

	@Override
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public Map<String, Object> getData() {
		return this.data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public static DefaultRestResponseBuilder builder() {
		return new DefaultRestResponseBuilder();
	}

}
