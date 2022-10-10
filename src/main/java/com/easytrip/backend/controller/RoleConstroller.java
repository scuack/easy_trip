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

import com.easytrip.backend.data.RoleData;
import com.easytrip.backend.services.RoleServices;

@RestController
@RequestMapping(path = "/api/roles")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class RoleConstroller {
    
    @Autowired
    private RoleServices roleService;

    /*Mostrar todos los servicios que voy a ofrecer en una lista */
    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }

    /*Listar por ID */
    @GetMapping("{id_rol}")
    public ResponseEntity<?> findById(@PathVariable int id_ruta) {
        return new ResponseEntity<>(roleService.findById(id_ruta), HttpStatus.OK);
    }

    /*Editar una de las rutas*/
    @PutMapping
    public ResponseEntity<?> update(@RequestBody RoleData role) {
        return new ResponseEntity<>(roleService.update(role), HttpStatus.OK); 
    }
    
    /*agregar nuevas rutas */
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody RoleData servicio) {
        return new ResponseEntity<>(roleService.insert(servicio), HttpStatus.CREATED);
    }
    
    /*eliminar rutas */
    @DeleteMapping("{id_ruta}")
    public ResponseEntity<?> deleteById(@PathVariable int id_rol) {
        return new ResponseEntity<>(roleService.deleteById(id_rol), HttpStatus.OK);
    }
}
