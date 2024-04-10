package com.sathya.orm.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sathya.orm.entity.PersonDetails;
import com.sathya.orm.model.Person;

@Component
public class PersonMapper {

	public Person modelToEntityConversion(PersonDetails personDetails)
		{

		   Person person = new Person();
		   person.setId(personDetails.getId());
		   person.setFirstName(personDetails.getFirstName());
		   person.setLastName(personDetails.getLastName());
		   person.setEmail(personDetails.getEmail());
		   person.setCreatedBy(System.getProperty("user.name"));
		   person.setCreatedAt(LocalDateTime.now());
		   
		   return person;
		}
		
		public List<Person> modelToListEntityConversion(List<PersonDetails> personDetails) {  
		List <Person> person=new ArrayList<Person>();
		
		for(PersonDetails persondetail:personDetails)
		{
		Person person1=new Person();	
		
		   person1.setId(persondetail.getId());
		   person1.setFirstName(persondetail.getFirstName());
		   person1.setLastName(persondetail.getLastName());
		   person1.setEmail(persondetail.getEmail());
		   person1.setCreatedBy(System.getProperty("user.name"));
		   person1.setCreatedAt(LocalDateTime.now());
		   
		   person.add(person1);
		}
		   return person;
		
		}
	}


