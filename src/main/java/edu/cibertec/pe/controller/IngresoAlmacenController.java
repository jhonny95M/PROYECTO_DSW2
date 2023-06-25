package edu.cibertec.pe.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.pe.request.IngresoAlmacenRequest;
import edu.cibertec.pe.service.AlmacenService;
import edu.cibertec.pe.util.ExceptionValidate;
import edu.cibertec.pe.response.*;

@RestController
@RequestMapping("/api/ingreso-almacen")
public class IngresoAlmacenController {
    @Autowired
	private AlmacenService ingresoAlmacenService;


    @PostMapping
    public ResponseEntity<ResultadoResponse> registrarIngresoAlmacen(@RequestBody IngresoAlmacenRequest request) throws ExceptionValidate, URISyntaxException {
        ingresoAlmacenService.ingresarOrdenCompra(request.getNumeroOrdenCompra(), request.getFechaOrdenCompra(),
        		request.getNombreProveedor(), request.getProductos());

        return new ResponseEntity<>(new ResultadoResponse(201,"Se atendio con exito."),HttpStatus.CREATED);
    }
}
