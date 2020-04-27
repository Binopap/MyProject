package com.miraglo.services;

import java.util.ArrayList;
import java.util.List;

import com.miraglo.egas.dm.Food;
import com.miraglo.egas.dm.FoodIngredient;
import com.miraglo.egas.dm.Hotel;

public interface FoodService {

	public List<Food> getFoodListForHotel(Hotel hotel);
	public ArrayList<Food> getFoodListByType(Hotel hotel,Boolean isVegitarian);
	public Food addFood(Food food);
	public Boolean removeFood(Food food);
	public Food getFoodById(Long fid);
	public Boolean deleteFoodById(Long id);
	public List<Food> getFoodByType(Boolean isVeg);
	public List<Food> getByIngredients(List<FoodIngredient>ingredients);
	public Hotel getHotelById(long hid);
}
