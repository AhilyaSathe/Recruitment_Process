package com.neosoft.rec_pro.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GeneratorType;

@Entity
public class ApplicationDetails
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer applicationDetailsId;
	private String candidateType;
	private Date application_date;
	private String positionAppliedFor;
	private String reference;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getApplicationDetailsId() {
		return applicationDetailsId;
	}
	public void setApplicationDetailsId(Integer applicationDetailsId) {
		this.applicationDetailsId = applicationDetailsId;
	}
	
	
	public String getCandidateType() {
		return candidateType;
	}
	public void setCandidateType(String candidateType) {
		this.candidateType = candidateType;
	}
	public Date getApplication_date() {
		return application_date;
	}
	public void setApplication_date(Date application_date) {
		this.application_date = application_date;
	}
	public String getPositionAppliedFor() {
		return positionAppliedFor;
	}
	public void setPositionAppliedFor(String positionAppliedFor) {
		this.positionAppliedFor = positionAppliedFor;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}


}
