package ex03.state;

import ex03.cliente.Tarefa;

public class Concluida implements Estados {

    private String msg = "Conclu�da";

    public Concluida() {
    }

    @Override
    public void atrasar() {
        Tarefa.setEstado(new Atrasada());
    }

    @Override
    public void concluir() {
        System.out.println("Já está concluída");
    }

    @Override
    public void pendente() {
        Tarefa.setEstado(new Pendente());
    }

    @Override
    public String toString() {
        return "Concluida{" + "msg=" + msg + '}';
    }
}
