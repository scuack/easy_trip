package com.easytrip.backend.converters;

import com.easytrip.backend.data.ServicioData;
import com.easytrip.backend.entities.Servicio;

public class ServicioConverter extends Converter<Servicio, ServicioData> {

    @Override
    public Servicio toEntity(ServicioData object) {
        return object == null ? null : Servicio.builder()
            .id_ruta(object.getId_ruta())
            .ruta(object.getRuta())
            .placa(object.getPlaca())
            .fecha(object.getFecha())
            .hora(object.getHora())
            .puestos(object.getPuestos())
            .imagen(object.getImagen())
            .build();
    }

    @Override
    public ServicioData toData(Servicio object) {
        return object == null ? null : ServicioData.builder()
            .id_ruta(object.getId_ruta())
            .ruta(object.getRuta())
            .placa(object.getPlaca())
            .fecha(object.getFecha())
            .hora(object.getHora())
            .puestos(object.getPuestos())
            .imagen(object.getImagen())
            .build();
    }
    
}
