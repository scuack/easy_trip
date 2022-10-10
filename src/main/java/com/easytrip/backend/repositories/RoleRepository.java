package com.easytrip.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easytrip.backend.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>{
    
}
