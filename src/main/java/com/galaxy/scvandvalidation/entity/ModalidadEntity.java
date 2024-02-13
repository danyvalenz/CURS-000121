package com.galaxy.scvandvalidation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "POC_MODALIDAD")
@Entity
@Data
public class ModalidadEntity {

    @Id
    @Column(name="MODALIDAD_ID")
    private Long id;

    @Column(name="MODALIDAD")
    private String nombre;

    @Column(name = "ESTADO")
    private Integer estado;
}
