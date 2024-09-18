package com.iiht.restjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long productId;
	private String description;
	private double price;

}
