package com.easytrip.backend.converters;

import com.easytrip.backend.data.RoleData;
import com.easytrip.backend.entities.Role;

public class RoleConverter extends Converter<Role, RoleData> {

    @Override
    public Role toEntity(RoleData object) {
        return object == null ? null : Role.builder()
            .id_role(object.getId_role())
            .nombre_rol(object.getNombre_rol())
            .build();
    }

    @Override
    public RoleData toData(Role object) {
        return object == null ? null : RoleData.builder()
            .id_role(object.getId_role())
            .nombre_rol(object.getNombre_rol())
            .build();
    }
    
}
