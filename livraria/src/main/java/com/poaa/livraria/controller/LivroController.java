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

import com.poaa.livraria.model.Livro;
import com.poaa.livraria.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LivroController {
    @Autowired
    private LivroRepository repository;

    //Retornar todos os livros
    @GetMapping
    public ResponseEntity<List<Livro>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    //Retornar um livro específico por id
    @GetMapping("/{id}")
    public ResponseEntity<Livro> getById(@PathVariable long id){
        return repository.findById(id)
            .map(resp -> ResponseEntity.ok(resp))
            .orElse(ResponseEntity.notFound().build());
    }

    //Registrar um livro
    @PostMapping
    public ResponseEntity<Livro> save(@RequestBody Livro livro){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(livro));
    }

    //Atualizar um livro
    @PutMapping
    public ResponseEntity<Livro> update(@RequestBody Livro livro){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(livro));
    }

    //Excluir um livro
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        repository.deleteAllById(id);
    }
}
