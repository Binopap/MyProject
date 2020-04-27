package com.miraglo.egas.dao;

import java.util.List;

import com.miraglo.egas.dm.Cook;
import com.miraglo.egas.dm.RestaurantOrder;

public interface RestaurantOrderDAO {
	public RestaurantOrder getById(Long orderId);
	public RestaurantOrder create(RestaurantOrder order);
	public Boolean cancel(RestaurantOrder order);
	public Integer getStatus(RestaurantOrder order);
	public List<RestaurantOrder> getByCook(Cook cook,String Hotel);
	public List<RestaurantOrder> getByDelay(Long minutes,String Hotel);
	public List<RestaurantOrder> getDeliveredIn(Long minutes,String Hotel);
	
}
