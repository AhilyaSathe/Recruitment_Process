package com.neosoft.rec_pro.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FeedBack.class)
public abstract class FeedBack_ {

	public static volatile SingularAttribute<FeedBack, String> communicationStatus;
	public static volatile SingularAttribute<FeedBack, SelectionStatus> selectionStatus;
	public static volatile SingularAttribute<FeedBack, FinalSelectionStatus> finalStatus;
	public static volatile SingularAttribute<FeedBack, String> comment;
	public static volatile SingularAttribute<FeedBack, String> technicalStatus;
	public static volatile SingularAttribute<FeedBack, String> interviewRound;
	public static volatile SingularAttribute<FeedBack, Candidate> user;
	public static volatile SingularAttribute<FeedBack, Integer> feedBackId;
	public static volatile SingularAttribute<FeedBack, String> Date;

}

