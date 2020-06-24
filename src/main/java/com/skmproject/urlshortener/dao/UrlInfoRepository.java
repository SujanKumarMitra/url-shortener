package com.skmproject.urlshortener.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skmproject.urlshortener.model.DefaultUrlInfo;

@Repository
public interface UrlInfoRepository extends CrudRepository<DefaultUrlInfo, String> {	
}
