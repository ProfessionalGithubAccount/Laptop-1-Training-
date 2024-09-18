package com.iiht.restjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.restjpa.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
	/*
	 * The long is beacuse our primary key is long...basiclaly data type of primary
	 * key should be there
	 */

}
