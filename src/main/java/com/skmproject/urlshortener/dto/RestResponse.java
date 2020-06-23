package com.skmproject.urlshortener.dto;

import java.util.Map;

/**
 * RESTful services should return response back to the client wrapped in this
 * object
 * 
 * @author Sujan Kumar Mitra
 *
 */
public interface RestResponse {

	/**
	 * Returns whether a request was successful or not
	 * 
	 * @return the status
	 */
	String getStatus();

	/**
	 * Returns any message from the server
	 * 
	 * @return the message
	 */
	String getMessage();

	/**
	 * Returns the data associated to the request
	 * 
	 * @return a map of data
	 */
	Map<String, Object> getData();
}
