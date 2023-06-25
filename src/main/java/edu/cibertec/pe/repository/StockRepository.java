package edu.cibertec.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.pe.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

}
