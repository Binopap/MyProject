package com.miraglo.egas.dm;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class ApiKey {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long apiId;
	@Column(unique = true, nullable = false)
	private String apikey;
	@Column(unique = true)
	private String token;
	@Column
	private Date lastLease;

	public Long getApiId() {
		return apiId;
	}

	public void setApiId(Long apiId) {
		this.apiId = apiId;
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getLastLease() {
		return lastLease;
	}

	public void setLastLease(Date lastLease) {
		this.lastLease = lastLease;
	}

}
