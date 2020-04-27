package com.miraglo.services;

import com.miraglo.egas.dm.Bill;
import com.miraglo.egas.dm.Guest;

public interface BillService {

	public Bill getBillByGuest(Guest guest);
}
