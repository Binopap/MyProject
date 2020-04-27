package com.miraglo.egas.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "id_proof")
public class IdProof {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long proofId;
	@Column
	private String idType;
	@Column
	private String idNumber;
	
	public Long getProofId() {
		return proofId;
	}
	public void setProofId(Long proofId) {
		this.proofId = proofId;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	
	
}
