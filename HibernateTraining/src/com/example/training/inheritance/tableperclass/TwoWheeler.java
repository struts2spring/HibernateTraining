package com.example.training.inheritance.tableperclass;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehical {

	private String streeingHandle;

	public String getStreeingHandle() {
		return streeingHandle;
	}

	public void setStreeingHandle(String streeingHandle) {
		this.streeingHandle = streeingHandle;
	}

}
