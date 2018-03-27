package com.neosoft.rec_pro.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Educational_Details.class)
public abstract class Educational_Details_ {

	public static volatile SingularAttribute<Educational_Details, String> year_of_passing;
	public static volatile SingularAttribute<Educational_Details, String> percentageOrClass;
	public static volatile SingularAttribute<Educational_Details, Candidate> candidate;
	public static volatile SingularAttribute<Educational_Details, Integer> edu_id;
	public static volatile SingularAttribute<Educational_Details, String> educationDegree;
	public static volatile SingularAttribute<Educational_Details, String> boardOrUniversity;
	public static volatile SingularAttribute<Educational_Details, String> fullOrPartTime;
	public static volatile SingularAttribute<Educational_Details, Boolean> certifications;

}

