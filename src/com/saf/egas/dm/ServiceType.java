package com.miraglo.egas.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="service_types")
public class ServiceType {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long serviceTypeId;
@Column(nullable=false)
private String serviceName;
@OneToOne(optional=false)
private Hotel hotel;

public Long getServiceTypeId() {
	return serviceTypeId;
}
public void setServiceTypeId(Long serviceTypeId) {
	this.serviceTypeId = serviceTypeId;
}
public String getServiceName() {
	return serviceName;
}
public void setServiceName(String serviceName) {
	this.serviceName = serviceName;
}
public Hotel getHotel() {
	return hotel;
}
public void setHotel(Hotel hotel) {
	this.hotel = hotel;
}


}
