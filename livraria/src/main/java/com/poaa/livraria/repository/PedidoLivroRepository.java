package com.poaa.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poaa.livraria.model.PedidoLivro;

public interface PedidoLivroRepository extends JpaRepository<PedidoLivro, Long>{
    public List<PedidoLivro> deleteAllById(Long id);
}
