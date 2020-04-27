package com.miraglo.egas.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miraglo.egas.dao.UserDAO;
import com.miraglo.egas.dm.User;
import com.miraglo.services.UserService;
import com.wordnik.swagger.annotations.Api;

@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class UserServiceImpl implements UserService{
@Autowired
UserDAO userDao;
	@Override
	public User getUserByUserName(String username) {
		// TODO Auto-generated method stub
		return userDao.getByUserName(username);
	}

}
