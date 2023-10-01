package PatternCompositeExercicio04;

/**
 *
 * @author Gedionesouza 
 */

// Classe Pedido que gerencia os pedidos do cliente e calcula o preço total da compra.
public class Pedido {
 private String nomeCliente;
    private int numeroPedido;
    private CarrinhoCompra carrinho;

    public Pedido(String nomeCliente, int numeroPedido, CarrinhoCompra carrinho) {
        this.nomeCliente = nomeCliente;
        this.numeroPedido = numeroPedido;
        this.carrinho = carrinho;
    }

    public void exibirPedido() {
        System.out.println("Número do Pedido: " + numeroPedido);
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Itens no Carrinho:");

        for (Produto produto : carrinho.getProdutos()) {
            System.out.println("- " + produto.getNome() + " | Preço: R$" + produto.getPrecoTotal());
        }

        System.out.println("Total da Compra: R$" + carrinho.getPrecoTotal());
    }
}