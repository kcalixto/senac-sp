package ex02.state;

import ex02.loja.Pedido;

public class PedidoEnviado implements EstadoCompra {

    private Pedido pedido;

    public PedidoEnviado(Pedido pedido) {
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
        this.pedido.setEstado(new PedidoCancelado(this.pedido));
    }

    @Override
    public void pedidoEnviado() {
        System.out.println("Pedido já enviado!");
    }

    @Override
    public String getNomeEstado() {
        return "Enviado";
    }

}
