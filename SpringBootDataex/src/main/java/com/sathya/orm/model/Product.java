package com.sathya.orm.model;

import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
	@Id
	private int ProId;
	private String ProName;
	private double ProPrice;

	
	@CreatedDate
	private LocalDateTime createdAt;
	@CreatedBy
	private String createdBy;
	
	

}

