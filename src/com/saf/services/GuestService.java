package com.miraglo.services;

import java.util.List;

import com.miraglo.egas.dm.Guest;
import com.miraglo.egas.dm.Hotel;

public interface GuestService {
	public Guest getActiveGuestByImei(String imei);
	public Boolean deactivateGuest(Guest guest);
	public Guest getGuestById(Long guestId);
	public List<Guest> getGuestsByHotel(Hotel hotel);
	public List<Guest> getGuestsWithAllergies();
	public Guest updateGuestDevice(Guest guest,String imei);
}
