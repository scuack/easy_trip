package com.easytrip.backend.data;

import java.util.List;

import com.easytrip.backend.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/* Se crea un esqueleto parecido a una entidad solamente que sin las anotaciones que se usaban por dentro de la clase  y la anotación de entidad @Entity */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioData {
    private Integer id_usuario;
    private String username;
    private String clave;
    private String nombre;
    private String apellido;
    private String email; 
    private Double saldo;
    private List<Role> roles;

    
}
