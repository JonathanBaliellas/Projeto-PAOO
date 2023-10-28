package com.poaa.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poaa.livraria.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
    public List<Livro> deleteAllById(Long id);
}
