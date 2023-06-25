package edu.cibertec.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.pe.entity.Vale;
@Repository
public interface ValeRepository extends JpaRepository<Vale, Long> {

}
