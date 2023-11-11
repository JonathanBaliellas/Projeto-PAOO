package com.poaa.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poaa.livraria.model.PedidoLivro;
import com.poaa.livraria.repository.PedidoLivroRepository;

@RestController
@RequestMapping("/pedidos-livros")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PedidoLivroController {
    @Autowired
    private PedidoLivroRepository repository;

    //Retornar todos os livros dos pedidos
    @GetMapping
    public ResponseEntity<List<PedidoLivro>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    //Retornar um item de pedidoLivro específico por id
    @GetMapping("/{id}")
    public ResponseEntity<PedidoLivro> getById(@PathVariable long id){
        return repository.findById(id)
            .map(resp -> ResponseEntity.ok(resp))
            .orElse(ResponseEntity.notFound().build());
    }

    //Registrar um livro de um pedido
    @PostMapping
    public ResponseEntity<PedidoLivro> save(@RequestBody PedidoLivro pedidoLivro){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(pedidoLivro));
    }

    //Atualizar um livro de um pedido
    @PutMapping
    public ResponseEntity<PedidoLivro> update(@RequestBody PedidoLivro pedidoLivro){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(pedidoLivro));
    }

    //Excluir um livro de um pedido
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        repository.deleteAllById(id);
    }
}
