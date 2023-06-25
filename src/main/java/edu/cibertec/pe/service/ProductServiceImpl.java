package edu.cibertec.pe.service;

import java.util.List;

import edu.cibertec.pe.dto.ProductoDto;
import edu.cibertec.pe.entity.Producto;
import edu.cibertec.pe.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private ProductoRepository repository;

	@Override
	public Producto getProductById(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductoDto> getProductList() {
		// TODO Auto-generated method stub
		return repository.findAllDto();
	}

	@Override
	@Transactional()
	public void deleteProduct(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);;
	}

	@Override
	@Transactional()
	public Producto updateProduct(Producto product) {
		// TODO Auto-generated method stub
		return repository.save(product);
	}

	@Override
	@Transactional()
	public Producto addProduct(Producto product) {
		product.setId(0L);
		return repository.save(product);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductoDto> findAllByName(String name) {
		// TODO Auto-generated method stub
		return repository.findAllByName(name);
	}

	@Override
	@Transactional(readOnly = true)
	public ProductoDto findAllById(Long id) {
		// TODO Auto-generated method stub
		return repository.findAllById(id);
	}

}
