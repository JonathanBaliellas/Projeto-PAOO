package com.poaa.livraria.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long cliente_id;
    private Date data;
    private double valor;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getCliente_id() {
        return cliente_id;
    }
    public void setCliente_id(long cliente_id) {
        this.cliente_id = cliente_id;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
