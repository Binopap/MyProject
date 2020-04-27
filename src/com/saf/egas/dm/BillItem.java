package com.miraglo.egas.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="billitems")
public class BillItem {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long billitem_id;
@Column
private Double amount;
@OneToOne(fetch=FetchType.EAGER)
private Particular particulars;
@Column
private Long quantity;
@Column
private Double discount;

public Long getBillitem_id() {
	return billitem_id;
}
public void setBillitem_id(Long billitem_id) {
	this.billitem_id = billitem_id;
}
public Double getAmount() {
	return amount;
}
public void setAmount(Double amount) {
	this.amount = amount;
}
public Particular getParticulars() {
	return particulars;
}
public void setParticulars(Particular particulars) {
	this.particulars = particulars;
}
public Long getQuantity() {
	return quantity;
}
public void setQuantity(Long quantity) {
	this.quantity = quantity;
}
public Double getDiscount() {
	return discount;
}
public void setDiscount(Double discount) {
	this.discount = discount;
}

}
