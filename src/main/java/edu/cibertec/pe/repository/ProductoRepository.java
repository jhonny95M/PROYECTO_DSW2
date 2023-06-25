package edu.cibertec.pe.repository;

import java.util.List;
import java.util.Optional;

import edu.cibertec.pe.dto.ProductoDto;
import edu.cibertec.pe.entity.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
	@Query(value = "SELECT new edu.cibertec.pe.dto.ProductoDto(p) FROM Producto p WHERE p.name=:name")
	List<ProductoDto> findAllByName(String name);
	@Query(value = "SELECT new edu.cibertec.pe.dto.ProductoDto(p,s.cantidad) FROM Producto p JOIN Stock s ON p.stock.id=s.id WHERE p.id=:id")
	ProductoDto findAllById(Long id);
	@Query(value = "SELECT new edu.cibertec.pe.dto.ProductoDto(p,s.cantidad) FROM Producto p JOIN Stock s ON p.stock.id=s.id")
	List<ProductoDto> findAllDto();
	Optional<Producto> findByName(String name);
}
