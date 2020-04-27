package com.miraglo.egas.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraglo.egas.dao.BillDAO;
import com.miraglo.egas.dm.Bill;
import com.miraglo.egas.dm.Guest;
@Repository
public class BillDAOImpl implements BillDAO {

	@Autowired
	SessionFactory fact;
	@Override
	public Bill getBillByGuest(Guest guest) {
		Session session=fact.getCurrentSession();
		Query query=session.createQuery("from Bill where guest=:guest ");
	query.setEntity("guest", guest);
		return (Bill) query.list().get(0);
	}

}
