package com.demo.springboot;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

@RestController
@EnableAutoConfiguration
@ComponentScan
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;

	@RequestMapping("/products")
	ResponseEntity<List<Product>> getProducts() {
		
		List<Product> products = new ArrayList<Product>();
		products = productRepository.findAll();
		
		//To resolve CORS issue.
		HttpHeaders responseHeaders = new HttpHeaders();		
		responseHeaders.set("Access-Control-Allow-Origin", "*");
		System.out.println("Returning Products Info");
		
		return new ResponseEntity<List<Product>>(products, responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	ResponseEntity<Product> createProduct(@RequestBody Product product) {
		
		System.out.println("from Created new product");
		
		Long id = productRepository.createProduct(product);
		product.setId(id);
		System.out.println("Created new product with ID:" + id);
		
		//To resolve CORS issue.
		HttpHeaders responseHeaders = new HttpHeaders();		
		responseHeaders.set("Access-Control-Allow-Origin", "*");		
		
		return new ResponseEntity<Product>(product, responseHeaders, HttpStatus.OK);
	}	

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ProductController.class, args);
	}

}
