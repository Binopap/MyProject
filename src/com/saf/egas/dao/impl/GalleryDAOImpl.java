package com.miraglo.egas.dao.impl;

import java.io.File;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.miraglo.egas.dao.GalleryDAO;
import com.miraglo.egas.dm.Gallery;
import org.springframework.stereotype.Repository;

@Repository
public class GalleryDAOImpl implements GalleryDAO{
	
	@Autowired
	SessionFactory fact;
	
	@Override
	public Gallery getByHotelName(String hotelname) {
		Session session=fact.getCurrentSession();
		Criteria cr=session.createCriteria(Gallery.class);
		cr.add(Restrictions.eq("hotelName", hotelname));
		List<Gallery> res=cr.list();
		if(res.size()>0){
			return res.get(0);
		}
		else
			return null;
	}

	@Override
	public Gallery add(Gallery gallery) {
		Session session=fact.getCurrentSession();
		session.save(gallery);
		return gallery;
	}

	@Override
	public Gallery update(Gallery gallery) {
		Session session=fact.getCurrentSession();
		session.update(gallery);
		return gallery;
	}

	@Override
	public Boolean remove(Gallery gallery) {
		Session session = fact.getCurrentSession();
		Query query = session.createQuery("delete Gallery where galleryId=:galleryId");
		query.setLong("galleryId", gallery.getGalleryId());
		int result = query.executeUpdate();
		return result > 0;
	}
	

}
