package com.miraglo.egas.rest.responsemodels;

import java.util.Date;
import java.util.List;

import com.miraglo.egas.dm.ApiKey;

public class SetupResponse {
	public String apikey;
	public String token;
	public Date lastLease;
	List<ApiKey> apiKeys;
	
	public String getApikey() {
		return apikey;
	}
	public void setApikey(String apikey) {
		this.apikey = apikey;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getLastLease() {
		return lastLease;
	}
	public void setLastLease(Date lastLease) {
		this.lastLease = lastLease;
	}
	public List<ApiKey> getApiKeys() {
		return apiKeys;
	}
	public void setApiKeys(List<ApiKey> apiKeys) {
		this.apiKeys = apiKeys;
	}
	
	
}
