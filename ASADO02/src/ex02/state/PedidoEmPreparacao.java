package ex02.state;

import ex02.loja.Pedido;

public class PedidoEmPreparacao implements EstadoCompra {

    private Pedido pedido;

    public PedidoEmPreparacao(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void pedidoPagamentoConfirmado() {
        this.pedido.setEstado(new PedidoPagamentoConfirmado(this.pedido));
    }

    @Override
    public void pedidoEmPreparacao() {
        System.out.println("Pedido já está em preparação!");
    }

    @Override
    public void pedidoCancelado() {
        this.pedido.setEstado(new PedidoCancelado(this.pedido));
    }

    @Override
    public void pedidoEnviado() {
        this.pedido.setEstado(new PedidoEnviado(this.pedido));
    }

    @Override
    public String getNomeEstado() {
        return "Em preparação";
    }

}
