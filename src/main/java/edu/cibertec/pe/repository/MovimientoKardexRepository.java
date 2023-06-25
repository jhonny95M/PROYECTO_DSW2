package edu.cibertec.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.pe.entity.MovimientoKardex;

@Repository
public interface MovimientoKardexRepository extends JpaRepository<MovimientoKardex, Long> {
    // Puedes agregar consultas personalizadas si es necesario
}
