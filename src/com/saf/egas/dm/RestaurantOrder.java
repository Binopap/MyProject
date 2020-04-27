package com.miraglo.egas.dm;

import java.util.List;
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
@Table(name = "restaurant_orders")
public class RestaurantOrder {
	public static final Integer ORDER_FRESH = 1;
	public static final Integer ORDER_ATTENDED = 2;
	public static final Integer ORDER_PREPARED = 3;
	public static final Integer ORDER_BEING_DELIVERED_TO_ROOM = 4;
	public static final Integer ORDER_DELIVERED_TO_RESTAURANT = 5;
	public static final Integer ORDER_DELIVERED = 6;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	@ManyToMany
	private List<Food> items;
	@Column
	private Boolean roomDelivery;
	@Column
	private Integer status;
	@OneToOne
	private Cook cook;
	@Column
	private Double OrderTotal;
	@Column
	private Date orderTime;
	@Column
	private String hotelName;
	@Column
	private Date orderDeliveryTime;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public List<Food> getItems() {
		return items;
	}

	public void setItems(List<Food> items) {
		this.items = items;
	}

	public Boolean getRoomDelivery() {
		return roomDelivery;
	}

	public void setRoomDelivery(Boolean roomDelivery) {
		this.roomDelivery = roomDelivery;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Cook getCook() {
		return cook;
	}

	public void setCook(Cook cook) {
		this.cook = cook;
	}

	public Double getOrderTotal() {
		return OrderTotal;
	}

	public void setOrderTotal(Double orderTotal) {
		OrderTotal = orderTotal;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Date getOrderDeliveryTime() {
		return orderDeliveryTime;
	}

	public void setOrderDeliveryTime(Date orderDeliveryTime) {
		this.orderDeliveryTime = orderDeliveryTime;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	

}
