package com.miraglo.egas.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraglo.egas.dao.HotelDAO;
import com.miraglo.egas.dm.Hotel;

@Repository
public class HotelDAOImpl implements HotelDAO {
	@Autowired
	SessionFactory fact;

	@Override
	public Hotel getByid(long hotelId) {

		Session session=fact.getCurrentSession();
		Query query=session.createQuery("from Hotel where hotelId=:hotelId");
		query.setLong("hotelId", hotelId);
		List<Hotel> ingr=query.list();
		if(ingr.size()>0){
			return ingr.get(0);
		}else{
			return null;
			
		}
	}

	@Override
	public Hotel getByName(String name) {
		Session session=fact.getCurrentSession();
		Query query=session.createQuery("from Hotel where hotelName=:hotelName");
		query.setString("hotelName", name);
		List<Hotel> ingr=query.list();
		if(ingr.size()>0){
			return ingr.get(0);
		}else{
			return null;
			
		}
		
	}

	@Override
	public Hotel add(Hotel hotel) {
		Session se = fact.getCurrentSession();
		se.save(hotel);
		return hotel;
	}

	@Override
	public Hotel update(Hotel hotel) {
		Session se = fact.getCurrentSession();
		se.update(hotel);
		return hotel;
	}

	@Override
	public Boolean delete(Hotel hotel) {
		Session ses = fact.getCurrentSession();
		ses.delete(hotel);
		return true;
	}
	
	@Override
	public Hotel getByStatus(Short status) {

		Session session=fact.getCurrentSession();
		Query query=session.createQuery("from Hotel where status=:status");
		query.setShort("status", status);
		List<Hotel> ingr=query.list();
		if(ingr.size()>0){
			return ingr.get(0);
		}else{
			return null;
			
		}
	}
	
	

}
