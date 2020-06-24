package com.skmproject.urlshortener.util;

import java.nio.charset.StandardCharsets;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import com.google.common.hash.Hashing;

@Component
public class DefaultUrlEncoder implements UrlEncoder {
	
	char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

	@Override
	public String encode(@NonNull String arg) {
		return Hashing.murmur3_32().hashString(arg, StandardCharsets.UTF_8).toString();
	}
	
	

}
