package com.miraglo.egas.services.impl;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miraglo.egas.dao.ComplaintDAO;
import com.miraglo.egas.dm.Complaint;
import com.miraglo.services.ComplaintService;

@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class ComplaintServiceImpl implements ComplaintService {

	@Autowired
	ComplaintDAO complaintDAO;
	
	@Override
	public Complaint add(Complaint complaint) {		
		return complaintDAO.add(complaint);
	}

	@Override
	public Boolean remove(Complaint complaint) {		
		return complaintDAO.remove(complaint);
	}

	@Override
	public Complaint update(Complaint complaint) {		
		return complaintDAO.update(complaint);
	}

	@Override
	public Complaint getById(Long complaintId) {		
		return complaintDAO.getById(complaintId);
	}
}
