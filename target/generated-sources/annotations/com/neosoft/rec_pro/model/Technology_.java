package com.neosoft.rec_pro.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Technology.class)
public abstract class Technology_ {

	public static volatile SetAttribute<Technology, Candidate> candidate;
	public static volatile SingularAttribute<Technology, Integer> tech_id;
	public static volatile SingularAttribute<Technology, String> technology;
	public static volatile SetAttribute<Technology, User> users;

}

