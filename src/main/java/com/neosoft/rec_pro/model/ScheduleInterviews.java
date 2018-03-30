package com.neosoft.rec_pro.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;






@Entity
@Table(name="schedule_interviews")
public class ScheduleInterviews implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer scheduled_id;
	
	private Integer toUserId;
	
	public Integer getToUserId() {
		return toUserId;
	}

	public void setToUserId(Integer toUserId) {
		this.toUserId = toUserId;
	}

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	 	
	public String getInterviewRound() {
		return interviewRound;
	}

	public void setInterviewRound(String interviewRound) {
		this.interviewRound = interviewRound;
	}

	public Interviewer getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(Interviewer interviewer) {
		this.interviewer = interviewer;
	}

	@ManyToOne
	@JoinColumn(name="candidate_Id")
	private Candidate candidate;
	
	@Column(columnDefinition="ENUM('select','reject','hold')",length = 100)
	@Enumerated(EnumType.STRING)
	private FinalSelectionStatus scheduledStatus;


	private Date scheduled_date;
	private String email_subject;
	
	private String interviewRound;
	@ManyToOne
	@JoinColumn(name="inerviewer_id")
	private Interviewer interviewer;
	
	

	

	private String fromUser;
	public FinalSelectionStatus getScheduledStatus() {
		return scheduledStatus;
	}

	public void setScheduledStatus(FinalSelectionStatus scheduledStatus) {
		this.scheduledStatus = scheduledStatus;
	}

	public String getEmail_subject() {
		return email_subject;
	}

	public void setEmail_subject(String email_subject) {
		this.email_subject = email_subject;
	}

	

	public Date getScheduled_date() {
		return scheduled_date;
	}

	public void setScheduled_date(Date scheduled_date) {
		this.scheduled_date = scheduled_date;
	}

	

	public Integer getScheduled_id() {
		return scheduled_id;
	}

	public void setScheduled_id(Integer scheduled_id) {
		this.scheduled_id = scheduled_id;
	}

	


	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

}
