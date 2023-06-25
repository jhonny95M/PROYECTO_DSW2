package edu.cibertec.pe.request;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class IngresoAlmacenRequest {
	
	private String numeroOrdenCompra;
	private LocalDate fechaOrdenCompra;
	private String nombreProveedor;
	private int idTipMonv;
	private Long idUsuario;
	List<ProductoResquest> productos;

}
