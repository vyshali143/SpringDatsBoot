package com.sathya.orm.model;

import java.time.LocalDateTime;
@Enti
@da
public class Person {
 
	
	private int Id;
	private String firstName;
	private String LastName;
	private String email;
	private int Age;
	
	@Creat
	private  LocalDateTime createdAt;
	@CreatedBy
	private String createdBy;
	
}
