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

import com.poaa.livraria.model.Estoque;
import com.poaa.livraria.repository.EstoqueRepository;

@RestController
@RequestMapping("/estoque")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EstoqueController {
    @Autowired
    private EstoqueRepository repository;

    //Retornar todos os itens no estoque
    @GetMapping
    public ResponseEntity<List<Estoque>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    //Retornar um item específico do estoque por id
    @GetMapping("/{id}")
    public ResponseEntity<Estoque> getById(@PathVariable long id){
        return repository.findById(id)
            .map(resp -> ResponseEntity.ok(resp))
            .orElse(ResponseEntity.notFound().build());
    }

    //Registrar um item no estoque
    @PostMapping
    public ResponseEntity<Estoque> save(@RequestBody Estoque estoque){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(estoque));
    }

    //Atualizar um item de estoque
    @PutMapping
    public ResponseEntity<Estoque> update(@RequestBody Estoque estoque){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(estoque));
    }

    //Excluir um item de estoque
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        repository.deleteAllById(id);
    }
}
