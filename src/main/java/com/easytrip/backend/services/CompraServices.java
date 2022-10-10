package com.easytrip.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.easytrip.backend.converters.CompraConverter;
import com.easytrip.backend.data.CompraData;
import com.easytrip.backend.entities.Compra;
import com.easytrip.backend.repositories.CompraRepository;

@Service
public class CompraServices {
    
    @Autowired
    private CompraRepository compraRepository;    

    private CompraConverter compraConverter = new CompraConverter();
 
    /*se agregan todas las peticiones que se espera que se realicen desde el front*/

    /*Mostrar todos los compras que voy a ofrecer en una lista */
    public List<CompraData> findAll() {
        return compraConverter.toData(compraRepository.findAll());/*findAll en esta parte es el método buscar todo del crud repository*/
    }

    /*listar compras por id */
    public CompraData findById(int id_compra) {
        Optional<Compra> compra = compraRepository.findById(id_compra);
        if (compra.isEmpty()) 
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La compra no existe");
        return compraConverter.toData(compra.get());
    }

    /*Editar una de las compras */
    public CompraData update (CompraData compra) {
        if (!compraRepository.existsById(compra.getId_compra()))
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,  "La compra no existe");
        return compraConverter.toData(compraRepository.save(compraConverter.toEntity(compra))); /*save sirve para guardar y actualizar datos d ela base de datos */
    }
    
    /*agregar nuevas compras */
    public CompraData insert(CompraData compra) {
        if (compraRepository.existsById(compra.getId_compra()))
        throw new ResponseStatusException(HttpStatus.CONFLICT,  "La compra ya existe");
        return compraConverter.toData(compraRepository.save(compraConverter.toEntity(compra))); /*save sirve para guardar y actualizar datos d ela base de datos */
    }
    
    
    /*eliminar compras */
    public CompraData deleteById(int id_compra) {
        Optional<Compra> compra = compraRepository.findById(id_compra);
        if (compra.isEmpty()) 
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La compra no existe");
            CompraData compraData = compraConverter.toData(compra.get());
        compraRepository.deleteById(id_compra);
        return compraData;
    }
    
}
