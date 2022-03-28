package com.capgemini.cab.management.application.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cabs")
public class Cab {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "car_type"
			, nullable = false)
	private String carType;
	
	@Column(name = "per_km_rate"
			, nullable = false)
	private float perKmRate;

	public Cab() {
		
	}

	public Cab(String carType, float perKmRate) {
		super();
		this.carType = carType;
		this.perKmRate = perKmRate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public float getPerKmRate() {
		return perKmRate;
	}

	public void setPerKmRate(float perKmRate) {
		this.perKmRate = perKmRate;
	}
	
	
}
