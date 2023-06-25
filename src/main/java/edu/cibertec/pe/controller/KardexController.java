package edu.cibertec.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.pe.dto.KardexDto;
import edu.cibertec.pe.request.IngresoAlmacenRequest;
import edu.cibertec.pe.response.ResultadoResponse;
import edu.cibertec.pe.service.KardexService;
import edu.cibertec.pe.service.ValeService;
import edu.cibertec.pe.util.ExceptionValidate;

@RestController
@RequestMapping("/api/kardex")
public class KardexController {

	@Autowired
	KardexService service;
	@Autowired
	ValeService valeservice;
	
	@GetMapping
	public ResponseEntity<List<KardexDto>> getAll() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
	@PostMapping("/ingreso")
	public ResponseEntity<ResultadoResponse>RegistrarIngresoVale(@RequestBody IngresoAlmacenRequest request) throws ExceptionValidate{
		long vale= valeservice.RegistrarIngresoVale(request);
		return new ResponseEntity<>(new ResultadoResponse(201,"Se genero el vale N° "+vale),HttpStatus.CREATED);
	}
	@PostMapping("/salida")
	public ResponseEntity<ResultadoResponse>RegistrarSalidaVale(@RequestBody IngresoAlmacenRequest request) throws ExceptionValidate{
		long vale= valeservice.RegistrarSalidaVale(request);
		return new ResponseEntity<>(new ResultadoResponse(201,"Se genero el vale N° "+vale),HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<List<KardexDto>> getAllByProducto(@PathVariable("id") long id){
		return new ResponseEntity<>(service.getAllByProducto(id),HttpStatus.OK);
	}
}
