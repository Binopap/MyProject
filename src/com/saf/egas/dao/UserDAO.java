package com.miraglo.egas.dao;

import com.miraglo.egas.dm.Hotel;
import com.miraglo.egas.dm.User;

public interface UserDAO {
public User getByUserName(String username);
public User getByChallenge(String challenge);
public User getByUserNameAndHotel(String username,String hotelname);
}
