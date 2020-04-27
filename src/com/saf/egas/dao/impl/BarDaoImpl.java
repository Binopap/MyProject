package com.miraglo.egas.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraglo.egas.dao.BarDao;
import com.miraglo.egas.dm.Bar;
import com.miraglo.egas.dm.Hotel;
@Repository
public class BarDaoImpl implements BarDao {
	@Autowired
	SessionFactory fact;
	@Override
	public Bar getByName(String barName) {
		Session session=fact.getCurrentSession();
		Query query=session.createQuery("from Bar where barName=:barName");
		query.setString("barName", barName);
		List<Bar> ingr=query.list();
		if(ingr.size()>0){
			return ingr.get(0);
		}else{
			return null;
			
		}
	}

	@Override
	public Bar getById(Long id) {
		Session session=fact.getCurrentSession();
		Query query=session.createQuery("from Bar where barId=:barId");
		query.setLong("barId", id);
		List<Bar> ingr=query.list();
		if(ingr.size()>0){
			return ingr.get(0);
		}else{
			return null;
			
		}
	}

	@Override
	public Bar add(Bar bar) {
		Session se = fact.getCurrentSession();
		se.save(bar);
		return bar;
	}

	@Override
	public Bar update(Bar bar) {
		Session se = fact.getCurrentSession();
		se.update(bar);
		return bar;
	}

	@Override
	public Boolean delete(Bar bar) {
		Session ses = fact.getCurrentSession();
		ses.delete(bar);
		return true;
	}

}
