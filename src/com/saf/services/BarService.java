package com.miraglo.services;

import com.miraglo.egas.dm.Bar;

public interface BarService {
	public Bar getByName(String name);

	public Bar getById(Long id);

	public Bar add(Bar bar);

	public Bar update(Bar bar);

	public Boolean delete(Bar bar);

}
