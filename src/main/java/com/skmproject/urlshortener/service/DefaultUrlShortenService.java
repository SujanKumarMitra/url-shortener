package com.skmproject.urlshortener.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import com.skmproject.urlshortener.dao.UrlInfoRepository;
import com.skmproject.urlshortener.exception.InvalidUrlException;
import com.skmproject.urlshortener.exception.UrlNotExistsException;
import com.skmproject.urlshortener.model.DefaultUrlInfo;
import com.skmproject.urlshortener.model.UrlInfo;
import com.skmproject.urlshortener.resource.UrlResource;
import com.skmproject.urlshortener.util.UrlEncoder;
import com.skmproject.urlshortener.util.UrlValidator;

@Service
public class DefaultUrlShortenService implements UrlShortenerService{
	
	@Autowired
	private UrlEncoder encoder;
	
	@Autowired
	private UrlValidator validator;
	
	@Autowired
	private UrlInfoRepository repository;

	@Override
	public UrlInfo getShortenedUrl(String url) {
		if(!validator.isUrlValid(url)) {
			throw new InvalidUrlException(url + " is not a valid url");
		}
		if(!url.contains(":")) {
			url = "http://".concat(url);
		}
		String shortenedUrl = encoder.encode(url);
		WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(UrlResource.class).slash(shortenedUrl);
		DefaultUrlInfo info = new DefaultUrlInfo(url,shortenedUrl,linkBuilder.toString());
		return repository.save(info);
	}

	@Override
	public UrlInfo getOrginalUrl(String url) throws UrlNotExistsException {
		Optional<DefaultUrlInfo> urlInfo = repository.findById(url);
		return urlInfo.orElseThrow(()-> new UrlNotExistsException("links not found with "+url));
	}

}
