package com.neosoft.rec_pro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="employment_details")
public class Employment_Details
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer empDetails_id;
	private String cmp_name;
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public Integer getEmpDetails_id() {
		return empDetails_id;
	}
	public void setEmpDetails_id(Integer empDetails_id) {
		this.empDetails_id = empDetails_id;
	}
	public String getCmp_name() {
		return cmp_name;
	}
	public void setCmp_name(String cmp_name) {
		this.cmp_name = cmp_name;
	}
	public String getFrom_date() {
		return from_date;
	}
	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}
	public String getTo_date() {
		return to_date;
	}
	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getLast_salary_drawn() {
		return last_salary_drawn;
	}
	public void setLast_salary_drawn(String last_salary_drawn) {
		this.last_salary_drawn = last_salary_drawn;
	}
	public String getReason_of_leaving() {
		return reason_of_leaving;
	}
	public void setReason_of_leaving(String reason_of_leaving) {
		this.reason_of_leaving = reason_of_leaving;
	}
	private String from_date;
	private String to_date;
	private String designation;
	private String last_salary_drawn;
	private String reason_of_leaving;

}
