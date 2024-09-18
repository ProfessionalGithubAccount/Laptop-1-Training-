package com.iiht.restjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

 @Entity
 
 @Table(name="ProductTable")

public class Product {

	@Id//primary key
	private long productId;
	private String description;
	private double price;

}
