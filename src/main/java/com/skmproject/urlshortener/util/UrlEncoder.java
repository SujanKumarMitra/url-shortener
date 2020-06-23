package com.skmproject.urlshortener.util;

/**
 * This interface handles the encoding and decoding of strings
 * 
 * @author Sujan Kumar Mitra
 *
 */
public interface UrlEncoder {

	/**
	 * Returns the encoded string
	 * 
	 * @param arg the string to encode
	 * @return the encoded string
	 */
	String encode(String arg);
}
