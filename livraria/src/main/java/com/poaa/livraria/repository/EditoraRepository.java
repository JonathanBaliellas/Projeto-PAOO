package com.poaa.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poaa.livraria.model.Editora;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long>{
    public List<Editora> deleteAllById(Long id);
}
