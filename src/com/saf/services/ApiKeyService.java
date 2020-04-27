package com.miraglo.services;

import java.util.List;

import com.miraglo.egas.dm.ApiKey;

public interface ApiKeyService {
	public ApiKey createApiKey(ApiKey apiKey);
	public List<ApiKey> listAllKeys();
	public ApiKey validateKey(String key);
}
