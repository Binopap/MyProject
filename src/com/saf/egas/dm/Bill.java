package com.miraglo.egas.dm;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="bills")
public class Bill {
	@Transient
	public static final Integer BILLSTATUS_PENDING=0;
	public static final Integer BILLSTATUS_DUE=0;
	public static final Integer BILLSTATUS_CANCELLED=0;
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long bill_id;
@Column
private String bill_no;

@OneToOne(fetch=FetchType.EAGER)
private Guest guest;

public Integer getBillstatus() {
	return billstatus;
}
public void setBillstatus(Integer billstatus) {
	this.billstatus = billstatus;
}
@Column
private Double totalamount;
@Column
private Date date;
@Column
private Integer billstatus;
@Column
private String deletereason;
public String getDeletereason() {
	return deletereason;
}
public void setDeletereason(String deletereason) {
	this.deletereason = deletereason;
}

@ManyToMany(cascade=CascadeType.ALL)
@LazyCollection(LazyCollectionOption.FALSE)
private List<BillItem> billitems;

public Long getBill_id() {
	return bill_id;
}
public void setBill_id(Long bill_id) {
	this.bill_id = bill_id;
}
public String getBill_no() {
	return bill_no;
}
public void setBill_no(String bill_no) {
	this.bill_no = bill_no;
}

public Double getTotalamount() {
	return totalamount;
}
public void setTotalamount(Double totalamount) {
	this.totalamount = totalamount;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}

public List<BillItem> getBillitems() {
	return billitems;
}
public void setBillitems(List<BillItem> billitems) {
	this.billitems = billitems;
}



}
