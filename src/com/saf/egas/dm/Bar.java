package com.miraglo.egas.dm;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bar")
public class Bar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long barId;
	@Column
	private String barName;
	@Column
	private String contact;
	@Column
	private String rating_bar;
	@Column
	private String status_bar;
	
	@OneToOne(fetch=FetchType.EAGER)
	private Beverages bevereges;
	
	public Long getBarId() {
		return barId;
	}
	public void setBarId(Long barId) {
		this.barId = barId;
	}
	public String getBarName() {
		return barName;
	}
	public void setBarName(String barName) {
		this.barName = barName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public Beverages getBevereges() {
		return bevereges;
	}
	public void setBevereges(Beverages bevereges) {
		this.bevereges = bevereges;
	}
	public String getRating_bar() {
		return rating_bar;
	}
	public void setRating_bar(String rating_bar) {
		this.rating_bar = rating_bar;
	}
	public String getStatus_bar() {
		return status_bar;
	}
	public void setStatus_bar(String status_bar) {
		this.status_bar = status_bar;
	}
	
}
