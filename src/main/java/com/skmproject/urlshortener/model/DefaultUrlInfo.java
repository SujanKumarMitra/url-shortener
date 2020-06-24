package com.skmproject.urlshortener.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
public class DefaultUrlInfo implements UrlInfo{
	
	@Id
	String encodedUrl;
	String originalUrl;
	String link;
	
	public DefaultUrlInfo() {
	}
	
	public DefaultUrlInfo(String originalUrl, String encodedUrl,String link) {
		this.originalUrl = originalUrl;
		this.encodedUrl = encodedUrl;
		this.link = link;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public void setEncodedUrl(String encodedUrl) {
		this.encodedUrl = encodedUrl;
	}

	@Override
	public String getOriginalUrl() {
		return originalUrl;
	}

	@Override
	public String getEncodedUrl() {
		return encodedUrl;
	}

	@Override
	public String getLink() {
		return link;
	}

}
