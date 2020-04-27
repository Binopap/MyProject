package com.miraglo.egas.dm;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import net.miraglo.cms.dm.MedicalTestResult;

@Entity
@Table(name = "food_items")
public class Food {
	@Id
	private Long foodId;
	@Column
	private Boolean vegitarian;
	@Column
	private String name;
	@Column
	private String description;
	@ManyToMany(targetEntity = FoodIngredient.class,fetch=FetchType.EAGER)
	private List<FoodIngredient> ingredients;
	@Column
	private Double cost;
	@Column
	private Short spiciness;
	@Column
	private Short pungency;
	@Column
	private Double rating;
	@Column
	private String image;
	@OneToOne(optional=false)
	private Hotel hotel;
	
	public Long getFoodId() {
		return foodId;
	}
	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}
	public Boolean getVegitarian() {
		return vegitarian;
	}
	public void setVegitarian(Boolean vegitarian) {
		this.vegitarian = vegitarian;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<FoodIngredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<FoodIngredient> ingredients) {
		this.ingredients = ingredients;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Short getSpiciness() {
		return spiciness;
	}
	public void setSpiciness(Short spiciness) {
		this.spiciness = spiciness;
	}
	public Short getPungency() {
		return pungency;
	}
	public void setPungency(Short pungency) {
		this.pungency = pungency;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
}
