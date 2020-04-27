package com.miraglo.egas.dao;

import com.miraglo.egas.dm.Complaint;

public interface ComplaintDAO {
	public Complaint add(Complaint complaint);

	public Boolean remove(Complaint complaint);

	public Complaint update(Complaint complaint);

	public Complaint getById(Long complaintId);
}
