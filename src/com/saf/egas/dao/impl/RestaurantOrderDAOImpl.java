package com.miraglo.egas.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraglo.egas.dao.RestaurantOrderDAO;
import com.miraglo.egas.dm.Cook;
import com.miraglo.egas.dm.Guest;
import com.miraglo.egas.dm.RestaurantOrder;

@Repository
public class RestaurantOrderDAOImpl implements RestaurantOrderDAO{

	@Autowired
	SessionFactory fact;
	/**
	 * This method gets the order
	 * @param RestaurantOrder type
	 *                
	 * @return order
	 */
	
	@Override
	public RestaurantOrder create(RestaurantOrder order) {
		Session session=fact.getCurrentSession();
		session.save(order);
		return order;
	}
	/**
	 * This method gets updated order
	 * @param RestaurantOrder type
	 * @return updated order
	 */

	@Override
	public Boolean cancel(RestaurantOrder order) {
		Session session=fact.getCurrentSession();
		order.setStatus(0);
		session.update(order);
		return null;
	}
	/**
	 * This method gets the status of ordered item
	 * @param RestaurantOrder Type
	 * @return status of the order
	 */

	@Override
	public Integer getStatus(RestaurantOrder order) {
		
		return order.getStatus();
	}
/**
 * This method gets the cook in particular hotel
 * @param Cook type and hotelName type 
 * @return order list
 */
	@Override
	public List<RestaurantOrder> getByCook(Cook cook, String Hotel) {
		Session session=fact.getCurrentSession();
		Query query=session.createQuery("from RestaurantOrder where Cook=:Cook and hotelName=:hotelName");
		query.setEntity("Cook", cook);
		query.setString("hotelName", Hotel);
		return query.list();
	}
/**
 * This method gets the list of delayed orders
 * @param minute as long type and Hotel as String type
 * @return RestaurantOrder list
 */
	@Override
	public List<RestaurantOrder> getByDelay(Long minutes, String Hotel) {
Date dcurrentdate=new Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(dcurrentdate);
		cal.add(Calendar.DATE, -1);
		Date dateBefore1Day = cal.getTime();
		
		Session session=fact.getCurrentSession();
		Criteria cr=session.createCriteria(RestaurantOrder.class);
		//cr.add(Restrictions.eq("orderTime",d));
		cr.add(Restrictions.isNull("orderDeliveryTime"));
		cr.add(Restrictions.gt("orderTime", dateBefore1Day));//("orderDeliveryTime"));
		cr.add(Restrictions.eq("hotelName", Hotel));
		List<RestaurantOrder> res=cr.list();
		List<RestaurantOrder> OrgRes=new ArrayList<RestaurantOrder>();
		for(int i=0;i<res.size();i++){
			Date dorderdate=res.get(i).getOrderTime();
			long diff=dcurrentdate.getTime()-dorderdate.getTime();
			long diffMinutes = diff / (60 * 1000);
			if(diffMinutes >minutes){
				OrgRes.add(res.get(i));
			}
		}
		return OrgRes;
	}

	/**
	 * This method gets the list of items delivered in a particular time period
	 * @param minutes as long and Hotel as String
	 * @return RestaurantOrder List
	 */
	@Override
	public List<RestaurantOrder> getDeliveredIn(Long minutes, String Hotel) {
		Date dcurrentdate=new Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(dcurrentdate);
		cal.add(Calendar.DATE, -1);
		Date dateBefore1Day = cal.getTime();
		
		Session session=fact.getCurrentSession();
		Criteria cr=session.createCriteria(RestaurantOrder.class);
		cr.add(Restrictions.gt("orderDeliveryTime", dateBefore1Day));
		cr.add(Restrictions.eq("hotelName", Hotel));
		List<RestaurantOrder> res=cr.list();
		List<RestaurantOrder> OrgRes=new ArrayList<RestaurantOrder>();
		for(int i=0;i<res.size();i++){
			Date dorderdate=res.get(i).getOrderTime();
			Date dorderDelevterdate=res.get(i).getOrderDeliveryTime();
			long diff=dorderDelevterdate.getTime()-dorderdate.getTime();
			long diffMinutes = diff / (60 * 1000);
			if(diffMinutes >minutes){
				OrgRes.add(res.get(i));
			}
		}
		return OrgRes;
	}
	
	/**
	 * This method gets the order 
	 * @Param Long orderid
	 * @return order
	 */

	@Override
	public RestaurantOrder getById(Long orderId) {
		Session session=fact.getCurrentSession();
		Query query=session.createQuery("from RestaurantOrder where orderId=:orderId ");
		query.setLong("orderId", orderId);
		List<RestaurantOrder> order=query.list();
		if(order.size()>0){
			return order.get(0);
		}else{
		return null;
		}
	}
	
	

}
