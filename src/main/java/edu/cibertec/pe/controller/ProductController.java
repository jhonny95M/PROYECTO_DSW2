package edu.cibertec.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.pe.dto.ProductoDto;
import edu.cibertec.pe.entity.Producto;
import edu.cibertec.pe.service.ProductServiceImpl;


@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductServiceImpl service;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ProductoDto>> getAll() {
		return new ResponseEntity<>(service.getProductList(), HttpStatus.OK);
	}
	
	@GetMapping("/getAllByName/{name}")
	public ResponseEntity<List<ProductoDto>> getAllByName(@PathVariable("name") String name) {
		return new ResponseEntity<>(service.getProductList(), HttpStatus.OK);
	}
	
	@GetMapping("/getAllById/{id}")
	public ResponseEntity<List<ProductoDto>> getAllById(@PathVariable("id") int id) {
		return new ResponseEntity<>(service.getProductList(), HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ProductoDto> getProduct(@PathVariable("id") long id){
		ProductoDto p = service.findAllById(id);
		if(p == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id){
		Producto p = service.getProductById(id);
		if(p == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		service.deleteProduct(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Producto> updateProduct(@RequestBody Producto product){
		Producto p = service.getProductById(product.getId());
		if(p == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(service.updateProduct(product), HttpStatus.OK);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Producto> addProduct(@RequestBody Producto product){
		if(product.getId()!=null) {
		Producto p = service.getProductById(product.getId());
		if(p == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
		return new ResponseEntity<>(service.addProduct(product), HttpStatus.CREATED);
	}

}
