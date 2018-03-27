package com.neosoft.rec_pro.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="user")
public class User implements Serializable
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer user_id;
	private String name;
	private String username;
	private String password;
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

	private String gender;
	private String emailId;
	private String role;
	private String experience;
	
	 @ManyToOne
	 @JoinColumn(name="deptId")
	 private Department department;
	
	 @ManyToOne
	 @JoinColumn(name="tech_id")
	 private Technology technology;
	 
	 @OneToMany(mappedBy="user")
	 @JsonIgnore
	 private Set<ScheduleInterviews> scheduleInterview;
	 
	

	public Set<ScheduleInterviews> getScheduleInterview()
	{
		return scheduleInterview;
	}

	public void setScheduleInterview(Set<ScheduleInterviews> scheduleInterview) {
		this.scheduleInterview = scheduleInterview;
	}
	
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private Set<ApplicationDetails> applicationDetails;
	public Set<ApplicationDetails> getApplicationDetails() {
		return applicationDetails;
	}

	public void setApplicationDetails(Set<ApplicationDetails> applicationDetails) {
		this.applicationDetails = applicationDetails;
	}
	

}
