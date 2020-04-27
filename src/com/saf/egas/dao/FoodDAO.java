package com.miraglo.egas.dao;

import java.util.ArrayList;
import java.util.List;

import com.miraglo.egas.dm.Food;
import com.miraglo.egas.dm.FoodIngredient;
import com.miraglo.egas.dm.Hotel;

public interface FoodDAO {

	public Boolean deleteById(Long id);
	public Food getById(Long id);
	public List<Food> getByHotel(Hotel hotel);
	public Food add(Food food);
	public List<Food> getByType(Boolean isVeg);
	public List<Food> getByIngredients(List<FoodIngredient> ingredients);
	public Boolean remove(Food food); 
	public  ArrayList<Food> getByType(Hotel hotel, Boolean isVegitarian);

}
