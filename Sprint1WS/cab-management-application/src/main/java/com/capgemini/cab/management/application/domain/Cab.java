package com.capgemini.cab.management.application.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cabs")
public class Cab {

	/*
	 * Id is unique for each cab and non-null, it is useful to find a cab
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*
	 * this field specifies which type of car it is, like sedan or suv, etc
	 */
	@Column(name = "car_type"
			, nullable = false)
	private String carType;
	
	/*
	 * this field specifies the rate of a specific car type per km
	 */
	@Column(name = "per_km_rate"
			, nullable = false)
	private float perKmRate;
}
