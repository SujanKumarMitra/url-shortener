package com.skmproject.urlshortener.util;

import java.util.HashMap;
import java.util.Map;

import com.skmproject.urlshortener.dto.DefaultRestResponse;
import com.skmproject.urlshortener.dto.RestResponse;

public class DefaultRestResponseBuilder {

	DefaultRestResponse response;

	public DefaultRestResponseBuilder() {
		response = new DefaultRestResponse();
	}

	public DefaultRestResponseBuilder status(String status) {
		response.setStatus(status);
		return this;
	}

	public DefaultRestResponseBuilder message(String message) {
		response.setMessage(message);
		return this;
	}

	public DefaultRestResponseBuilder data(Map<String, Object> data) {
		response.setData(data);
		return this;
	}

	public DefaultRestResponseBuilder withData(String key, Object value) {
		if(response.getData() == null) {
			response.setData(new HashMap<>());
		}
		response.getData().put(key, value);
		return this;
	}

	public RestResponse build() {
		return response;
	}

}
