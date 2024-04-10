package com.sathya.orm.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sathya.orm.entity.PersonDetails;
import com.sathya.orm.mapper.PersonMapper;
import com.sathya.orm.model.Person;

@Component
public class PersonClient implements CommandLineRunner{

	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	PersonMapper personMapper;
	
	PersonDetails personDetails = new PersonDetails();

	@Override
	public void run(String... args) throws Exception {
		// Model class data :having the values
		
	personDetails.setId(101);
	personDetails.setFirstName("Modhu");
	personDetails.setLastName("Anke");
	personDetails.setEmail("pandi112@gmail.com");
	personDetails.setAge(25);
	
	//conversion of model class to entity
	Person person= personMapper.modelToEntityConversion(personDetails);
	personRepository.save(person);
	
	// Model class data :having the values
	PersonDetails personDetails1=new PersonDetails();
	personDetails1.setId(102);
	personDetails1.setFirstName("Bepi");
	personDetails1.setLastName("Bhaskaruni");
	personDetails1.setEmail("Kukka112@gmail.com");
	personDetails1.setAge(28);
	
	PersonDetails personDetails2=new PersonDetails();
	personDetails2.setId(103);
	personDetails2.setFirstName("Vyshnavi");
	personDetails2.setLastName("Atmakuru");
	personDetails2.setEmail("PichiKukka112@gmail.com");
	personDetails2.setAge(21);
	
	PersonDetails personDetails3=new PersonDetails();
	personDetails3.setId(104);
	personDetails3.setFirstName("Anil Kumar");
	personDetails3.setLastName("Munimadugu");
	personDetails3.setEmail("KitKatAnil@gmail.com");
	personDetails3.setAge(28);
	
	
	List<PersonDetails> personDetails=List.of(personDetails1,personDetails2,personDetails3);
	List<Person> person1=personMapper.modelToListEntityConversion(personDetails);
	personRepository.saveAll(person1);
	
	
	//personRepository.deleteById(1);
	
	//personRepository.deleteAll();
	
}
}