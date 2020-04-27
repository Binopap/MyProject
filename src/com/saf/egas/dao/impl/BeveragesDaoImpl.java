package com.miraglo.egas.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraglo.egas.dao.BeveragesDao;
import com.miraglo.egas.dm.Bar;
import com.miraglo.egas.dm.Beverages;
import com.miraglo.egas.dm.Food;

@Repository
public class BeveragesDaoImpl implements BeveragesDao {
	@Autowired
	SessionFactory fact;
	@Override
	public ArrayList<Beverages> getBeveragesListForBar(Bar bar) {
		Session session = fact.getCurrentSession();
		Query query = session.createQuery("from Beverages where bar=:bar");
		query.setEntity("bar", bar);
		return (ArrayList<Beverages>) query.list();
	}

	@Override
	public Beverages addBeverages(Beverages beverage) {
		Session se = fact.getCurrentSession();
		se.save(beverage);
		return beverage;
	}

	@Override
	public Boolean removeBeverages(Beverages beverage) {
		Session ses = fact.getCurrentSession();
		ses.delete(beverage);
		return true;
	}

	@Override
	public Beverages getBeveragesById(Long beverage_Id) {
		Session session = fact.getCurrentSession();
		Query query = session.createQuery("from Beverages where beverage_Id=:beverage_Id");
		query.setLong("beverage_Id", beverage_Id);
		List<Beverages> beverage = query.list();
		if (beverage.size() > 0) {
			return beverage.get(0);
		} else {
			return null;

		}
	}

	@Override
	public Boolean deleteBeveragesById(Long id) {
		Session session = fact.getCurrentSession();
		Query query = session.createQuery("delete Beverages where beverage_Id=:beverage_Id");
		query.setLong("beverage_Id", id);
		int result = query.executeUpdate();
		return result > 0;
	}

}
