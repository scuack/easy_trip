package com.easytrip.backend.data;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServicioData {
    
    private Integer id_ruta;
    private String ruta;    
    private String placa;    
    private Date fecha;    
    private Date hora;    
    private String valor;    
    private Integer puestos;    
    private String imagen;

}
