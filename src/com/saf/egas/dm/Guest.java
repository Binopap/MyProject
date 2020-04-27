package com.miraglo.egas.dm;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity 
@Table(name="guests")
public class Guest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guestId;
	@Column(nullable = false)
	private String firstName;
	@Column
	private String LastName;
	@Column
	private String nationality;
	
	@OneToOne(fetch=FetchType.EAGER)
	private IdProof idproof;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Allergen> allergens;
	
	@OneToOne(fetch=FetchType.EAGER)
	private Hotel hotel;
	
	@Column(nullable = true)
	private String otherAllergen;
	@Column
	private Boolean isActive = false;
	@Column
	private String imei;

	@Column
	public Long getGuestId() {
		return guestId;
	}

	public void setGuestId(Long guestId) {
		this.guestId = guestId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public IdProof getIdproof() {
		return idproof;
	}

	public void setIdproof(IdProof idproof) {
		this.idproof = idproof;
	}

	public List<Allergen> getAllergens() {
		return allergens;
	}

	public void setAllergens(List<Allergen> allergens) {
		this.allergens = allergens;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String getOtherAllergen() {
		return otherAllergen;
	}

	public void setOtherAllergen(String otherAllergen) {
		this.otherAllergen = otherAllergen;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

}
