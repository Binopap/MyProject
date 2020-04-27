package com.miraglo.egas.dao;

import java.util.List;

import com.miraglo.egas.dm.FoodIngredient;

public interface FoodIngredientDAO {
	
	public FoodIngredient getById(long foodId);
	public FoodIngredient add(FoodIngredient fi);
	public FoodIngredient remove(FoodIngredient fi);
	public FoodIngredient update(FoodIngredient fi);
	public List<FoodIngredient> getIngredients(String hotelName);
}
