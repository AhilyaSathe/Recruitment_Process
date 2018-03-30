package com.neosoft.rec_pro.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Candidate.class)
public abstract class Candidate_ {

	public static volatile SingularAttribute<Candidate, String> lastName;
	public static volatile SingularAttribute<Candidate, String> gender;
	public static volatile SingularAttribute<Candidate, String> city;
	public static volatile SingularAttribute<Candidate, Date> date_of_birth;
	public static volatile SetAttribute<Candidate, Educational_Details> educational_Details;
	public static volatile SingularAttribute<Candidate, String> emailId;
	public static volatile SingularAttribute<Candidate, String> experience;
	public static volatile SingularAttribute<Candidate, Double> currentCTC;
	public static volatile SingularAttribute<Candidate, Integer> candidate_id;
	public static volatile SingularAttribute<Candidate, String> password;
	public static volatile SingularAttribute<Candidate, String> state;
	public static volatile SingularAttribute<Candidate, Double> expectedCTC;
	public static volatile SingularAttribute<Candidate, Integer> pincode;
	public static volatile SingularAttribute<Candidate, String> address;
	public static volatile SetAttribute<Candidate, Employment_Details> employment_Details;
	public static volatile SetAttribute<Candidate, ScheduleInterviews> scheduleInterviews;
	public static volatile SingularAttribute<Candidate, Technology> technology;
	public static volatile SingularAttribute<Candidate, String> currentLocation;
	public static volatile SingularAttribute<Candidate, String> noticePeriod;
	public static volatile SingularAttribute<Candidate, String> firstName;
	public static volatile SingularAttribute<Candidate, String> marital_status;
	public static volatile SingularAttribute<Candidate, String> cv;
	public static volatile SingularAttribute<Candidate, Boolean> openToRelocation;
	public static volatile SingularAttribute<Candidate, ApplicationDetails> applicationDetails;
	public static volatile SingularAttribute<Candidate, String> username;

}

