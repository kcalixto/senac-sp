package ex03.cliente;

public class GerenciadorTarefas {
    public static void Gerenciar() {
        Tarefa.definirDescricao("Tarefa 1");
        Tarefa.requisitarAtrasada();
        Tarefa.requisitarConcluida();
        Tarefa.requisitarPendete();
    }
}
