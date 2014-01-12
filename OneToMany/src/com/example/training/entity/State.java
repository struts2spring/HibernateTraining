package com.example.training.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STATE")
public class State {

	@Id
	@Column(name = "State_Name")
	private String stateName;
	@Column(name = "State_Population")
	long statePopulation;

	public State() {

	}

	public State(String stateName, long statePopulation) {
		super();
		this.stateName = stateName;
		this.statePopulation = statePopulation;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public long getStatePopulation() {
		return statePopulation;
	}

	public void setStatePopulation(long statePopulation) {
		this.statePopulation = statePopulation;
	}
}
