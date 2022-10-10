package com.easytrip.backend.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; 
@Entity /*indica que es una entidad (es como decir que es una tabla de la base de datos) */
@Getter /*indica que se van a realizar todos los getters que sean necesarios dentro de la clase (es de la dependencia lombok)*/
@Setter /*indica que se van a realizar todos los setters que sean necesarios dentro de la clase (es de la dependencia lombok)*/
@NoArgsConstructor /*Crea los cosntructores por defecto (también viene de lombok)*/
@AllArgsConstructor /*Crea los constructores con parámetros (también viene de lombok)*/ 
@Builder /*Facilita el proceso de compilación de la clase (también viene de lombok) */
public class Usuario {

    @Id /*Indica que es la llave primaria de la tabla*/
    @Column(nullable=false, unique = true) /*Indica que este valor en la base de datos no puede ser nulo y debe ser unico */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /*Indica que este valor en la base de datos es autoincrementable*/
    private int id_usuario;

    @Column(nullable=false, unique = true)
    private String username;

    @Getter(value = AccessLevel.NONE)
    @Column(nullable=false, unique = true)
    private String clave;

    @Column(nullable=false)
    private String nombre;

    @Column(nullable=false)
    private String apellido;

    @Column(nullable=false, unique = true)
    private String email; 

    @Column(nullable=false)
    private Double saldo;

    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private List<Role> roles;

    public boolean checkPassword(String clave){ /* Esto compara la contraseña que se ingrese en la página con la que registró el usuario */
        return this.clave.equals(clave); /*equals compara el dato que ingresa con el que ya se tiene*/
    }
}
 