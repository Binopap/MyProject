package com.miraglo.egas.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.Entity;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraglo.egas.dao.GuestDAO;
import com.miraglo.egas.dm.Guest;
import com.miraglo.egas.dm.Hotel;

@Repository
public class GuestDAOImpl implements GuestDAO {
	@Autowired
	SessionFactory fact;
	
	/**This method return the identity of the active guest having imei number
	 * @param is imei as string type
	 * @return guests having imei
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Guest getActiveGuestByImei(String imei) {
		Session ses = fact.getCurrentSession();
		Query query = ses.createQuery("from Guest where imei=:imei and isActive=:isActive");
		query.setString("imei", imei);
		query.setBoolean("isActive", true);
		query.setCacheable(true);
		List<Guest> guests = query.list();
		if (guests.size() > 0)
			return guests.get(0);
		else
			return guests.get(1);
	}
	/**This method returns the state of deactive guest
	 * @param is Guest as guest type
	 * @return the state of guest
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Boolean deactivate(Guest guest) {
		guest.setIsActive(false);
		Session ses = fact.getCurrentSession();
		ses.update(guest);
	
		return true;
	}
	//@SuppressWarnings("unchecked")
	/**This method returns the guest id
	 * @param is guest id as long
	 * @return the guest id
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Guest getByID(Long guestId) {
		Session session=fact.getCurrentSession();
		Query query=session.createQuery("from Guest where guestId=:guestId");
		query.setLong("guestId", guestId);
		List<Guest> guests=query.list();
		if(guests.size()>0){
			return guests.get(0);
		}else{
			return null;
		}
	}

	/**This method returns the list of guests in hotel
	 * @param is hotel type
	 * @return the list of guests in the hotel
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Guest> getByHotel(Hotel hotel) {
		Session session=fact.getCurrentSession();
		Query query=session.createQuery("from Guest where hotel=:hotel");
		query.setEntity("hotel", hotel);
		return query.list();
	}
	
	/**This method returns the list of guests having allergies
	 * @return the list of guests having allergies
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Guest> getWithAllergies() {
	Session session=fact.getCurrentSession();
	List<Guest> guests=session.createQuery("from Guest ").list();
	List<Guest> gu=new ArrayList<Guest>();
	for(int i=0;i<guests.size();i++)
	{
		if(guests.get(i).getAllergens().size()!=0){
			gu.add(guests.get(i));
		}
	}
	if(gu.size()>0)
		return gu;
	else
		return null;	
	
	}
	/**This method returns the updated imei number
	 * @param is Guest as guest type and imei as string 
	 * @return  guest with new imei
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Guest updateDevice(Guest guest, String imei) {
		Session session=fact.getCurrentSession();
		guest.setImei(imei);
		session.update(guest);
		return guest;
	}

}
