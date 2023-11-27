package com.ado.carros.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "carros")
public class CarroModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String fabricante;

    @Column(nullable = false)
    private String anoLancamento;

    public CarroModel() {
    }

    public CarroModel(String modelo, String fabricante, String anoLancamento) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.anoLancamento = anoLancamento;
    }

    public CarroModel(long id, String modelo, String fabricante, String anoLancamento) {
        this.id = id;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.anoLancamento = anoLancamento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

}
