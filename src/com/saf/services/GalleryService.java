package com.miraglo.services;

import java.io.File;

import com.miraglo.egas.dm.Gallery;

public interface GalleryService {
	public Gallery getByHotelName(String hotelname);
	public Gallery add(Gallery gallery);
	public Gallery update(Gallery gallery);
	public Boolean remove(Gallery gallery);
	/**
	 * 
	 * @param hotelName Name of hotel whose gallery is to be zipped and sent
	 * @return The file reference to the zipped file.
	 */
	public String getZippedGallery(String hotelName);
	
}
