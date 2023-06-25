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

import edu.cibertec.pe.entity.Cliente;
import edu.cibertec.pe.repository.*;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Cliente>> getAllClientes(){
		return new ResponseEntity<>(repository.getAllClientes(), HttpStatus.OK);
		
	}
	
	@GetMapping("/{cod}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable int cod){
		
		return repository
				.getClienteById(cod)
				.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping	
	public ResponseEntity<Cliente> addCliente(@RequestBody Cliente c){
		return new ResponseEntity<>(repository.addCliente(c), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente c) {
		
		return new ResponseEntity<>(repository.UpdateCliente(c), HttpStatus.OK);
	}
	
	@DeleteMapping("/{cod}")
	public ResponseEntity<Void> deleteCliente(@PathVariable int cod){
		repository.deleteCliente(cod);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
