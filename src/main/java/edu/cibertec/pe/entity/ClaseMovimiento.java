package edu.cibertec.pe.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ClaseMovimiento {
	 @Id
	    private int idClase;
	 private String nomClase;

}
