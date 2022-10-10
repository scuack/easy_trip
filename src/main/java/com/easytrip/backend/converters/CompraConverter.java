package com.easytrip.backend.converters;

import com.easytrip.backend.data.CompraData;
import com.easytrip.backend.entities.Compra;

public class CompraConverter extends Converter<Compra, CompraData>{


    @Override
    public Compra toEntity(CompraData object) {
        return object == null ? null : Compra.builder()
            .id_compra(object.getId_compra())
            .usuario(object.getUsuario())
            .servicio(object.getServicio())
            .build();
    }

    @Override
    public CompraData toData(Compra object) {
        return object == null ? null : CompraData.builder()
            .id_compra(object.getId_compra())
            .usuario(object.getUsuario())
            .servicio(object.getServicio())
            .build();
    }
    
}
