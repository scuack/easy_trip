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

import com.easytrip.backend.data.CompraData;
import com.easytrip.backend.services.CompraServices;

@RestController
@RequestMapping(path = "/api/compra")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CompraController {
    
    @Autowired
    private CompraServices compraServices;

    /*se agregan todas las peticiones que se espera que se realicen desde el front y que ya están en el service*/ 

    /*Listar por ID */
    @GetMapping("{id_compra}")
    public ResponseEntity<?> findById(@PathVariable int id_compra) {
        return new ResponseEntity<>(compraServices.findById(id_compra), HttpStatus.OK);
    }

    /*Mostrar todos los compras que voy a ofrecer en una lista */
    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(compraServices.findAll(), HttpStatus.OK);
    }

    /*Editar una de los usuarios*/
    @PutMapping
    public ResponseEntity<?> update(@RequestBody CompraData compra) {
        return new ResponseEntity<>(compraServices.update(compra), HttpStatus.OK); 
    }
    
    /*agregar nuevas usuarios */
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody CompraData compra) {
        return new ResponseEntity<>(compraServices.insert(compra), HttpStatus.CREATED);
    }
    
    /*eliminar usuarios */
    @DeleteMapping("{id_compra}")
    public ResponseEntity<?> deleteById(@PathVariable int id_compra) {
        return new ResponseEntity<>(compraServices.deleteById(id_compra), HttpStatus.OK);
    }
    
}
