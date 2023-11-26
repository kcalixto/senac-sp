package ex02.state;

import ex02.loja.Pedido;

public class PedidoPagamentoConfirmado implements EstadoCompra {

    private Pedido pedido;

    public PedidoPagamentoConfirmado(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void pedidoPagamentoConfirmado() {
        System.out.println("Pagamento já confirmado!");
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
        this.pedido.setEstado(new PedidoEnviado(this.pedido));
    }

    @Override
    public String getNomeEstado() {
        return "Pagamento confirmado";
    }

}
