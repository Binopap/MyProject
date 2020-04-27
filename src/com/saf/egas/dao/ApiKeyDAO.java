package com.miraglo.egas.dao;

import java.util.List;

import com.miraglo.egas.dm.ApiKey;

public interface ApiKeyDAO {

	public ApiKey saveApiKey(ApiKey apikey);
	public ApiKey updateApiKey(ApiKey apikey);
	public Boolean deleteApiKey(ApiKey apikey);
	public ApiKey queryKeyByToken(String token);
	public ApiKey queryKeyByApiKey(String apikey);
	public List<ApiKey> getAllKeys();
	
}
