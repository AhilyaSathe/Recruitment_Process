package com.neosoft.rec_pro.model;

import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="feedBack")
public class FeedBack 
{
	@Id
	private Integer feedBackId;
	
	private String technicalStatus;
	private String communicationStatus;
	
	public Integer getFeedBackId() {
		return feedBackId;
	}

	public void setFeedBackId(Integer feedBackId) {
		this.feedBackId = feedBackId;
	}

	public String getTechnicalStatus() {
		return technicalStatus;
	}

	public void setTechnicalStatus(String technicalStatus) {
		this.technicalStatus = technicalStatus;
	}

	public String getCommunicationStatus() {
		return communicationStatus;
	}

	public void setCommunicationStatus(String communicationStatus) {
		this.communicationStatus = communicationStatus;
	}

	

	public SelectionStatus getSelectionStatus() {
		return selectionStatus;
	}

	public void setSelectionStatus(SelectionStatus selectionStatus) {
		this.selectionStatus = selectionStatus;
	}

	public FinalSelectionStatus getFinalStatus() {
		return finalStatus;
	}

	public void setFinalStatus(FinalSelectionStatus finalStatus) {
		this.finalStatus = finalStatus;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public Candidate getUser() {
		return user;
	}

	public void setUser(Candidate user) {
		this.user = user;
	}

	/*@Column(columnDefinition="ENUM('first','second','third','finalRound')")*/
	private String interviewRound;
	
	/*@Column(columnDefinition = "ENUM('technical','communication','finalSelection')")
	private SelectionType selectionType;*/
	
	@Column(columnDefinition = "ENUM('good','average','excellent')")
	private SelectionStatus selectionStatus;
	
	public String getInterviewRound() {
		return interviewRound;
	}

	public void setInterviewRound(String interviewRound) {
		this.interviewRound = interviewRound;
	}

	@Column(columnDefinition="ENUM('select','reject','hold')")
	private FinalSelectionStatus finalStatus;
	
	private String comment;
	private String Date;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Candidate user;
	

}
