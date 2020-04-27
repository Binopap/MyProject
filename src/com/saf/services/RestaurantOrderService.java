package com.miraglo.services;

import java.util.List;

import com.miraglo.egas.dm.Cook;
import com.miraglo.egas.dm.RestaurantOrder;

public interface RestaurantOrderService {
	
	public RestaurantOrder getByid(Long orderId);
	public RestaurantOrder create(RestaurantOrder order);
	public Boolean cancel(RestaurantOrder order);
	public Integer getStatus(RestaurantOrder order);
	public List<RestaurantOrder> getOrdersAttendedByCook(Cook cook,String hotelName);
	/**
	 * Get Orders delayed over the specified duration
	 * @param minutes This parameter specifies the duration in minutes
	 * @return List of orders that are older than the given duration
	 */
	public List<RestaurantOrder> getOrdersByDelay(Long minutes,String hotelName);
	/**
	 * Get orders that are delivered withing the specified duration
	 * @param minutes the duration in minutes
	 * @return The list of orders delivered with in the specified duration
	 */
	public List<RestaurantOrder> getOrdersDeliveredIn(Long minutes,String hotelName);

}
