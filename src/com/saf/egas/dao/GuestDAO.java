package com.miraglo.egas.dao;

import java.util.List;

import com.miraglo.egas.dm.Guest;
import com.miraglo.egas.dm.Hotel;

public interface GuestDAO {
	public Guest getActiveGuestByImei(String imei);
	public Boolean deactivate(Guest guest);
	public Guest getByID(Long guestId);
	public List<Guest> getByHotel(Hotel hotel);
	public List<Guest> getWithAllergies();
	public Guest updateDevice(Guest guest, String imei);
	
}
