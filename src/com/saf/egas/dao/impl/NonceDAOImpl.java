package com.miraglo.egas.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraglo.egas.dao.NonceDAO;
import com.miraglo.egas.dm.Nonce;

@Repository
public class NonceDAOImpl implements NonceDAO {

	@Autowired
	SessionFactory fact;

	@Override
	public Nonce getByNonce(String nonce) {
		Session ses = fact.getCurrentSession();
		Query query = ses.createQuery("from Nonce where nonce=:nonce");
		query.setString("nonce", nonce);
		query.setCacheable(true);
		List<Nonce> nonces = query.list();
		if (nonces.size() > 0)
			return nonces.get(0);
		else
			return null;
	}

	@Override
	public Nonce addNonce(Nonce nonce) {
		Session ses=fact.getCurrentSession();
		ses.save(nonce);
		return nonce;
	}

	@Override
	public Nonce updateNonce(Nonce nonce) {
		Session ses=fact.getCurrentSession();
		ses.update(nonce);
		return nonce;
	}

}
