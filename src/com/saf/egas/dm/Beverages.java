package com.miraglo.egas.dm;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="beverages")
public class Beverages {
	@Id
	private Long beverage_Id;
	@Column
	private String brandName;
	@Column
	private String drinkName;
	@Column
	private String description;
	@Column
	private Double cost;
	@Column
	private Short alcoholContent;
	@Column
	private long rating;
	@Column
	private String image;
	//@OneToOne(optional=false)
	//private Bar bar;
	@Column
	private Boolean status;
	@Column
	private String drinkAge;
	
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Short getAlcoholContent() {
		return alcoholContent;
	}
	public void setAlcoholContent(Short alcoholContent) {
		this.alcoholContent = alcoholContent;
	}
	public long getRating() {
		return rating;
	}
	public void setRating(long rating) {
		this.rating = rating;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getDrinkName() {
		return drinkName;
	}
	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}
	public String getDrinkAge() {
		return drinkAge;
	}
	public void setDrinkAge(String drinkAge) {
		this.drinkAge = drinkAge;
	}
	public Long getBeverage_Id() {
		return beverage_Id;
	}
	public void setBeverage_Id(Long beverage_Id) {
		this.beverage_Id = beverage_Id;
	}
	
}
