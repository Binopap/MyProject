package com.miraglo.egas.services.impl;

import java.util.ArrayList;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miraglo.egas.dao.BeveragesDao;
import com.miraglo.egas.dm.Bar;
import com.miraglo.egas.dm.Beverages;
import com.miraglo.services.BeverageService;
@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class BeverageServiceImpl implements BeverageService{

	@Autowired
	BeveragesDao beveragesdao;
	@Override
	public ArrayList<Beverages> getBeveragesListForBar(Bar bar) {
		// TODO Auto-generated method stub
		return beveragesdao.getBeveragesListForBar(bar);
	}

	@Override
	public Beverages addBeverages(Beverages beverage) {
		// TODO Auto-generated method stub
		return beveragesdao.addBeverages(beverage);
	}

	@Override
	public Boolean removeBeverages(Beverages beverage) {
		// TODO Auto-generated method stub
		return beveragesdao.removeBeverages(beverage);
	}

	@Override
	public Beverages getBeveragesById(Long fid) {
		// TODO Auto-generated method stub
		return beveragesdao.getBeveragesById(fid);
	}

	@Override
	public Boolean deleteBeveragesById(Long id) {
		// TODO Auto-generated method stub
		return beveragesdao.deleteBeveragesById(id);
	}

}
