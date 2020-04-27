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
@Table(name="suggestions")
public class Suggestion {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long suggestionId;
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
