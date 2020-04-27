package com.miraglo.egas.dao;

import com.miraglo.egas.dm.Bar;

public interface BarDao {
	public Bar getByName(String name);

	public Bar getById(Long id);

	public Bar add(Bar hotel);

	public Bar update(Bar bar);

	public Boolean delete(Bar bar);
}
