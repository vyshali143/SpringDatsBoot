package com.sathya.orm.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sathya.orm.entity.Hospital;
import com.sathya.orm.model.HospitalDetails;
import com.sathya.orm.repository.HospitalRepository;

public class HospitalService {

	@Autowired
	HospitalRepository hospitalRepository;
	
	public Hospital createHospital(HospitalDetails hospitalDetails)
	{
		//Reading the data from model class and set the data to entity class
		Hospital hospital = new Hospital();
		
		hospital.setName(hospitalDetails.getName());
		hospital.setLocation(hospitalDetails.getLocation());
		hospital.setRating(hospitalDetails.getRating());
		hospital.setEmail(hospitalDetails.getEmail());
		hospital.setMobile(hospitalDetails.getMobile());
		
		hospital.setCreatedAt(LocalDateTime.now());
		hospital.setCreatedBy(System.getProperty("user.name"));
		
		//save method create save the hospital in database return the hospital
		
		Hospital savedHospital = hospitalRepository.save(hospital);
		return savedHospital;
	}
	
	public Hospital getHospital(long id)
	{
		Optional<Hospital> hospital = hospitalRepository.findById(id);
		
		if(hospital.isPresent())
		{
			return hospital.get();
		}
		else
		{
			return null;
		}
	}
	
	public List<Hospital> getHospitals()
	{
		List<Hospital> hospitals = hospitalRepository.findAll();
		return hospitals;
	}
	
	public void deleteById(long id)
	{
		hospitalRepository.deleteById(id);
	}

	public List<Hospital> createHospitals(List<HospitalDetails> hospitalDetails)
	{
		List<Hospital> hospitals = new ArrayList<>();
		
		//Reading the data from model class and set to entity class
		for(HospitalDetails hdetails : hospitalDetails)
		{
			Hospital hospital = new Hospital();
			hospital.setName(hdetails.getName());
			hospital.setLocation(hdetails.getLocation());
			hospital.setRating(hdetails.getRating());
			hospital.setEmail((hdetails).getEmail());
			hospital.setMobile((hdetails).getMobile());
			
			hospital.setCreatedAt(LocalDateTime.now());
			hospital.setCreatedBy(System.getProperty("user.name"));
			
			hospitals.add(hospital);
		}
		return hospitalRepository.saveAll(hospitals);
	}

}
