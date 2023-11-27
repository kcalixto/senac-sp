package com.ado.carros.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CarroDTO {
    private Long id;

    @NotBlank(message = "Não deve estar em branco")
    @Min(value = 2, message = "Deve ter no mínimo 2 caracteres")
    private String modelo;

    @NotBlank(message = "Não deve estar em branco")
    private String fabricante;

    @NotBlank(message = "Não deve estar em branco")
    private String anoLancamento;

    public CarroDTO() {
    }

    public CarroDTO(Long id, String modelo, String fabricante, String anoLancamento) {
        this.id = id;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.anoLancamento = anoLancamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
