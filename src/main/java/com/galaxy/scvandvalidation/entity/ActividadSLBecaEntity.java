package com.galaxy.scvandvalidation.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "POC_ACTIVIDADES_SL_BECAS")
public class ActividadSLBecaEntity {

    @Id
    @Column(name="ID")
    private Long id;

    @Column(name="ANIO")
    private String anio;

    @Column(name="MES")
    private String mes;

    @Column(name="FECHA")
    private String fecha;

    @Column(name="MODALIDAD")
    private String modalid;


    @Column(name="LUGAR_PLATAFORMA")
    private String lugarPlataforma;

    @Column(name="TEMA_CAPACITACION")
    private String temaCapacitacion;

    @Column(name="EXPOSITORES")
    private String expositores;

    @Column(name="DETALLE_CAPACITACION")
    private String detalleCapacitacion;

    @Column(name="FECHA_REGISTRO")
    private LocalDate fechaRegistro;

    //@PrePersist
    public void setFechaRegistro() {
        this.fechaRegistro= LocalDate.now();
    }

    @Transient
    public String observacion;

}
