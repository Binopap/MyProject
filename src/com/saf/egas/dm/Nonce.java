package com.miraglo.egas.dm;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Nonce {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nonceId;
	@Column
	private String nonce;
	@Column
	private String leaseTime;
	@Column
	private Date lastAccess;
	@OneToOne
	private Guest guest;
	@OneToOne
	private User user;
	@Column
	Boolean userNonce = false;
	
	@OneToOne(fetch=FetchType.EAGER)
	private Hotel hotel;
	@Column
	private Boolean guestNonce;
	
	public Long getNonceId() {
		return nonceId;
	}
	public void setNonceId(Long nonceId) {
		this.nonceId = nonceId;
	}
	public String getNonce() {
		return nonce;
	}
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	public String getLeaseTime() {
		return leaseTime;
	}
	public void setLeaseTime(String leaseTime) {
		this.leaseTime = leaseTime;
	}
	
	public Guest getGuest() {
		return guest;
	}
	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Boolean getUserNonce() {
		return userNonce;
	}
	public void setUserNonce(Boolean userNonce) {
		this.userNonce = userNonce;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public Date getLastAccess() {
		return lastAccess;
	}
	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}
	public Boolean getGuestNonce() {
		return guestNonce;
	}
	public void setGuestNonce(Boolean guestNonce) {
		this.guestNonce = guestNonce;
	}
	
	
}
