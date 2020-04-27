package com.miraglo.services;

import org.springframework.stereotype.Service;

import com.miraglo.egas.dm.User;

public interface UserService {

	User getUserByUserName(String username);

}
