package com.easytrip.backend.data;

import com.easytrip.backend.entities.Servicio;
import com.easytrip.backend.entities.Usuario;

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
public class CompraData {

    private Integer id_compra;
    private Usuario usuario;
    private Servicio servicio;

}
