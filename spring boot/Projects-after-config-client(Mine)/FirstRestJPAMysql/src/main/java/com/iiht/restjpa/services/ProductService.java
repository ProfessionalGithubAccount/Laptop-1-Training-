package com.iiht.restjpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.restjpa.entity.Product;
import com.iiht.restjpa.repository.ProductRepository;

@Service
public class ProductService {
//Servcice always have dependency on repository..therefore we use autowired

	@Autowired
	ProductRepository repository;

	public Product save(Product product) {
		return repository.save(product);

	}

	public Product fetch(long productId) {
		// Purpose of optional is to deal with null ..so that it wont throw null ointer
		// exception
		java.util.Optional<Product> opp = repository.findById(productId);// This will find by primary id
		if (opp.isPresent()) {
			return opp.get();
		} else {
			return null;
		}
	}

	public List<Product> fetchAll() {
		return repository.findAll();
	}

	/*
	 * public Product update(long id, String desc, double price) { // TODO
	 * Auto-generated method stub return repository.save(new
	 * Product(id,desc,price)); }
	 */

	
	 public Product update(long id,Product product) { 
		 java.util.Optional<Product> opp=repository.findById(id);
		 if(opp.isPresent()) { 
			 return repository.save(product); }
		 else { 
			return null;//throw NullPointerException;//We cant write any print statements so directly give the exception 
				}
	 
	 }
	 

	public void delete(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	public void deleteAll() {
		repository.deleteAll();
		// TODO Auto-generated method stub

	}
}
