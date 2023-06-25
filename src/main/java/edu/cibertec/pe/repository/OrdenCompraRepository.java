package edu.cibertec.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.pe.entity.OrdenCompra;

@Repository
public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Long> {
    // Puedes agregar consultas personalizadas si es necesario
	OrdenCompra findByNumero(String numero);
}