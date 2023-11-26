package ex04.cliente;

public class GerenciadorTarefas {

  public static void Gerenciar() {
    Tarefa tarefa = new Tarefa("Fazer elicitação de requisitos");
    tarefa.requisitarAtrasada();
    System.out.println(tarefa.getDescricao() + ": " + tarefa.getEstado().getMensagem());

    tarefa.requisitarConcluida();
    System.out.println(tarefa.getDescricao() + ": " + tarefa.getEstado().getMensagem());

    tarefa.requisitarPendete();
    System.out.println(tarefa.getDescricao() + ": " + tarefa.getEstado().getMensagem());
  }

}
