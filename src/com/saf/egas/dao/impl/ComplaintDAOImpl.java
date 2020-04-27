package com.miraglo.egas.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miraglo.egas.dao.ComplaintDAO;
import com.miraglo.egas.dm.Complaint;

@Repository
public class ComplaintDAOImpl implements ComplaintDAO{
	@Autowired
	SessionFactory fact;
/**
 * This method saves the complaint
 * @param complaint type
 * @return the complaint
 */
	@Override
	public Complaint add(Complaint complaint) {
		Session se=fact.getCurrentSession();
		se.save(complaint);
		return complaint;
	}
/**
 * This method deletes the complaint
 * @param complaint type
 * @return Boolean value
 */
	@Override
	public Boolean remove(Complaint complaint) {
		Session session = fact.getCurrentSession();
		Query query = session.createQuery("delete Complaint where complaintId=:complaintId");
		query.setLong("complaintId", complaint.getComplaintId());
		int result = query.executeUpdate();
		return result > 0;
	}
	/**
	 * This method updates the complaint
	 * @param complaint type
	 * @return complaint
	 */

	@Override
	public Complaint update(Complaint complaint) {
		Session session=fact.getCurrentSession();
		session.update(complaint);
		return complaint;
	}
/**
 * This method gets the Complaint by ComplaintId
 * @param ComplaintId as Long type
 * @return the Complaint
 */
	@Override
	public Complaint getById(Long complaintId) {
		Session session = fact.getCurrentSession();
		Query query = session.createQuery("from Complaint where complaintId=:complaintId");
		query.setLong("complaintId", complaintId);
		List<Complaint> complaint = query.list();
		if (complaint.size() > 0) {
			return complaint.get(0);
		} else {
			return null;

		}
	}
}
