package com.example.training.one_to_one;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CAPITAL")
public class Capital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Capital_Name")
	private String capitalName;

	@Column(name = "Capital_Population")
	private long capitalPopulation;

	public Capital() {

	}

	public Capital(String capitalName, long capitalPopulation) {
		super();
		this.capitalName = capitalName;
		this.capitalPopulation = capitalPopulation;
	}

	public String getCapitalName() {
		return capitalName;
	}

	public void setCapitalName(String capitalName) {
		this.capitalName = capitalName;
	}

	public long getCapitalPopulation() {
		return capitalPopulation;
	}

	public void setCapitalPopulation(long capitalPopulation) {
		this.capitalPopulation = capitalPopulation;
	}

}
