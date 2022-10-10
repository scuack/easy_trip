package com.easytrip.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easytrip.backend.data.UsuarioData;
import com.easytrip.backend.services.UsuarioServices;

@RestController
@RequestMapping(path = "/api/usuario")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UsuarioController {
    
    @Autowired
    private UsuarioServices usuarioServices;

    /*se agregan todas las peticiones que se espera que se realicen desde el front y que ya están en el service*/ 

    /*Listar por ID */
    @GetMapping("{id_usuario}")
    public ResponseEntity<?> findById(@PathVariable int id_usuario) {
        return new ResponseEntity<>(usuarioServices.findById(id_usuario), HttpStatus.OK);
    }

    /*Mostrar todos los servicios que voy a ofrecer en una lista */
    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(usuarioServices.findAll(), HttpStatus.OK);
    }

    /*Editar una de los usuarios*/
    @PutMapping
    public ResponseEntity<?> update(@RequestBody UsuarioData usuario) {
        return new ResponseEntity<>(usuarioServices.update(usuario), HttpStatus.OK); 
    }
    
    /*agregar nuevas usuarios */
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody UsuarioData usuario) {
        return new ResponseEntity<>(usuarioServices.insert(usuario), HttpStatus.CREATED);
    }
    
    /*eliminar usuarios */
    @DeleteMapping("{id_usuario}")
    public ResponseEntity<?> deleteById(@PathVariable int id_usuario) {
        return new ResponseEntity<>(usuarioServices.deleteById(id_usuario), HttpStatus.OK);
    }
}
