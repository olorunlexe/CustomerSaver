package com.interswitch.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Customer.class)
public abstract class Customer_ {

	public static volatile SingularAttribute<Customer, String> password;
	public static volatile SingularAttribute<Customer, Date> dateCreated;
	public static volatile SingularAttribute<Customer, String> loginID;
	public static volatile SingularAttribute<Customer, Integer> mobileNumber;
	public static volatile SingularAttribute<Customer, String> name;
	public static volatile SingularAttribute<Customer, Integer> id;
	public static volatile SingularAttribute<Customer, Integer> accountNumber;
	public static volatile SingularAttribute<Customer, String> email;

}

