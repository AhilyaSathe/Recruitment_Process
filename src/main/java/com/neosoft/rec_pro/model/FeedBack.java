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
	
	@Column(columnDefinition="ENUM('first','second','third','finalRound')")
	private InterviewRounds interviewRounds;
	
	@Column(columnDefinition = "ENUM('technical','communication','finalSelection')")
	private SelectionType selectionType;
	
	@Column(columnDefinition = "ENUM('good','average','excellent')")
	private SelectionStatus selectionStatus;
	
	@Column(columnDefinition="ENUM('select','reject','hold')")
	private FinalSelectionStatus finalStatus;
	
	private String comment;
	private String Date;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Candidate user;
	

}
