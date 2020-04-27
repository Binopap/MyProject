package com.miraglo.egas.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "service_requests")
public class ServiceRequest {
	public static final Short STATUS_NEW = 1;
	public static final Short STATUS_ATTENDED = 1;
	public static final Short STATUS_IN_PROGRESS = 1;
	public static final Short STATUS_RESOLVED = 1;
	public static final Short STATUS_CLOSED = 1;
	public static final Short STATUS_REJECTED = 1;
	@Id
	private Long requestId;
	@Column(nullable = false)
	private String complaint;
	@OneToOne(optional = false)
	private ServiceType type;
	@OneToOne(optional = false)
	private Hotel hotel;
	@Column
	private Short status;
	@OneToOne
	private Guest guest;

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	public ServiceType getType() {
		return type;
	}

	public void setType(ServiceType type) {
		this.type = type;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
