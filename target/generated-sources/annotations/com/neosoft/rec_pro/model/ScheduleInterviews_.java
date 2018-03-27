package com.neosoft.rec_pro.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ScheduleInterviews.class)
public abstract class ScheduleInterviews_ {

	public static volatile SingularAttribute<ScheduleInterviews, Integer> scheduled_id;
	public static volatile SingularAttribute<ScheduleInterviews, Candidate> candidate;
	public static volatile SingularAttribute<ScheduleInterviews, String> fromUser;
	public static volatile SingularAttribute<ScheduleInterviews, FinalSelectionStatus> scheduledStatus;
	public static volatile SingularAttribute<ScheduleInterviews, Date> scheduled_date;
	public static volatile SingularAttribute<ScheduleInterviews, User> user;
	public static volatile SingularAttribute<ScheduleInterviews, String> email_subject;

}

