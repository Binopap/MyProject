package com.miraglo.egas.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserClass {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long userclassId;
@Column(unique=true,nullable=false)
String userclassName;
public Long getUserclassId() {
	return userclassId;
}
public void setUserclassId(Long userclassId) {
	this.userclassId = userclassId;
}
public String getUserclassName() {
	return userclassName;
}
public void setUserclassName(String userclassName) {
	this.userclassName = userclassName;
}

}
