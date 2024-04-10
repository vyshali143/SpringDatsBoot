package com.sathya.orm.client;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sathya.orm.model.Product;
import com.sathya.orm.entity.ProductDetails;
import com.sathya.orm.mapper.ProductMapper;
@Component
public class ProductClient implements CommandLineRunner{

		
		@Autowired
		ProductRepository productRepository;
		
		@Autowired
		ProductMapper productMapper;

		@Override
		public void run(String... args) throws Exception {
			// Model class data :having the values
			
			ProductDetails productDetails= new ProductDetails();
			productDetails.setProId(101);
			productDetails.setProName("Chinthapondu");
			productDetails.setProPrice(220);
			
			//conversion of model class to entity
			
			Product product=productMapper.modelToEntityConversion(productDetails);
			productRepository.save(product);
			
			
			
			
			
			// Model class data :having the values
			ProductDetails productDetails1= new ProductDetails();
			productDetails1.setProId(102);
			productDetails1.setProName("Sugar");
			productDetails1.setProPrice(20);
			
			ProductDetails productDetails2= new ProductDetails();
			productDetails2.setProId(103);
			productDetails2.setProName("Salt");
			productDetails2.setProPrice(40);
			
			
			List<ProductDetails> proDetails = List.of(productDetails1,productDetails2);
			//conversion of model class to entity
			 List <Product> products=productMapper.modelToListEntityConversion(proDetails);	
			productRepository.saveAll(products);
	
			
		Optional<Product> Op=productRepository.findById(102);
		if(Op.isPresent())
		{
			System.out.println(Op);
		}
		else
		{
			System.out.println("The required Product is not available");
		}
		
		
	Long l=	productRepository.count();
	System.out.println("The number of products :"+l);
	
		
		List<Product> lp=productRepository.findAll();
		
		for(Product product1:lp)
		{
			System.out.println(product1);
		}
		
		boolean status=productRepository.existsById(101);
		System.out.println(status);
		
		productRepository.deleteById(102);
		
		productRepository.deleteAll();
}
}
