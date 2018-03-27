package com.neosoft.rec_pro.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> role;
	public static volatile SingularAttribute<User, String> gender;
	public static volatile SetAttribute<User, ScheduleInterviews> scheduleInterview;
	public static volatile SingularAttribute<User, Integer> user_id;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SetAttribute<User, ApplicationDetails> applicationDetails;
	public static volatile SingularAttribute<User, String> emailId;
	public static volatile SingularAttribute<User, Technology> technology;
	public static volatile SingularAttribute<User, String> experience;
	public static volatile SingularAttribute<User, Department> department;
	public static volatile SingularAttribute<User, String> username;

}

