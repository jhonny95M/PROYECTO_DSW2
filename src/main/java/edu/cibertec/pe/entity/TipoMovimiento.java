package edu.cibertec.pe.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
@IdClass(TipoMovimientoId.class)
public class TipoMovimiento {
	@Id private int idClase;
	@Id private int idTipMov;
	 	 
    private String NomTipMov;

    // Relación con ClaseMovimiento
    @ManyToOne
    @JoinColumn(name = "IdClase", insertable = false, updatable = false)
    
    private ClaseMovimiento claseMovimiento;

    public TipoMovimiento() {}
    public TipoMovimiento(int idClase,int idTipMov)
    {    	
    	this.idClase=idClase;
    	this.idTipMov=idTipMov;
    }
}
