package com.miraglo.services;

import com.miraglo.egas.dm.Hotel;

/**
 * 
 * 
 * @author Manu ML
 * 
 */
public interface HotelService {
	public Hotel getByName(String name);

	public Hotel getById(Long id);

	public Hotel add(Hotel hotel);

	public Hotel update(Hotel hotel);

	public Boolean delete(Hotel hotel);
	
	public Hotel getByStatus(Short status);
}
