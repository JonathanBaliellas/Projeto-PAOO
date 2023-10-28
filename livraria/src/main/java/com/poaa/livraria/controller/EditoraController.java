package com.poaa.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<List<Editora>> 
}
