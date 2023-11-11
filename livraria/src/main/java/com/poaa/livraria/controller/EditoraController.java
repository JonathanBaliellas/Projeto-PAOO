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

import com.poaa.livraria.model.Editora;
import com.poaa.livraria.repository.EditoraRepository;

@RestController
@RequestMapping("/editoras")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EditoraController {
    @Autowired
    private EditoraRepository repository;

    //Retornar todas as editoras
    @GetMapping
    public ResponseEntity<List<Editora>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    //Retornar uma editora específica por id
    @GetMapping("/{id}")
    public ResponseEntity<Editora> getById(@PathVariable long id){
        return repository.findById(id)
            .map(resp -> ResponseEntity.ok(resp))
            .orElse(ResponseEntity.notFound().build());
    }

    //Registrar uma editora
    @PostMapping
    public ResponseEntity<Editora> save(@RequestBody Editora editora){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(editora));
    }

    //Atualizar uma editora
    @PutMapping
    public ResponseEntity<Editora> update(@RequestBody Editora editora){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(editora));
    }

    //Excluir uma editora
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        repository.deleteById(id);
        String mensagem = "Editora excluído com sucesso!";
        return ResponseEntity.ok(mensagem);
    }
}
