package com.miraglo.egas.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.web.jsf.FacesContextUtils;

@Entity
public class User {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long user_id;
@Column(nullable=false)
private String username;
@Column
private String password;
@OneToOne
private UserClass userClass;
@Column
private String userToken;
@Column
private String hotelname;

public Long getUser_id() {
	return user_id;
}
public void setUser_id(Long user_id) {
	this.user_id = user_id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public UserClass getUserClass() {
	return userClass;
}
public void setUserClass(UserClass userClass) {
	this.userClass = userClass;
}
public String getUserToken() {
	return userToken;
}
public void setUserToken(String userToken) {
	this.userToken = userToken;
}
public String getHotelname() {
	return hotelname;
}
public void setHotelname(String hotelname) {
	this.hotelname = hotelname;
}


}
