package ex03.state;

import ex03.cliente.Tarefa;

public class Pendente implements Estados {
    private String msg = "Pendente";

    public Pendente() {
    }

    @Override
    public void atrasar() {
        Tarefa.setEstado(new Atrasada());
    }

    @Override
    public void concluir() {
        Tarefa.setEstado(new Concluida());
    }

    @Override
    public void pendente() {
        System.out.println("Já está pendente");
    }

    @Override
    public String toString() {
        return "Pendente{" + "msg=" + msg + '}';
    }
}
