package edu.cibertec.pe.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class ValeId implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int IdAlmacen;
    private int IdClase;
    private int IdVale;
    
    // Constructor, getters y setters
    // Asegúrate de implementar los métodos equals() y hashCode() correctamente
}
