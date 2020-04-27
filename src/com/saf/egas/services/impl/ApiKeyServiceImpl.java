package com.miraglo.egas.services.impl;

import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miraglo.egas.dao.ApiKeyDAO;
import com.miraglo.egas.dm.ApiKey;
import com.miraglo.services.ApiKeyService;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ApiKeyServiceImpl implements ApiKeyService {
	@Autowired
	ApiKeyDAO apiDAO;

	@Override
	public ApiKey createApiKey(ApiKey apiKey) {
		return apiDAO.saveApiKey(apiKey);
	}

	@Override
	@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
	public List<ApiKey> listAllKeys() {
		// TODO Auto-generated method stub
		return apiDAO.getAllKeys();
	}

	@Override
	@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
	public ApiKey validateKey(String key) {
		// TODO Auto-generated method stub
		return apiDAO.queryKeyByApiKey(key);
	}

}
