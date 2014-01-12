package com.example.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class CompositeUser {

	@Id
	@GeneratedValue
	private long userId;
	private String userName;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
