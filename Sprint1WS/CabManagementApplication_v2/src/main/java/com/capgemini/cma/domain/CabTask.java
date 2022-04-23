package com.capgemini.cma.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CabTask {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(updatable = false, unique = true)
	private String cabTaskSequence;
	
	@NotBlank(message = "Please include a cab task summary")
	private String summary;
	
	private String acceptanceCriteria;
	private String status;
	private Integer priority;
	private Date dueDate;
	
	// ManytoOne with backlog
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "backlog_id", updatable = false, nullable = false)
	@JsonIgnore
	private Backlog backlog;
	
	@Column(updatable = false)
	private String cabIdenntifier;
	
	private Date created_At;
	
	private Date updated_At;
	
	public CabTask() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCabTaskSequence() {
		return cabTaskSequence;
	}

	public void setCabTaskSequence(String cabTaskSequence) {
		this.cabTaskSequence = cabTaskSequence;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getAcceptanceCriteria() {
		return acceptanceCriteria;
	}

	public void setAcceptanceCriteria(String acceptanceCriteria) {
		this.acceptanceCriteria = acceptanceCriteria;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getCabIdenntifier() {
		return cabIdenntifier;
	}

	public void setCabIdenntifier(String cabIdenntifier) {
		this.cabIdenntifier = cabIdenntifier;
	}

	public Date getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}

	public Date getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}
	
	public Backlog getBacklog() {
		return backlog;
	}

	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}

	@PrePersist
	public void onCreate() {
		this.created_At = new Date();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updated_At = new Date();
	}
	
}
