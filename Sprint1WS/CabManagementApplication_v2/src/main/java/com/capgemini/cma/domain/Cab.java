package com.capgemini.cma.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
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
	@NotBlank(message = "car type is required")
	private String carType;
	
	
	@NotBlank(message = "cabIdentifer is required")
	@Size(min = 4, max = 5, message = "Please use 4 to 5 characters only")
	@Column(updatable = false, unique = true)
	private String cabIdentifier;
	
	/*
	 * this field specifies the rate of a specific car type per km
	 */
	@Column(nullable = false)
	private float perKmRate;
	
	// OnetoOne with Backlog
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "cab")
	@JsonIgnore
	private Backlog backlog;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCabIdentifier() {
		return cabIdentifier;
	}

	public void setCabIdentifier(String cabIdentifier) {
		this.cabIdentifier = cabIdentifier;
	}

	public float getPerKmRate() {
		return perKmRate;
	}

	public void setPerKmRate(float perKmRate) {
		this.perKmRate = perKmRate;
	}

	public Backlog getBacklog() {
		return backlog;
	}

	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}
	
}
