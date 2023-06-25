package edu.cibertec.pe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.pe.entity.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

	Optional<Proveedor> findByNombre(String nombreProveedor);
    // Puedes agregar consultas personalizadas si es necesario
}
