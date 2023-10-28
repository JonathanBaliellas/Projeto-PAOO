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

import com.poaa.livraria.model.Produto;
import com.poaa.livraria.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
    @Autowired
    private ProdutoRepository repository;

    //Retornar todos os produtos
    @GetMapping
    public ResponseEntity<List<Produto>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    //Retornar um produto específico por id
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable long id){
        return repository.findById(id)
            .map(resp -> ResponseEntity.ok(resp))
            .orElse(ResponseEntity.notFound().build());
    }

    //Registrar um produto
    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
    }

    //Atualizar um produto
    @PutMapping
    public ResponseEntity<Produto> update(@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
    }

    //Excluir um produto
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        repository.deleteAllById(id);
    }
}
