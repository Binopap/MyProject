package com.miraglo.egas.services.impl;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miraglo.egas.dao.HotelDAO;
import com.miraglo.egas.dm.Hotel;
import com.miraglo.services.HotelService;
@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)

public class HotelServiceImpl implements HotelService {
	@Autowired
	HotelDAO hoteldao;
	@Override
	public Hotel getByName(String name) {
		// TODO Auto-generated method stub
		return hoteldao.getByName(name);
	}

	@Override
	public Hotel getById(Long id) {
		// TODO Auto-generated method stub
		return hoteldao.getByid(id);
	}

	@Override
	public Hotel add(Hotel hotel) {
		// TODO Auto-generated method stub
		return hoteldao.add(hotel);
	}

	@Override
	public Hotel update(Hotel hotel) {
		// TODO Auto-generated method stub
		return hoteldao.update(hotel);
	}

	@Override
	public Boolean delete(Hotel hotel) {
		// TODO Auto-generated method stub
		return hoteldao.delete(hotel);
	}

	@Override
	public Hotel getByStatus(Short status) {
		// TODO Auto-generated method stub
		return hoteldao.getByStatus(status);
	}

}
