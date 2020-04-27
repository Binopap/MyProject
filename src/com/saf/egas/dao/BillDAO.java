package com.miraglo.egas.dao;

import com.miraglo.egas.dm.Bill;
import com.miraglo.egas.dm.Guest;

public interface BillDAO {

	public Bill getBillByGuest(Guest guest);
}
