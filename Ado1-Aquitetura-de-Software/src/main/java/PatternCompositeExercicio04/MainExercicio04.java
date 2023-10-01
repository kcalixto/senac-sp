package PatternCompositeExercicio04;

/**
 *
 * @author Gedionesouza
 */
public class MainExercicio04 {

    public static void main(String[] args) {
        // Cria produtos individuais, produtos em promoção e adiciona-os ao carrinho de compras.
        LeafProdutoSimples produto1 = new LeafProdutoSimples("Camiseta", 30.0);
        LeafProdutoSimples produto2 = new LeafProdutoSimples("Calça", 50.0);
        Promocao promocao = new Promocao("Sapato", 80.0, 0.2); // 20% de desconto

        CarrinhoCompra carrinho = new CarrinhoCompra();
        carrinho.adicionarProduto(produto1);
        carrinho.adicionarProduto(produto2);
        carrinho.adicionarProduto(promocao);

        // Cria um pedido e exibe os detalhes do pedido, incluindo o preço total da compra.
        Pedido pedido = new Pedido("Cliente 1", 1, carrinho);
        pedido.exibirPedido();
    }
}

