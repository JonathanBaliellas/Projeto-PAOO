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

import com.poaa.livraria.model.Pedido;
import com.poaa.livraria.repository.PedidoRepository;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PedidoController {
    @Autowired
    private PedidoRepository repository;

    //Retornar todos os pedidos
    @GetMapping
    public ResponseEntity<List<Pedido>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    //Retornar um pedido específico por id
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getById(@PathVariable long id){
        return repository.findById(id)
            .map(resp -> ResponseEntity.ok(resp))
            .orElse(ResponseEntity.notFound().build());
    }

    //Registrar um pedido
    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody Pedido pedido){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(pedido));
    }

    //Atualizar um pedido
    @PutMapping
    public ResponseEntity<Pedido> update(@RequestBody Pedido pedido){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(pedido));
    }

    //Excluir um pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        repository.deleteById(id);
        String mensagem = "Pedido excluído com sucesso!";
        return ResponseEntity.ok(mensagem);
    }
}
