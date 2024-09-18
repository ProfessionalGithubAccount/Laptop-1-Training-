package com.iiht.FeignProductService.service;

import java.util.List;

import com.iiht.FeignProductService.resource.Product;

public interface ProductService {

	List<Product> findAll();

	List<Product> findByCategory(String category);

	Product findById(int id);
}
