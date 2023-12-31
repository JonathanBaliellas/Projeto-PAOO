package com.poaa.livraria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estoque")
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long livro_id;
    private int quant;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getLivroId() {
        return livro_id;
    }
    public void setLivroId(long livro_id) {
        this.livro_id = livro_id;
    }
    public int getQuant() {
        return quant;
    }
    public void setQuant(int quant) {
        this.quant = quant;
    }
}
