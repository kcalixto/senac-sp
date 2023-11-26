package ex03.state;

import ex03.cliente.Tarefa;

public class Atrasada implements Estados {
    private String msg = "Atrasada";

    public Atrasada() {
    }

    @Override
    public void atrasar() {
        System.out.println("Já está atrasada");
    }

    @Override
    public void concluir() {
        Tarefa.setEstado(new Concluida());
    }

    @Override
    public void pendente() {
        Tarefa.setEstado(new Pendente());
    }

    @Override
    public String toString() {
        return "Atrasada{" + "msg=" + msg + '}';
    }
}
