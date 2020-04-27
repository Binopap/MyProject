package com.miraglo.egas.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miraglo.egas.dao.FoodDAO;
import com.miraglo.egas.dao.HotelDAO;
import com.miraglo.egas.dm.Food;
import com.miraglo.egas.dm.FoodIngredient;
import com.miraglo.egas.dm.Hotel;
import com.miraglo.services.FoodService;

@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class FoodServiceImpl implements FoodService{

	
	@Autowired
	FoodDAO fooddao;
	
	@Autowired
	HotelDAO hoteldao;
	
	@Override
	public List<Food> getFoodListForHotel(Hotel hotel) {
	//ArrayList<Food> getfoodlist=  
		return fooddao.getByHotel(hotel);
	}

	@Secured("ROLE_ADMIN")
	@Override
	public ArrayList<Food> getFoodListByType(Hotel hotel, Boolean isVegitarian) {
		
		return fooddao.getByType(hotel,isVegitarian);
	}

	@Override
	public Food addFood(Food food) {
		
		
		return fooddao.add(food);
	}

	@Override
	public Boolean removeFood(Food food) {
		
		return fooddao.remove(food);
	}

	@Override
	public Food getFoodById(Long fid) {
		
		return fooddao.getById(fid);
	}

	@Override
	public Boolean deleteFoodById(Long id) {
	
		return fooddao.deleteById(id);
	}

	@Override
	public List<Food> getFoodByType(Boolean isVeg) {
		
		return fooddao.getByType(isVeg);
	}

	@Override
	public List<Food> getByIngredients(List<FoodIngredient> ingredients) {
		
		return fooddao.getByIngredients(ingredients);
	}

	

	@Override
	public Hotel getHotelById(long hid) {
		// TODO Auto-generated method stub
		return hoteldao.getByid(hid);
	}

	
	
	
	
}
