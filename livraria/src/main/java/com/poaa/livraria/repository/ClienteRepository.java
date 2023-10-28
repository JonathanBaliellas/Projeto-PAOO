package com.poaa.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poaa.livraria.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    public List<Cliente> deleteAllById(Long id);
}
