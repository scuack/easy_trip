package com.easytrip.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.easytrip.backend.converters.ServicioConverter;
import com.easytrip.backend.data.ServicioData;
import com.easytrip.backend.entities.Servicio;
import com.easytrip.backend.repositories.ServicioRepository;

@Service
public class ServicioServices {

    @Autowired
    private ServicioRepository servicioRepository;    

    private ServicioConverter servicioConverter = new ServicioConverter();
 
    /*se agregan todas las peticiones que se espera que se realicen desde el front*/

    /*Mostrar todos los servicios que voy a ofrecer en una lista */
    public List<ServicioData> findAll() {
        return servicioConverter.toData(servicioRepository.findAll());/*findAll en esta parte es el método buscar todo del crud repository*/
    }

    /*listar rutas por id */
    public ServicioData findById(int id_ruta) {
        Optional<Servicio> servicio = servicioRepository.findById(id_ruta);
        if (servicio.isEmpty()) 
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La ruta no existe");
        return servicioConverter.toData(servicio.get());
    }

    /*Editar una de las rutas */
    public ServicioData update (ServicioData servicio) {
        if (!servicioRepository.existsById(servicio.getId_ruta()))
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,  "La ruta no existe");
        return servicioConverter.toData(servicioRepository.save(servicioConverter.toEntity(servicio))); /*save sirve para guardar y actualizar datos d ela base de datos */
    }
    
    /*agregar nuevas rutas */
    public ServicioData insert(ServicioData servicio) {
        if (servicioRepository.existsById(servicio.getId_ruta()))
        throw new ResponseStatusException(HttpStatus.CONFLICT,  "La ruta ya existe");
        return servicioConverter.toData(servicioRepository.save(servicioConverter.toEntity(servicio))); /*save sirve para guardar y actualizar datos d ela base de datos */
    }
    
    
    /*eliminar rutas */
    public ServicioData deleteById(int id_ruta) {
        Optional<Servicio> servicio = servicioRepository.findById(id_ruta);
        if (servicio.isEmpty()) 
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La ruta no existe");
            ServicioData servicioData = servicioConverter.toData(servicio.get());
        servicioRepository.deleteById(id_ruta);
        return servicioData;
    }
    
}
