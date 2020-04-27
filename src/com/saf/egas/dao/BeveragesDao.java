package com.miraglo.egas.dao;

import java.util.ArrayList;

import com.miraglo.egas.dm.Bar;
import com.miraglo.egas.dm.Beverages;

public interface BeveragesDao {
	public ArrayList<Beverages> getBeveragesListForBar(Bar bar);
	public Beverages addBeverages(Beverages beverage);
	public Boolean removeBeverages(Beverages beverage);
	public Beverages getBeveragesById(Long fid);
	public Boolean deleteBeveragesById(Long id);
}
