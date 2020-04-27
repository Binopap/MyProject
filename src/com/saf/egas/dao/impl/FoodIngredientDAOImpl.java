package com.miraglo.egas.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.miraglo.egas.dao.FoodIngredientDAO;
import com.miraglo.egas.dm.FoodIngredient;

public class FoodIngredientDAOImpl implements FoodIngredientDAO {
	@Autowired
	SessionFactory fact;
	@Override
	public FoodIngredient getById(long foodId) {

		Session session = fact.getCurrentSession();
		Query query = session
				.createQuery("from FoodIngredient where ingredientId=:ingredientId");
		query.setLong("ingredientId", foodId);
		List<FoodIngredient> foods = query.list();
		if (foods.size() > 0) {
			return foods.get(0);
		} else {
			return null;

		}
	}
	@Override
	public FoodIngredient add(FoodIngredient fi) {
		Session se = fact.getCurrentSession();
		se.save(fi);
		return fi;
	}
	@Override
	public FoodIngredient remove(FoodIngredient fi) {
		Session ses = fact.getCurrentSession();
		ses.delete(fi);
		return fi;
	}
	@Override
	public FoodIngredient update(FoodIngredient fi) {
		Session ses = fact.getCurrentSession();
		ses.update(fi);
		return fi;
	}
	@Override
	public List<FoodIngredient> getIngredients(String hotelName) {
		Session session = fact.getCurrentSession();
		Query query = session
				.createQuery("from FoodIngredient where hotelName=:hotelName");
		query.setString("hotelName", hotelName);
		
		 return query.list();
		
	}

}
