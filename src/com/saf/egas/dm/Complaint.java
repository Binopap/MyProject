package com.miraglo.egas.dm;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "complaints")
public class Complaint {
	public static final Short STATUS_READ = 1;
	public static final Short STATUS_UNREAD = 1;
	public static final Short STATUS_REPLIED = 1;
	public static final Short STATUS_CLOSED = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long complaintId;
	@Column
	private String message;
	@OneToOne
	private Guest guest;
	@OneToOne
	private Hotel hotel;
	@Column
	private Date timestamp;
	@Column
	private String reply;

	@Column
	Short status;

	public Long getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(Long complaintId) {
		this.complaintId = complaintId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

}
