package com.example.training.inheritance.singletable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Discriminator_type", discriminatorType = DiscriminatorType.STRING)
public class Vehical {

	@Id
	@GeneratedValue
	private long vehicalId;
	private String vehicalName;

	public Vehical() {
	}

	public Vehical(long vehicalId, String vehicalName) {
		super();
		this.vehicalId = vehicalId;
		this.vehicalName = vehicalName;
	}

	public long getVehicalId() {
		return vehicalId;
	}

	public void setVehicalId(long vehicalId) {
		this.vehicalId = vehicalId;
	}

	public String getVehicalName() {
		return vehicalName;
	}

	public void setVehicalName(String vehicalName) {
		this.vehicalName = vehicalName;
	}

}
