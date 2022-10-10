package com.easytrip.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easytrip.backend.entities.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra,Integer>{
    
}
