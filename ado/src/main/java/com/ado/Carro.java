package com.ado;

public class Carro {
    private String modelo;
    private String fabricante;
    private int anoLancamento;

    public Carro(String modelo, String fabricante, int anoLancamento) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.anoLancamento = anoLancamento;
    }

    public Carro() {
    }

    public String getModelo() {
        return modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
}
