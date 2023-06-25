package edu.cibertec.pe.service;

import java.util.List;

import edu.cibertec.pe.dto.ProductoDto;
import edu.cibertec.pe.entity.Producto;


public interface IProductService {
	public Producto getProductById(long id);
	public List<ProductoDto> getProductList();
	public void deleteProduct(long id);
	public Producto updateProduct(Producto product);
	public Producto addProduct(Producto product);
	public List<ProductoDto> findAllByName(String name);
	public ProductoDto findAllById(Long id);
}
