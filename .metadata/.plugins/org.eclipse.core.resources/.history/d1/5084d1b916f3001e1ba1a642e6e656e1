package com.sathya.orm.Test;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sathya.orm.Book;

@RestController
@RequestMapping("/api")
public class TestController {
	
	@GetMapping("/test")
	public String wish()
	{
		return "Hi bepi Good Morning";
	}	
	
	                                                                            
	@GetMapping("/wish/{name}")
	public String greet(@PathVariable String name)
	{
		return "Good Morning"+name;
	}

	
	@GetMapping("/info")
	public String info(@RequestParam String name)
	{
		return name+"retervtyrhd";
	}
	
	List<Book> books=List.of(new Book(101,"chandana","Harini",500),
							 new Book(102,"Bepi","Vathri",999),
							 new Book(103,"Madhu","Raji",850),
							 new Book(104,"Vyshu","Deedhu",1),
							 new Book(105,"Jaisri","Mahi",700));
	
	
			@GetMapping("/books")
			public List<Book> getBook(){
			return books;
		}
			
			
			@GetMapping("/getbook/{isbn}")
			public Book getBook(@PathVariable int isbn)
			{
				Book book=books.stream()
								.filter(b->b.getIsbn()==isbn)
								.findFirst()
								.get();
				return book;
			}
		
}                              