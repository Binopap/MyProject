package com.miraglo.egas.services.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miraglo.egas.dao.GuestDAO;
import com.miraglo.egas.dm.Guest;
import com.miraglo.egas.dm.Hotel;
import com.miraglo.services.GuestService;

@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class GuestServiceImpl implements GuestService{

	@Autowired
	GuestDAO guestDAO;
	
	@Override
	public Guest getActiveGuestByImei(String imei) {
		return guestDAO.getActiveGuestByImei(imei);
	}

	@Override
	public Boolean deactivateGuest(Guest guest) {
		return guestDAO.deactivate(guest);
	}

	@Override
	public Guest getGuestById(Long guestId) {		
		return guestDAO.getByID(guestId);
	}

	@Override
	public List<Guest> getGuestsByHotel(Hotel hotel) {
		return guestDAO.getByHotel(hotel);
	}

	@Override
	public List<Guest> getGuestsWithAllergies() {
		return guestDAO.getWithAllergies();
	}

	@Override
	public Guest updateGuestDevice(Guest guest, String imei) {		
		return guestDAO.updateDevice(guest, imei);
	}

}
