package com.capgemini.cma.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Backlog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer CTsequence = 0;
	private String cabIdentifier;
	
	// OnetoOne with cab
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cab_id", nullable = false)
	@JsonIgnore
	private Cab cab;
	
	// OnetoMany with cabTask
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "backlog")
	private List<CabTask> cabTasks = new ArrayList<>();
	
	public Backlog() {
		super();
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCTsequence() {
		return CTsequence;
	}

	public void setCTsequence(Integer cTsequence) {
		CTsequence = cTsequence;
	}

	public String getCabIdentifier() {
		return cabIdentifier;
	}

	public void setCabIdentifier(String cabIdentifier) {
		this.cabIdentifier = cabIdentifier;
	}


	public List<CabTask> getCabTasks() {
		return cabTasks;
	}


	public void setCabTasks(List<CabTask> cabTasks) {
		this.cabTasks = cabTasks;
	}
	
	
}
