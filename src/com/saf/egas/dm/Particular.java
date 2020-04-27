package com.miraglo.egas.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="particulars")
public class Particular {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY) 
private Long particular_id;
@Column
private String particular_name;
@Column
private Double amount;
@Column
private Integer sbi;
@Column
private Long status=new Long(0);

public Integer getSbi() {
	return sbi;
}
public void setSbi(Integer sbi) {
	this.sbi = sbi;
}
public Long getParticular_id() {
	return particular_id;
}
public void setParticular_id(Long particular_id) {
	this.particular_id = particular_id;
}
public String getParticular_name() {
	return particular_name;
}
public void setParticular_name(String particular_name) {
	this.particular_name = particular_name;
}
public Double getAmount() {
	return amount;
}
public void setAmount(Double amount) {
	this.amount = amount;
}

}
