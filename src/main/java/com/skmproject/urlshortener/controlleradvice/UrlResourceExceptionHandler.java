package com.skmproject.urlshortener.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.skmproject.urlshortener.dto.DefaultRestResponse;
import com.skmproject.urlshortener.dto.RestResponse;
import com.skmproject.urlshortener.exception.InvalidUrlException;
import com.skmproject.urlshortener.exception.UrlNotExistsException;
import com.skmproject.urlshortener.resource.UrlResource;

/**
 * Controller advice for {@link UrlResource}
 * @author Sujan Kumar Mitra
 * @see UrlResource
 */
@RestControllerAdvice
public class UrlResourceExceptionHandler {
	
	/**
	 * Creates a response with status and message  
	 * @param status the status
	 * @param message the message
	 * @return response entity
	 */
	private ResponseEntity<RestResponse> createErrorResponseEntity(HttpStatus status, String message) {
		RestResponse response = DefaultRestResponse
				.builder()
				.status("error")
				.message(message)
				.build();
		return ResponseEntity
				.status(status)
				.contentType(MediaType.APPLICATION_JSON)
				.body(response);
	}
	
	@ExceptionHandler
	public ResponseEntity<RestResponse> urlNotExists(UrlNotExistsException exception) {
		return createErrorResponseEntity(HttpStatus.BAD_REQUEST, exception.getMessage());
	}

	@ExceptionHandler
	public ResponseEntity<RestResponse> invalidUrl(InvalidUrlException exception) {
		return createErrorResponseEntity(HttpStatus.BAD_REQUEST, exception.getMessage());
	}

}
