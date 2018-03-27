package com.neosoft.rec_pro.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ApplicationDetails.class)
public abstract class ApplicationDetails_ {

	public static volatile SingularAttribute<ApplicationDetails, String> candidateType;
	public static volatile SingularAttribute<ApplicationDetails, String> reference;
	public static volatile SingularAttribute<ApplicationDetails, Integer> applicationDetailsId;
	public static volatile SingularAttribute<ApplicationDetails, String> positionAppliedFor;
	public static volatile SingularAttribute<ApplicationDetails, Date> application_date;
	public static volatile SingularAttribute<ApplicationDetails, User> user;

}

