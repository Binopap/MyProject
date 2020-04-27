package com.miraglo.egas.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.miraglo.egas.dao.FoodIngredientDAO;
import com.miraglo.egas.dm.FoodIngredient;
import com.miraglo.services.FoodIngredientService;

public class FoodIngredientServiceImpl  implements FoodIngredientService{

	@Autowired
	FoodIngredientDAO foodingredientdao;
	@Override
	public FoodIngredient add(FoodIngredient fi) {
		// TODO Auto-generated method stub
		return foodingredientdao.add(fi);
	}

	@Override
	public FoodIngredient remove(FoodIngredient fi) {
		// TODO Auto-generated method stub
		return foodingredientdao.remove(fi);
	}

	@Override
	public FoodIngredient update(FoodIngredient fi) {
		// TODO Auto-generated method stub
		return foodingredientdao.update(fi);
	}

	@Override
	public List<FoodIngredient> getIngredients(String hotelName) {
		// TODO Auto-generated method stub
		return foodingredientdao.getIngredients(hotelName);
	}

	@Override
	public FoodIngredient getIngredientById(long id) {
		// TODO Auto-generated method stub
		return foodingredientdao.getById(id);
	}

}
