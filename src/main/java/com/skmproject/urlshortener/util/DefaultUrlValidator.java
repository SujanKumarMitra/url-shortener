package com.skmproject.urlshortener.util;

import java.util.regex.Pattern;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class DefaultUrlValidator implements UrlValidator {

	private final String regex = "^((https?|ftp|smtp):\\/\\/)?(www.)?[a-z0-9]+(\\.[a-z]{2,}){1,3}(#?\\/?[a-zA-Z0-9#]+)*\\/?(\\?[a-zA-Z0-9-_]+=[a-zA-Z0-9-%]+&?)?$";

	@Override
	public boolean isUrlValid(@NonNull String url) {
		return Pattern.matches(regex, url);
	}

}
