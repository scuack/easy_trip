package com.easytrip.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.easytrip.backend.converters.UsuarioConverter;
import com.easytrip.backend.data.UsuarioData;
import com.easytrip.backend.entities.Usuario;
import com.easytrip.backend.repositories.UsuarioRepository;

@Service
public class UsuarioServices {

    @Autowired
    private UsuarioRepository usuarioRepository;    

    private UsuarioConverter usuarioConverter = new UsuarioConverter();
 
    /*se agregan todas las peticiones que se espera que se realicen desde el front*/

    /*Mostrar todos los usuarios que voy a ofrecer en una lista */
    public List<UsuarioData> findAll() {
        return usuarioConverter.toData(usuarioRepository.findAll());/*findAll en esta parte es el método buscar todo del crud repository*/
    }

    /*listar usuarios por id */
    public UsuarioData findById(int id_usuario) {
        Optional<Usuario> usuario = usuarioRepository.findById(id_usuario);
        if (usuario.isEmpty()) 
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no existe");
        return usuarioConverter.toData(usuario.get());
    }

    /*Editar una de las usuarios */
    public UsuarioData update (UsuarioData usuario) {
        if (!usuarioRepository.existsById(usuario.getId_usuario()))
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,  "El usuario no existe");
        return usuarioConverter.toData(usuarioRepository.save(usuarioConverter.toEntity(usuario))); /*save sirve para guardar y actualizar datos d ela base de datos */
    }
    
    /*agregar nuevas usuarios */
    public UsuarioData insert(UsuarioData usuario) {
        if (usuarioRepository.existsById(usuario.getId_usuario()))
        throw new ResponseStatusException(HttpStatus.CONFLICT,  "el usuario ya existe");
        return usuarioConverter.toData(usuarioRepository.save(usuarioConverter.toEntity(usuario))); /*save sirve para guardar y actualizar datos d ela base de datos */
    }
    
    
    /*eliminar usuario */
    public UsuarioData deleteById(int id_usuario) {
        Optional<Usuario> usuario = usuarioRepository.findById(id_usuario);
        if (usuario.isEmpty()) 
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no existe");
            UsuarioData usuarioData = usuarioConverter.toData(usuario.get());
        usuarioRepository.deleteById(id_usuario);
        return usuarioData;
    }
}
