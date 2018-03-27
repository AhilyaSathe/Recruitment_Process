package com.neosoft.rec_pro.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Status.class)
public abstract class Status_ {

	public static volatile SingularAttribute<Status, SelectionType> selectionType;
	public static volatile SingularAttribute<Status, Integer> statusId;
	public static volatile SingularAttribute<Status, SelectionStatus> selectionStatus;
	public static volatile SingularAttribute<Status, FinalSelectionStatus> finalStatus;

}

