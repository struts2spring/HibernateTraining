package com.example.training.entity;

// Generated Jan 12, 2014 5:48:58 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Country generated by hbm2java
 */
@Entity
@Table(name = "COUNTRY", schema = "PUBLIC", catalog = "TEST")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "country")
public class Country implements java.io.Serializable {

	private int cnId;
	private String cnCode;
	private String cnName;
	private Set<Employee> employees = new HashSet<Employee>(0);
	private Set<Airport> airports = new HashSet<Airport>(0);

	public Country() {
	}

	public Country(int cnId) {
		this.cnId = cnId;
	}

	public Country(int cnId, String cnCode, String cnName, Set<Employee> employees, Set<Airport> airports) {
		this.cnId = cnId;
		this.cnCode = cnCode;
		this.cnName = cnName;
		this.employees = employees;
		this.airports = airports;
	}

	@Id
	@Column(name = "CN_ID", unique = true, nullable = false)
	public int getCnId() {
		return this.cnId;
	}

	public void setCnId(int cnId) {
		this.cnId = cnId;
	}

	@Column(name = "CN_CODE", length = 2)
	public String getCnCode() {
		return this.cnCode;
	}

	public void setCnCode(String cnCode) {
		this.cnCode = cnCode;
	}

	@Column(name = "CN_NAME", length = 40)
	public String getCnName() {
		return this.cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public Set<Airport> getAirports() {
		return this.airports;
	}

	public void setAirports(Set<Airport> airports) {
		this.airports = airports;
	}

}
