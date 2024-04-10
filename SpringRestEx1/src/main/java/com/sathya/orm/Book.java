package com.sathya.orm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {


	private int isbn;
	private String BookName;
	private String BookAuthor;
	private double BookPrice;
}