package com.miraglo.egas.dm;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cooks")
public class Cook {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cookId;
	@Column
	private String fullname;
	@Column
	private Double rating;
	@Column
	private String photo;
	
	public Long getCookId() {
		return cookId;
	}
	public void setCookId(Long cookId) {
		this.cookId = cookId;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
