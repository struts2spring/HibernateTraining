package com.example.training.inheritance.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Bike")
public class TwoWheeler extends Vehical {

	private String streeingHandle;

	public String getStreeingHandle() {
		return streeingHandle;
	}

	public void setStreeingHandle(String streeingHandle) {
		this.streeingHandle = streeingHandle;
	}

}
