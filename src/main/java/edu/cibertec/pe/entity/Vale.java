package edu.cibertec.pe.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
//@IdClass(ValeId.class)
public class Vale {
    private int IdAlmacen;
    
    private int IdClase;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVale;

    private int IdTipMov;

    private Long IdUsuario;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime Fecha;

    private int IdEstado;

    // Relaciones con Estado, TipoMovimiento y Usuario
    @ManyToOne
    @JoinColumn(name = "IdEstado",insertable = false, updatable = false)
    private Estado estado;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "IdClase", referencedColumnName = "IdClase",insertable = false, updatable = false),
        @JoinColumn(name = "IdTipMov", referencedColumnName = "IdTipMov",insertable = false, updatable = false)
    })
    private TipoMovimiento tipoMovimiento;

    @ManyToOne
    //@MapsId("IdUsuario")
    @JoinColumn(name = "IdUsuario",insertable = false, updatable = false)
    private User usuario;

    // Constructor, getters y setters
}
