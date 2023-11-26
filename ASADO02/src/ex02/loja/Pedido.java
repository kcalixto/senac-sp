package ex02.loja;

import java.util.ArrayList;

import ex02.state.EstadoCompra;
import ex02.state.PedidoEmPreparacao;

public class Pedido {
    private String id;
    private String nomeCliente;
    private ArrayList<Produto> produtos;
    private EstadoCompra estado;

    public Pedido() {
    }

    public Pedido(String id, String nomeCliente, ArrayList<Produto> produtos) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.produtos = produtos;
        this.estado = new PedidoEmPreparacao(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public EstadoCompra getEstado() {
        return estado;
    }

    public void setEstado(EstadoCompra estado) {
        this.estado = estado;
    }

    public String toString() {
        String produtos = "";
        for (Produto produto : this.produtos) {
            produtos += produto.getNome() + "\n";
        }

        return String.format("id: %s\nNome do cliente: %s\nProdutos:\n %sEstado: %s", this.id, this.nomeCliente,
                produtos, this.estado.getNomeEstado());
    }

}
