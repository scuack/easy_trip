package com.easytrip.backend.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Servicio {

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ruta;

    @Column(nullable = false)
    private String ruta;

    @Column(nullable = false)
    private String placa;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private Date hora;

    @Column(nullable = false)
    private String valor;

    @Column(nullable = false, unique = true)
    private Integer puestos;
    
    @Column(nullable = false)
    private String imagen;

    
}
