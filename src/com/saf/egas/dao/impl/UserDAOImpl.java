package com.miraglo.egas.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraglo.egas.dao.UserDAO;
import com.miraglo.egas.dm.Hotel;
import com.miraglo.egas.dm.User;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory fact;

	@Override
	public User getByUserName(String username) {
		Session session = fact.getCurrentSession();
		Query query = session.createQuery("from User where username=:username");
		query.setString("username", username);
		List<User> users = query.list();
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@Override
	public User getByChallenge(String challenge) {
		Session session = fact.getCurrentSession();
		Query query = session.createQuery("from User where challenge=:challenge");
		query.setString("username", challenge);
		List<User> users = query.list();
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@Override
	public User getByUserNameAndHotel(String username, String hotelname) {
		// TODO Auto-generated method stub
		return null;
	}

}
