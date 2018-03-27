package com.neosoft.rec_pro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="status")
public class Status
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer statusId;
	
	@Column(columnDefinition = "ENUM('technical','communication','finalSelection')")
	private SelectionType selectionType;
	
	@Column(columnDefinition = "ENUM('good','average','excellent')")
	private SelectionStatus selectionStatus;
	
	@Column(columnDefinition="ENUM('select','reject','hold')")
	private FinalSelectionStatus finalStatus;
	
	
	

}
