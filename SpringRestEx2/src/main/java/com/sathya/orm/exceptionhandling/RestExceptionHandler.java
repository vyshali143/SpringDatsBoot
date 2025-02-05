package com.sathya.orm.exceptionhandling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler 
{
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>>
	handleValidationExceptions(MethodArgumentNotValidException ex)
	{
		Map<String,String> errors=new HashMap<>();
		ex.getBindingResult()
		  .getAllErrors()
		  .forEach(error->{
			  String fieldName=((FieldError) error).getField();
			  String errormessage= error.getDefaultMessage();
			  errors.put(fieldName,errormessage);
		
		  });
		  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				               .header("status","its working")
				               .body(errors);
	}
	}

