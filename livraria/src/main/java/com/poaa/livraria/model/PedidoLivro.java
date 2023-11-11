package com.poaa.livraria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedido_livro")
public class PedidoLivro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long pedido_id;
    private long livro_id;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getPedido_id() {
        return pedido_id;
    }
    public void setPedido_id(long pedido_id) {
        this.pedido_id = pedido_id;
    }
    public long getLivro_id() {
        return livro_id;
    }
    public void setLivro_id(long livro_id) {
        this.livro_id = livro_id;
    }
    
}
