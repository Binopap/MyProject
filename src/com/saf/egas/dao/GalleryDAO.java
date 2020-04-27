package com.miraglo.egas.dao;

import java.io.File;

import com.miraglo.egas.dm.Gallery;

public interface GalleryDAO {
	public Gallery getByHotelName(String hotelname);
	public Gallery add(Gallery gallery);
	public Gallery update(Gallery gallery);
	public Boolean remove(Gallery gallery);
	
}
