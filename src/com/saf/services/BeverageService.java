package com.miraglo.services;

import java.util.ArrayList;
import java.util.List;

import com.miraglo.egas.dm.Bar;
import com.miraglo.egas.dm.Beverages;


public interface BeverageService {
	public ArrayList<Beverages> getBeveragesListForBar(Bar bar);
	public Beverages addBeverages(Beverages beverage);
	public Boolean removeBeverages(Beverages beverage);
	public Beverages getBeveragesById(Long fid);
	public Boolean deleteBeveragesById(Long id);
	
}
	
