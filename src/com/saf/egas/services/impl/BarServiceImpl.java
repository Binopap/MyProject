package com.miraglo.egas.services.impl;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miraglo.egas.dao.BarDao;
import com.miraglo.egas.dm.Bar;
import com.miraglo.services.BarService;
@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class BarServiceImpl implements BarService{

	@Autowired
	BarDao bardao;
	
	@Override
	public Bar getByName(String name) {
		// TODO Auto-generated method stub
		return bardao.getByName(name);
	}

	@Override
	public Bar getById(Long id) {
		// TODO Auto-generated method stub
		return bardao.getById(id);
	}

	@Override
	public Bar add(Bar bar) {
		// TODO Auto-generated method stub
		return bardao.add(bar);
	}

	@Override
	public Bar update(Bar bar) {
		// TODO Auto-generated method stub
		return bardao.update(bar);
	}

	@Override
	public Boolean delete(Bar bar) {
		// TODO Auto-generated method stub
		return bardao.delete(bar);
	}

}
