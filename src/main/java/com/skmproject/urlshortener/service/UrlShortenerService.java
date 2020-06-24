package com.skmproject.urlshortener.service;

import com.skmproject.urlshortener.exception.UrlNotExistsException;
import com.skmproject.urlshortener.model.UrlInfo;

/**
 * Performs operation related to url shortening and obtaining orginal url from hash
 * @author Sujan Kumar Mitra
 *
 */
public interface UrlShortenerService {
	
	/**
	 * Returns UrlInfo containing hash of url passed
	 * @param url the url to shorten
	 * @return {@link UrlInfo}
	 */
	UrlInfo getShortenedUrl(String url);
	
	/**
	 * Returns UrlInfo containing original url of the hash value
	 * @param url the hashed url
	 * @return {@link UrlInfo}
	 * @throws UrlNotExistsException if hash is not found
	 */
	UrlInfo getOrginalUrl(String url) throws UrlNotExistsException;

}
