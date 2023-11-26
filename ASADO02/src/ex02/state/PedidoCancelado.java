package ex02.state;

import ex02.loja.Pedido;

public class PedidoCancelado implements EstadoCompra {

    private Pedido pedido;

    public PedidoCancelado(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void pedidoPagamentoConfirmado() {
        this.pedido.setEstado(new PedidoPagamentoConfirmado(this.pedido));
    }

    @Override
    public void pedidoEmPreparacao() {
        this.pedido.setEstado(new PedidoEmPreparacao(this.pedido));
    }

    @Override
    public void pedidoCancelado() {
        System.out.println("Pedido já cancelado!");
    }

    @Override
    public void pedidoEnviado() {
        this.pedido.setEstado(new PedidoEnviado(this.pedido));
    }

    @Override
    public String getNomeEstado() {
        return "Cancelado";
    }

}
