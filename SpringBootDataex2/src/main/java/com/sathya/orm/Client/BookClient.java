package com.sathya.orm.Client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sathya.orm.Repository.BookRepository;
@Component
public class BookClient  implements CommandLineRunner{

	
	 @Autowired
		BookRepository bookRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		//to get author and isbn 
		List<String> books =bookRepository.getData();
		for(String book:books)
			{
			System.out.println(book);
			}
		
		//to get author count 
				int count =bookRepository.authorcount("ratan");
				System.out.println(count);
				
				//to get  distinct authors 
				List<String> list =bookRepository.authorDistinct();
				 System.out.println(list);
				
		
				
	}

}
