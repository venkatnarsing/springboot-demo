package com.demo.springboot;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class ProductRepository {
	
 @PersistenceContext
 private EntityManager entityManager;
 
 public long createProduct(Product product) {
  entityManager.persist(product);
  return product.getId();
 }
 
 public Product find(long id) {
  return entityManager.find(Product.class, id);
 }
 
 public List <Product> findAll() {
  Query query = entityManager.createNamedQuery("query_find_all_products", Product.class);
  return query.getResultList();
 }
}
