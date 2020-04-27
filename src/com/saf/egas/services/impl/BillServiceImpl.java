package com.miraglo.egas.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miraglo.egas.dao.BillDAO;
import com.miraglo.egas.dm.Bill;
import com.miraglo.egas.dm.Guest;
import com.miraglo.services.BillService;

@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class BillServiceImpl implements BillService {

	@Autowired
	BillDAO billdao;
	@Override
	public Bill getBillByGuest(Guest guest) {
		
		return billdao.getBillByGuest(guest);
	}

}
