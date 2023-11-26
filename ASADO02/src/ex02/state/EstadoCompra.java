package ex02.state;

public interface EstadoCompra {
    public void pedidoPagamentoConfirmado();

    public void pedidoEmPreparacao();

    public void pedidoCancelado();

    public void pedidoEnviado();

    public String getNomeEstado();
}
