package com.skmproject.urlshortener.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.WebRequest;

@Configuration
public class RestErrorResponseConfig {

	@Bean
	public ErrorAttributes errorAttributes() {
		return new DefaultErrorAttributes() {

			@Override
			public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
				Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);

				Map<String, Object> myErrorAttributes = new LinkedHashMap<>();
				myErrorAttributes.put("status", "error");
				myErrorAttributes.put("message", errorAttributes.get("error"));
				myErrorAttributes.put("data", null);

				return myErrorAttributes;
			}
		};
	}
}
