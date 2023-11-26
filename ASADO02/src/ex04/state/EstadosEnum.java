package ex04.state;

public enum EstadosEnum implements Contexto {
  PENDENTE {
    @Override
    public String getMensagem() {
      return "Pendente";
    }
  },

  ATRASADA {
    @Override
    public String getMensagem() {
      return "Atrasada";
    }
  },

  CONCLUIDA {
    @Override
    public String getMensagem() {
      return "Concluída";
    }
  }

}
