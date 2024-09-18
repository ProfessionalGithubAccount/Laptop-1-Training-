package com.iiht.rest.controllers;

import org.springframework.web.bind.annotation.*;

import com.iiht.rest.model.Product;
import com.iiht.rest.services.ProductService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping("/fetch/{id}")
	public ResponseEntity<Product> fetch(@PathVariable long id){
		if (productService.fetch(id).isPresent()) {
			return  ResponseEntity.ok().body(productService.fetch(id).get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping("/fetchall")
	public ResponseEntity<List<Product>> fetchAll(){
		return ResponseEntity.ok().body(productService.fetchAll());
	}
	
	@PostMapping(path="/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> createProduct(@RequestBody Product prodReq){
		if (productService.fetch(prodReq.getProductId()).isPresent()) {
			return ResponseEntity.badRequest().build();
		} else {
			return ResponseEntity.ok().body(productService.save(prodReq));
		}
	}
	
	@PutMapping(path="/update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> update(@RequestBody Product p){
		if (productService.update(p) == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(p);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Product> delete(@PathVariable long id){
		Optional<Product> deleted = productService.delete(id);
		return  !deleted.isPresent() ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(deleted.get());
	}
	@DeleteMapping("/deleteall")
	public ResponseEntity<List<Product>> deleteAll(){
		return ResponseEntity.ok().body(productService.deleteAll());
	}
}
