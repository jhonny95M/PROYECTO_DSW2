package edu.cibertec.pe.request;


import lombok.Data;

@Data
public class ProductoResquest {
	
	private Long id;
	private int categoryId;	
	private String name;
    private double cantidad;
	private Double unitPrice;
}
