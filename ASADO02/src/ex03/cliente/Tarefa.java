package ex03.cliente;

import ex03.state.Estados;
import ex03.state.Pendente;

public class Tarefa {
    private static String descricao;
    private static Estados estado = new Pendente();

    public static void definirDescricao(String desc) {
        descricao = desc;
    }

    public static String obterDescricao() {
        return descricao;
    }

    public static void requisitarAtrasada() {
        System.out.println(descricao + " marcada como atrasada");
        estado.atrasar();
    }

    public static void requisitarConcluida() {
        System.out.println(descricao + " marcada como concluída");
        estado.concluir();
    }

    public static void requisitarPendete() {
        System.out.println(descricao + " marcada como pendente");
        estado.pendente();
    }

    public static Estados getEstado() {
        return estado;
    }

    public static void setEstado(Estados estado) {
        Tarefa.estado = estado;
    }
}
