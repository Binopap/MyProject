package com.miraglo.egas.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * Gallery Directory organization
 * gallery.properties -> version=1
 * ----------Food
 * --------------Veg
 * -----------------description.txt
 * -----------------veg-pasta.png
 * -----------------veg-pasta.desc -------> Image Title / followed by desc
 * --------------NonVeg
 * ----------Hotel
 * -----------------
 * 
 */
@Entity
@Table(name="gallery")
public class Gallery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long galleryId;
	@Column
	private String description;
	@Column
	private Float version;
	@Column
	private String hotelName;
	public Long getGalleryId() {
		return galleryId;
	}
	public void setGalleryId(Long galleryId) {
		this.galleryId = galleryId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getVersion() {
		return version;
	}
	public void setVersion(Float version) {
		this.version = version;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
}
