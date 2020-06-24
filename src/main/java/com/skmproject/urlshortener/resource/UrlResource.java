package com.skmproject.urlshortener.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.skmproject.urlshortener.dto.DefaultRestResponse;
import com.skmproject.urlshortener.dto.RestResponse;
import com.skmproject.urlshortener.dto.UrlEncodeRequest;
import com.skmproject.urlshortener.model.UrlInfo;
import com.skmproject.urlshortener.service.UrlShortenerService;

@RestController
@RequestMapping("/api")
public class UrlResource {

	@Autowired
	private UrlShortenerService urlShortenerService;

	@PostMapping("/encode")
	public ResponseEntity<RestResponse> encodeUrl(@RequestBody UrlEncodeRequest payload) {
		UrlInfo urlInfo = urlShortenerService.getShortenedUrl(payload.getUrl());
		RestResponse response = DefaultRestResponse
				.builder()
				.status("success")
				.message("Link Generated")
				.withData("info", urlInfo)
				.build();
		return ResponseEntity
				.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(response);
	}

	@PostMapping("/decode")
	public ResponseEntity<RestResponse> decodeUrl(@RequestBody UrlEncodeRequest payload) {
		UrlInfo urlInfo = urlShortenerService.getOrginalUrl(payload.getUrl());
		RestResponse response = DefaultRestResponse
				.builder()
				.status("success")
				.message("found")
				.withData("info", urlInfo).build();
		return ResponseEntity
				.status(HttpStatus.FOUND)
				.contentType(MediaType.APPLICATION_JSON)
				.body(response);

	}

	@RequestMapping("/redirect/{url}")
	public RedirectView redirect(@PathVariable("url") String encodedUrl) {
		UrlInfo urlInfo = urlShortenerService.getOrginalUrl(encodedUrl);
		return new RedirectView(urlInfo.getOriginalUrl());
	}

}
