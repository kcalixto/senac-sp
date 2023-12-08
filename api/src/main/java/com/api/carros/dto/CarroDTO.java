package com.api.carros.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CarroDTO {
    private Long id;

    @NotBlank(message = "Não deve estar em branco")
    @Size(min = 2, max = 50, message = "Deve conter entre 2 e 50 caracteres")
    private String modelo;

    @NotBlank(message = "Não deve estar em branco")
    @Size(min = 2, max = 50, message = "Deve conter entre 2 e 50 caracteres")
    private String fabricante;

    @Min(value = 1900, message = "Deve ser maior que 1900")
    @Max(value = 2023, message = "Não pode ser maior que o ano atual")
    private int anoLancamento;

    public CarroDTO() {
    }

    public CarroDTO(Long id, String modelo, String fabricante, int anoLancamento) {
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

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
}
