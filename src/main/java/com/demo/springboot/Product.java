package com.demo.springboot;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(query = "select p from Product p", name = "query_find_all_products")
public class Product implements Serializable{
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	public Product() {}
	
	public Product(String pName) {
		this.name = pName;
	}
	
	public Product(Long id, String pName) {
		this.id = id;
		this.name = pName;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return this.id;
	}
}
