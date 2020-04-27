package com.miraglo.services;

import com.miraglo.egas.dm.Complaint;

public interface ComplaintService {
	
	public Complaint add(Complaint complaint);

	public Boolean remove(Complaint complaint);

	public Complaint update(Complaint complaint);

	public Complaint getById(Long complaintId);

}
