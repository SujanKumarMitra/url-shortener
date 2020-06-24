package com.skmproject.urlshortener.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skmproject.urlshortener.model.DefaultUrlInfo;

/**
 * Performs CRUD operations on {@link DefaultUrlInfo}
 * @author Sujan Kumar Mitra
 *
 */
@Repository
public interface UrlInfoRepository extends CrudRepository<DefaultUrlInfo, String> {	
}
