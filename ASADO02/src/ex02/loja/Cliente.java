package ex02.loja;

public class Cliente {
    private String nome;
    private Pedido[] pedidos;

    public Cliente(String nome) {
        this.nome = nome;
        this.pedidos = new Pedido[0];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pedido[] getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedido[] pedidos) {
        this.pedidos = pedidos;
    }

}
