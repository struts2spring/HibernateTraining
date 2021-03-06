package com.example.training.entity;

// Generated Jan 12, 2014 5:48:58 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EmployeeSpeaksLanguageId generated by hbm2java
 */
@Embeddable
public class EmployeeSpeaksLanguageId implements java.io.Serializable {

	private int empId;
	private int lanId;

	public EmployeeSpeaksLanguageId() {
	}

	public EmployeeSpeaksLanguageId(int empId, int lanId) {
		this.empId = empId;
		this.lanId = lanId;
	}

	@Column(name = "EMP_ID", nullable = false)
	public int getEmpId() {
		return this.empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	@Column(name = "LAN_ID", nullable = false)
	public int getLanId() {
		return this.lanId;
	}

	public void setLanId(int lanId) {
		this.lanId = lanId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EmployeeSpeaksLanguageId))
			return false;
		EmployeeSpeaksLanguageId castOther = (EmployeeSpeaksLanguageId) other;

		return (this.getEmpId() == castOther.getEmpId()) && (this.getLanId() == castOther.getLanId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getEmpId();
		result = 37 * result + this.getLanId();
		return result;
	}

}
