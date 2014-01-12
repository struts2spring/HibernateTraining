package com.example.training.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRY")
public class Country {

	@Id
	@Column(name = "Country_Name")
	String countryName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "COUNTRY_STATE", joinColumns = { @JoinColumn(name = "Country_Name") }, inverseJoinColumns = { @JoinColumn(name = "State_Name") })
	Collection<State> listOfStates = new ArrayList<State>();

	@Column(name = "Country_Population")
	long countryPopulation;

	public Country() {

	}

	public Country(String countryName, long countryPopulation) {
		this.countryName = countryName;
		this.countryPopulation = countryPopulation;
	}

	public long getCountryPopulation() {
		return countryPopulation;
	}

	public void setCountryPopulation(long countryPopulation) {
		this.countryPopulation = countryPopulation;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Collection<State> getListOfStates() {
		return listOfStates;
	}

	public void setListOfStates(Collection<State> listOfStates) {
		this.listOfStates = listOfStates;
	}
}
