package com.neosoft.rec_pro.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name="candidate")
public class Candidate implements Serializable
{

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer candidate_id;
	
	@Column(name="first_name")
	private String firstName;

	
	@Column(name="last_name")
	private String lastName;
	private String experience;
	
	@ManyToOne
	@JoinColumn(name="tech_id")
	private Technology technology;
	
	private String username;
	private String password;
	private Date date_of_birth;
	private String gender;
	private String marital_status;
	private String emailId;
	private String cv;
	private String address;
	private String city;
	private String state;
	private Integer pincode;
	
	private Double currentCTC;
	private Double expectedCTC;
	private String noticePeriod;
	private String currentLocation;
	private Boolean openToRelocation;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="applicationDetailsId")
	private ApplicationDetails applicationDetails;
	
	@OneToMany(mappedBy="candidate",cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Educational_Details> educational_Details;
	
	@OneToMany(mappedBy="candidate",cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Employment_Details> employment_Details;
	
	@OneToMany(mappedBy="candidate",cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<ScheduleInterviews> scheduleInterviews;

	public Double getCurrentCTC() {
		return currentCTC;
	}
	public void setCurrentCTC(Double currentCTC) {
		this.currentCTC = currentCTC;
	}
	
	public Double getExpectedCTC() {
		return expectedCTC;
	}
	public void setExpectedCTC(Double expectedCTC) {
		this.expectedCTC = expectedCTC;
	}
	
	public String getNoticePeriod() {
		return noticePeriod;
	}
	public void setNoticePeriod(String noticePeriod) {
		this.noticePeriod = noticePeriod;
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	public Boolean getOpenToRelocation() {
		return openToRelocation;
	}
	public void setOpenToRelocation(Boolean openToRelocation) {
		this.openToRelocation = openToRelocation;
	}
	
	
	public Set<Employment_Details> getEmployment_Details() {
		return employment_Details;
	}
	public void setEmployment_Details(Set<Employment_Details> employment_Details) {
		this.employment_Details = employment_Details;
	}
	public Set<Educational_Details> getEducational_Details() {
		return educational_Details;
	}
	public void setEducational_Details(Set<Educational_Details> educational_Details) {
		this.educational_Details = educational_Details;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public ApplicationDetails getApplicationDetails() {
		return applicationDetails;
	}
	public void setApplicationDetails(ApplicationDetails applicationDetails) {
		this.applicationDetails = applicationDetails;
	}
	
	
	public Integer getCandidate_id() {
		return candidate_id;
	}
	public void setCandidate_id(Integer candidate_id) {
		this.candidate_id = candidate_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}
	public Technology getTechnology() {
		return technology;
	}
	public void setTechnology(Technology technology) {
		this.technology = technology;
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
	
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMarital_status() {
		return marital_status;
	}
	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public Set<ScheduleInterviews> getScheduleInterviews() {
		return scheduleInterviews;
	}
	public void setScheduleInterviews(Set<ScheduleInterviews> scheduleInterviews) {
		this.scheduleInterviews = scheduleInterviews;
	}
}