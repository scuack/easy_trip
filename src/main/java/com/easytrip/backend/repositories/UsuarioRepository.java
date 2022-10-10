package com.easytrip.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easytrip.backend.entities.Usuario;
/*Se crea un repositorio para cada entidad y se extiende la clase JpaRepository la cual tiene dos parámetros, el primero esla entidad y el segundo es el tipo de dato de la llave primaria*/
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
    public Optional<Usuario> findByUsername(String username);

    public Optional<Usuario> findByEmail(String email);
}
