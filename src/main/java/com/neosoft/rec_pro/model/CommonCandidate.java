package com.neosoft.rec_pro.model;

import java.util.Set;

import javax.persistence.Entity;


public class CommonCandidate
{
	private Candidate candidate;
	/*private ApplicationDetails applicationDetails;
	public ApplicationDetails getApplicationDetails() {
		return applicationDetails;
	}
	public void setApplicationDetails(ApplicationDetails applicationDetails) {
		this.applicationDetails = applicationDetails;
	}*/
	private Set<Educational_Details> educational_Details;
	private Set<Employment_Details> employment_Details;
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public Set<Educational_Details> getEducational_Details() {
		return educational_Details;
	}
	public void setEducational_Details(Set<Educational_Details> educational_Details) {
		this.educational_Details = educational_Details;
	}
	public Set<Employment_Details> getEmployment_Details() {
		return employment_Details;
	}
	public void setEmployment_Details(Set<Employment_Details> employment_Details) {
		this.employment_Details = employment_Details;
	}
	
}
