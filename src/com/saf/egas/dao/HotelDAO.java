package com.miraglo.egas.dao;

import com.miraglo.egas.dm.Hotel;

public interface HotelDAO {
	public Hotel getByid(long hotelId);
	public Hotel getByName(String name);
	public Hotel add(Hotel hotel);
	public Hotel update(Hotel hotel);
	public Boolean delete(Hotel hotel);
	public Hotel getByStatus(Short status);
}
