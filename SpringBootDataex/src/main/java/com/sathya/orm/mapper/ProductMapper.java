package com.sathya.orm.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sathya.orm.entity.ProductDetails;
import com.sathya.orm.model.Product;
@Component
public class ProductMapper {

	public Product modelToEntityConversion(ProductDetails productDetails)
	{

	   Product product = new Product();
	   product.setProId(productDetails.getProId());
	   product.setProName(productDetails.getProName());
	   product.setProPrice(productDetails.getProPrice());
	   product.setCreatedBy(System.getProperty("user.name"));
	   product.setCreatedAt(LocalDateTime.now());
	   
	   return product;
	}
	
	public List<Product> modelToListEntityConversion(List<ProductDetails> productDetails) {  
	List <Product> product=new ArrayList<Product>();
	
	for(ProductDetails prodetails:productDetails)
	{
	Product pro=new Product();	
	
	pro.setProId(prodetails.getProId());
	   pro.setProName(prodetails.getProName());
	   pro.setProPrice(prodetails.getProPrice());
	   pro.setCreatedBy(System.getProperty("user.name"));
	   pro.setCreatedAt(LocalDateTime.now());
	product.add(pro);

	}
	
	 return product;
	}
}
