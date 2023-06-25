package edu.cibertec.pe.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Estado {

	@Id
	private int id;
	private String nomEstado;
	public Estado() {}
	public Estado(int id) {
	this.id=id;
	}
}
