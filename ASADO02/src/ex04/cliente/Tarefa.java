package ex04.cliente;

import ex04.state.EstadosEnum;

public class Tarefa {
    private String descricao;
    private EstadosEnum estado;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.estado = EstadosEnum.PENDENTE;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public EstadosEnum getEstado() {
        return estado;
    }

    protected void requisitarAtrasada() {
        estado = EstadosEnum.ATRASADA;
    }

    protected void requisitarConcluida() {
        estado = EstadosEnum.CONCLUIDA;
    }

    protected void requisitarPendete() {
        estado = EstadosEnum.PENDENTE;
    }

}
