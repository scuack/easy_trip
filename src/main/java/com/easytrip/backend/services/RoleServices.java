package com.easytrip.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.easytrip.backend.converters.RoleConverter;
import com.easytrip.backend.data.RoleData;
import com.easytrip.backend.entities.Role;
import com.easytrip.backend.repositories.RoleRepository;

@Service
public class RoleServices {
    
    @Autowired
    private RoleRepository roleRepository;

    private RoleConverter roleConverter = new RoleConverter();

    /*listar todos los roles */
    public List<RoleData> findAll() {
        return roleConverter.toData(roleRepository.findAll());
    }

    /*listar por id del rol */
    public RoleData findById(int id_role) {
        Optional<Role> role = roleRepository.findById(id_role);
        if(role.isEmpty())
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "el rol no existe");
        return roleConverter.toData(role.get());
    }

    /*Agregar un rol*/
    public RoleData insert(RoleData role){
        if(roleRepository.existsById(role.getId_role()))
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El rol ya existe");
        return roleConverter.toData(roleRepository.save(roleConverter.toEntity(role)));
    }

    /*Editar un rol */
    public RoleData update(RoleData role){
        if(!roleRepository.existsById(role.getId_role()))
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El rol no existe");
        return roleConverter.toData(roleRepository.save(roleConverter.toEntity(role)));
    }

    /*Eliminar un rol */
    public RoleData deleteById(int id_role){
    Optional<Role> role = roleRepository.findById(id_role);
        if(role.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "el rol no existe");
            RoleData rolData = roleConverter.toData(role.get());
        roleRepository.deleteById(id_role);
        return rolData;
    }
}
