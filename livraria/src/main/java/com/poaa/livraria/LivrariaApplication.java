package com.poaa.livraria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 * 
 import com.poaa.livraria.controller.ProdutoController;
 import com.poaa.livraria.model.Produto;
 */

@SpringBootApplication
public class LivrariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrariaApplication.class, args);
		/*
		Produto p1 = new Produto();
		p1.setNome("O Hobbit");
		p1.setDescricao("Um livro bacana");
		p1.setFabricante("Tolkien");
		p1.setPreco(30);
		p1.setQuant(5);
		
		ProdutoController pController = new ProdutoController();
		pController.save(p1);
		* 
		 */
	}

}
