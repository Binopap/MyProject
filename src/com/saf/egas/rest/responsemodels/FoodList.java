package com.miraglo.egas.rest.responsemodels;

import java.util.ArrayList;

import com.miraglo.egas.dm.Food;

public class FoodList {
	private ArrayList<Food> fooditems;

	public ArrayList<Food> getFooditems() {
		return fooditems;
	}

	public void setFooditems(ArrayList<Food> fooditems) {
		this.fooditems = fooditems;
	}
	
}
