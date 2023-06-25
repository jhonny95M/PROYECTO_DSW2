package edu.cibertec.pe.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumns;

import lombok.Data;

@Entity
@Data
@IdClass(KardexId.class)
public class Kardex {
    @Id
    private int IdAlmacen;
    
    @Id
    private int IdClase;
    
    @Id
    private Long idVale;
    
    @Id
    private int ItemVale;

    private int IdTipMov;
    
    private double cantidad;


    // Relaciones con Articulo y Vale
    @ManyToOne
    @JoinColumn(name = "producto")
    private Producto producto;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "IdAlmacen", referencedColumnName = "IdAlmacen",insertable = false, updatable = false),
        @JoinColumn(name = "IdClase", referencedColumnName = "IdClase",insertable = false, updatable = false),
        @JoinColumn(name = "idVale", referencedColumnName = "idVale",insertable = false, updatable = false)
    })
    private Vale vale;

    // Constructor, getters y setters
}

