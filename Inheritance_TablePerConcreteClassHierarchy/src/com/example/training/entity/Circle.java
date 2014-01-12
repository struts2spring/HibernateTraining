package com.example.training.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CIRCLE")
public class Circle extends Shape {

	@Column(name = "Circle_Radius")
	int radius;

	public Circle() {

	}

	public Circle(String shapeName, int radius) {
		super(shapeName);
		this.radius = radius;

	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
