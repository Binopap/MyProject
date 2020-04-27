package com.miraglo.egas.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miraglo.egas.dao.GuestDAO;
import com.miraglo.egas.dao.HotelDAO;
import com.miraglo.egas.dao.NonceDAO;
import com.miraglo.egas.dm.Guest;
import com.miraglo.egas.dm.Nonce;
import com.miraglo.services.NonceService;

@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class NonceServiceImpl implements NonceService{

	@Autowired
	NonceDAO nonceDao;
	@Autowired
	GuestDAO guestdao;
	@Autowired
	HotelDAO hotelDao;
	@Override
	public Nonce getNonce(String nonce) {
		// TODO Auto-generated method stub
		return nonceDao.getByNonce(nonce);
	}

	@Override
	public Nonce addNonce(Nonce nonce) {
		// TODO Auto-generated method stub
		return nonceDao.addNonce(nonce);
	}

	@Override
	public Boolean removeAllStaleNonce() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean nonceCheck(String hotelName, String nonce, String imei) {
		boolean flag=false;
		Guest g=guestdao.getActiveGuestByImei(imei);
		Nonce nonce1=nonceDao.getByNonce(nonce);
		if(nonce==null){
	
		if(nonce1.getGuest()==null){
			nonce1.setGuest(g);
			nonce1.setHotel(hotelDao.getByName(hotelName));
			nonce1.setLeaseTime(new Date().toString());
			nonceDao.updateNonce(nonce1);
			flag= true;
	  }
		else if(nonce1.getUser()==null){
		flag= false;
	  }else{
		  
	  }
		
		}
		return flag;
	}

	@Override
	public Nonce updateNonce(Nonce nonce) {
		// TODO Auto-generated method stub
		return nonceDao.updateNonce(nonce);
	}
	

}
