package com.skmproject.urlshortener.util;

/**
 * Used to check whether an given url is a valid or not
 * 
 * @author Sujan Kumar Mitra
 *
 */
public interface UrlValidator {
	/**
	 * Returns url is valid not
	 * @param url url to validate
	 * @return {@code true} is valid, else {@code false}
 	 */
	boolean isUrlValid(String url);
}
