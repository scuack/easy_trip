package com.easytrip.backend.converters;

import com.easytrip.backend.data.UsuarioData;
import com.easytrip.backend.entities.Usuario;

public class UsuarioConverter extends Converter<Usuario, UsuarioData>{

    @Override
    public Usuario toEntity(UsuarioData object) {
        return object == null ? null : Usuario.builder() /*esto quiere decir que cuando recoba un null devuelva un null */
            .id_usuario(object.getId_usuario())
            .username(object.getUsername())
            .clave(object.getClave())
            .nombre(object.getNombre())
            .apellido(object.getApellido())
            .email(object.getEmail())
            .saldo(object.getSaldo())
            .roles(object.getRoles())
            .build();
    } 

    @Override
    public UsuarioData toData(Usuario object) {
        return object == null ? null : UsuarioData.builder()
        .id_usuario(object.getId_usuario())
        .username(object.getUsername())
        .clave(null)
        .nombre(object.getNombre())
        .apellido(object.getApellido())
        .email(object.getEmail())
        .saldo(object.getSaldo())
        .roles(object.getRoles())
        .build();
    }
    
}
