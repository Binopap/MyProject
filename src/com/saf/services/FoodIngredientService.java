package com.miraglo.services;

import java.util.List;

import com.miraglo.egas.dm.FoodIngredient;

public interface FoodIngredientService {
public FoodIngredient add(FoodIngredient fi);
public FoodIngredient remove(FoodIngredient fi);
public FoodIngredient update(FoodIngredient fi);
public List<FoodIngredient> getIngredients(String hotelName);
public FoodIngredient getIngredientById(long id);
}
