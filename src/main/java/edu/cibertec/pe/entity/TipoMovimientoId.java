package edu.cibertec.pe.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class TipoMovimientoId implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private int idClase;

    private int idTipMov;

    // Constructor, equals, hashCode, getters y setters
}
