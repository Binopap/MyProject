package com.miraglo.egas.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraglo.egas.dao.ApiKeyDAO;
import com.miraglo.egas.dm.ApiKey;

@Repository
public class ApiKeyDAOImpl implements ApiKeyDAO {
	@Autowired
	SessionFactory fact;

	@Override
	public ApiKey saveApiKey(ApiKey apikey) {
		Session session = fact.getCurrentSession();
		session.save(apikey);
		return apikey;
	}

	@Override
	public ApiKey updateApiKey(ApiKey apikey) {
		Session session = fact.getCurrentSession();
		session.update(apikey);
		return apikey;
	}

	@Override
	public Boolean deleteApiKey(ApiKey apikey) {
		Session session = fact.getCurrentSession();
		session.delete(apikey);
		return true;
	}

	@Override
	public ApiKey queryKeyByToken(String token) {
		Session session = fact.getCurrentSession();
		Query query = session.createQuery("from ApiKey where token=:token");
		query.setString("token", token);
		List<ApiKey> apikeys = query.list();
		if (apikeys.size() > 0)
			return apikeys.get(0);
		else
			return null;
	}

	@Override
	public ApiKey queryKeyByApiKey(String apikey) {
		Session session = fact.getCurrentSession();
		Query query = session.createQuery("from ApiKey where apikey=:apikey");
		query.setString("apikey", apikey);
		List<ApiKey> apikeys = query.list();
		if (apikeys.size() > 0)
			return apikeys.get(0);
		else
			return null;
	}

	@Override
	public List<ApiKey> getAllKeys() {
		Session session = fact.getCurrentSession();
		Query query = session.createQuery("from ApiKey");
		query.setCacheable(true);
		List<ApiKey> apikeys = query.list();

		return apikeys;

	}

}
