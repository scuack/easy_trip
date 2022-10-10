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

import com.easytrip.backend.data.ServicioData;
import com.easytrip.backend.services.ServicioServices;

@RestController
@RequestMapping(path = "/api/servicios")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ServicioController {
     
    @Autowired
    private ServicioServices servicioServices;

    /*se agregan todas las peticiones que se espera que se realicen desde el front y que ya están en el service*/ 

    /*Listar por ID */
    @GetMapping("{id_ruta}")
    public ResponseEntity<?> findById(@PathVariable int id_ruta) {
        return new ResponseEntity<>(servicioServices.findById(id_ruta), HttpStatus.OK);
    }

    /*Mostrar todos los servicios que voy a ofrecer en una lista */
    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(servicioServices.findAll(), HttpStatus.OK);
    }

    /*Editar una de las rutas*/
    @PutMapping
    public ResponseEntity<?> update(@RequestBody ServicioData servicio) {
        return new ResponseEntity<>(servicioServices.update(servicio), HttpStatus.OK); 
    }
    
    /*agregar nuevas rutas */
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody ServicioData servicio) {
        return new ResponseEntity<>(servicioServices.insert(servicio), HttpStatus.CREATED);
    }
    
    /*eliminar rutas */
    @DeleteMapping("{id_ruta}")
    public ResponseEntity<?> deleteById(@PathVariable int id_ruta) {
        return new ResponseEntity<>(servicioServices.deleteById(id_ruta), HttpStatus.OK);
    }
}
