package com.neosoft.rec_pro.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;



@Entity
@Table(name="educational_details")
public class Educational_Details
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer edu_id;
	private String educationDegree;
	private String year_of_passing;
	private String fullOrPartTime;
	private String percentageOrClass;
	private String boardOrUniversity;
	
	/*@Column(columnDefinition = "BOOLEAN DEFAULT false")*/
	private Boolean certifications;
	
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	
	
	
	
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public Integer getEdu_id() {
		return edu_id;
	}
	public void setEdu_id(Integer edu_id) {
		this.edu_id = edu_id;
	}
	public String getEducationDegree() {
		return educationDegree;
	}
	public void setEducationDegree(String educationDegree) {
		this.educationDegree = educationDegree;
	}
	public String getYear_of_passing() {
		return year_of_passing;
	}
	public void setYear_of_passing(String year_of_passing) {
		this.year_of_passing = year_of_passing;
	}
	public String getFullOrPartTime() {
		return fullOrPartTime;
	}
	public void setFullOrPartTime(String fullOrPartTime) {
		this.fullOrPartTime = fullOrPartTime;
	}
	public String getPercentageOrClass() {
		return percentageOrClass;
	}
	public void setPercentageOrClass(String percentageOrClass) {
		this.percentageOrClass = percentageOrClass;
	}
	public String getBoardOrUniversity() {
		return boardOrUniversity;
	}
	public void setBoardOrUniversity(String boardOrUniversity) {
		this.boardOrUniversity = boardOrUniversity;
	}
	public Boolean getCertifications() {
		return certifications;
	}
	public void setCertifications(Boolean certifications) {
		this.certifications = certifications;
	}
	
	
	
}
