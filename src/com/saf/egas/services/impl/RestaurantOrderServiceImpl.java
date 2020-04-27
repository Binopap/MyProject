package com.miraglo.egas.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miraglo.egas.dao.RestaurantOrderDAO;
import com.miraglo.egas.dm.Cook;
import com.miraglo.egas.dm.RestaurantOrder;
import com.miraglo.services.RestaurantOrderService;

@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class RestaurantOrderServiceImpl implements RestaurantOrderService{

	@Autowired
	RestaurantOrderDAO restaurantOrderDAO; 
	
	@Override
	public RestaurantOrder create(RestaurantOrder order) {
		return restaurantOrderDAO.create(order);
	}

	@Override
	public Boolean cancel(RestaurantOrder order) {
		
		return restaurantOrderDAO.cancel(order);
	}

	@Override
	public Integer getStatus(RestaurantOrder order) {
		return restaurantOrderDAO.getStatus(order);
	}

	@Override
	public List<RestaurantOrder> getOrdersAttendedByCook(Cook cook,
			String hotelName) {
		return restaurantOrderDAO.getByCook(cook,hotelName);
	}

	@Override
	public List<RestaurantOrder> getOrdersByDelay(Long minutes, String hotelName) {
		return restaurantOrderDAO.getByDelay(minutes,hotelName);
	}

	@Override
	public List<RestaurantOrder> getOrdersDeliveredIn(Long minutes,
			String hotelName) {
		return restaurantOrderDAO.getDeliveredIn(minutes,hotelName);
	}

	@Override
	public RestaurantOrder getByid(Long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
