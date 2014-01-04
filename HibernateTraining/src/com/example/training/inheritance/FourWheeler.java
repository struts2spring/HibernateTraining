package com.example.training.inheritance;

import javax.persistence.Entity;

@Entity
public class FourWheeler extends Vehical{

	private String streeingWheel;

	public String getStreeingWheel() {
		return streeingWheel;
	}

	public void setStreeingWheel(String streeingWheel) {
		this.streeingWheel = streeingWheel;
	}

}
