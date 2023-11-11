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

import com.poaa.livraria.model.Cliente;
import com.poaa.livraria.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {
    @Autowired
    private ClienteRepository repository;

    //Retornar todos os clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    //Retornar um cliente específico por id
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable long id){
        return repository.findById(id)
            .map(resp -> ResponseEntity.ok(resp))
            .orElse(ResponseEntity.notFound().build());
    }

    //Registrar um cliente
    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cliente));
    }

    //Atualizar um cliente
    @PutMapping
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(cliente));
    }

    //Excluir um cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        repository.deleteById(id);
        String mensagem = "Cliente excluído com sucesso!";
        return ResponseEntity.ok(mensagem);
    }
}
