package com.miraglo.egas.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraglo.egas.dao.FoodDAO;
import com.miraglo.egas.dm.Food;
import com.miraglo.egas.dm.FoodIngredient;
import com.miraglo.egas.dm.Hotel;

/**
 * 
 * @author Manu ML
 * 
 */
@Repository
public class FoodDAOImpl implements FoodDAO {

	@Autowired
	SessionFactory fact;

	@Override
	public Boolean deleteById(Long id) {
		Session session = fact.getCurrentSession();
		Query query = session.createQuery("delete Food where foodId=:foodId");
		query.setLong("foodId", id);
		int result = query.executeUpdate();
		return result > 0;
	}

	/**
	 * This method gets a Food item by it's id
	 * 
	 * @param id
	 *            The food id
	 * @return Food Returns the food item with id specified
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Food getById(Long id) {
		Session session = fact.getCurrentSession();
		Query query = session.createQuery("from Food where foodId=:foodId");
		query.setLong("foodId", id);
		List<Food> foods = query.list();
		if (foods.size() > 0) {
			return foods.get(0);
		} else {
			return null;

		}
	}

	/**
	 * This method gets foodlist from hotel
	 * 
	 * @param Hotel
	 *            type
	 * @return the foodlist for each hotel
	 * 
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<Food> getByHotel(Hotel hotel) {
		Session session = fact.getCurrentSession();
		Query query = session.createQuery("from Food where hotel=:hotel");
		query.setEntity("hotel", hotel);
		return query.list();

	}

	/**
	 * Method to add Food
	 * 
	 * @param Food
	 *            type
	 * @return Food item
	 */
	@Override
	public Food add(Food food) {
		Session se = fact.getCurrentSession();
		se.save(food);
		return food;
	}

	/**
	 * This method get vegitarian/Non Vegeterian food list
	 * 
	 * @param isVeg
	 *            of boolean type
	 * @return list of vegitarian/Non Vegeterian fooditems
	 */
	@Override
	public List<Food> getByType(Boolean isVeg) {
		Session sen = fact.getCurrentSession();
		Query query = sen.createQuery("from Food where vegitarian=:vegitarian");
		query.setBoolean("vegitarian", isVeg);

		return query.list();
	}

	/**
	 * This method to get Food by its ingredients
	 * 
	 * @param ingredients
	 *            list
	 * @return Food Items with Particular Ingredients
	 */

	@Override
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	public List<Food> getByIngredients(List<FoodIngredient> ingredients) {
		Session sen = fact.getCurrentSession();
		
		ArrayList<Long> ids = new ArrayList<Long>();
		for (FoodIngredient fi : ingredients) {
			ids.add(fi.getIngredientId());
		}
		Query query = sen
				.createQuery("from Food f join f.ingredients fi where fi.ingredientId IN (:ingredients)");

		query.setParameterList("ingredients", ids);
		query.setCacheable(true);
		
		return query.list();
	}

	/**
	 * This method removes food item from Food
	 * 
	 * @param Food
	 *            type
	 * @return boolean value
	 */

	@Override
	public Boolean remove(Food food) {
		Session ses = fact.getCurrentSession();
		ses.delete(food);
		return true;
	}

	/**
	 * This method gets the Vegitarian/Non Vegetarian food items
	 * 
	 * @param isVegitarian
	 *            (BVoolean) and Hotel type
	 * @return food items
	 */
	@Override
	public ArrayList<Food> getByType(Hotel hotel, Boolean isVegitarian) {
		Session sen = fact.getCurrentSession();
		Query query = sen
				.createQuery("from Food where hotel=:hotel and vegitarian=:vegitarian");
		query.setEntity("hotel", hotel);
		query.setBoolean("vegitarian", isVegitarian);
		ArrayList<Food> food = (ArrayList<Food>) query.list();
		return food;
	}

	

}
