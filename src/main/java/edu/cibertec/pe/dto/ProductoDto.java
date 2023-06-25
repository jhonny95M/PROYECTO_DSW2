package edu.cibertec.pe.dto;


import edu.cibertec.pe.entity.Producto;
import lombok.Data;

@Data
public class ProductoDto {
	
	private Long id;
	private int categoryId;
	private String name;	
	private Double unitPrice;
	private double stock;
	public ProductoDto(Producto p) {
		this.id=p.getId();
		this.categoryId=p.getCategoryId();
		this.name=p.getName();
		this.unitPrice=p.getUnitPrice();
	}
	public ProductoDto(Producto p,double cantidad) {
		this.id=p.getId();
		this.categoryId=p.getCategoryId();
		this.name=p.getName();
		this.unitPrice=p.getUnitPrice();
		this.stock=cantidad;
	}
}
