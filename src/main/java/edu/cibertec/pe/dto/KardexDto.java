package edu.cibertec.pe.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class KardexDto {

	private Long idProducto;
	private String nomClase;
	private LocalDateTime fecha;
	private int idClase;
	private Long idVale;
	private int itemVale;
	private String nomTipMov;
	private String name;
	private double cantidad;
	private String email;
	private double stock;
	public KardexDto() {}
	public KardexDto(String nomClase, LocalDateTime fecha, Long idVale, int itemVale, String nomTipMov, String name,
			double cantidad, String email) {
		this.nomClase = nomClase;
		this.fecha = fecha;
		this.idVale = idVale;
		this.itemVale = itemVale;
		this.nomTipMov = nomTipMov;
		this.name = name;
		this.cantidad = cantidad;
		this.email = email;
	}
	public KardexDto(String nomClase, LocalDateTime fecha, Long idVale, int itemVale, String nomTipMov, String name,
			double cantidad, String email,int idClase,Long idProducto) {
		this.nomClase = nomClase;
		this.fecha = fecha;
		this.idVale = idVale;
		this.itemVale = itemVale;
		this.nomTipMov = nomTipMov;
		this.name = name;
		this.cantidad = cantidad;
		this.email = email;
		this.idClase=idClase;
		this.idProducto=idProducto;
	}
	
	
}
