package com.miraglo.egas.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="allergens")
public class Allergen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long allergenId;
	@Column
	private String allergenName;
	
	public Long getAllergenId() {
		return allergenId;
	}
	public void setAllergenId(Long allergenId) {
		this.allergenId = allergenId;
	}
	public String getAllergenName() {
		return allergenName;
	}
	public void setAllergenName(String allergenName) {
		this.allergenName = allergenName;
	}
	
	
}
