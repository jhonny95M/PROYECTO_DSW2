package edu.cibertec.pe.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class KardexId implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int IdAlmacen;
    private int IdClase;
    private Long idVale;
    private int ItemVale;
    
    // Constructor, getters y setters
    // Asegúrate de implementar los métodos equals() y hashCode() correctamente
}
