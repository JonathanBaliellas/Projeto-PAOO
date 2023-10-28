package com.poaa.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poaa.livraria.model.Estoque;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long>{
    public List<Estoque> deleteAllById(Long id);
}
