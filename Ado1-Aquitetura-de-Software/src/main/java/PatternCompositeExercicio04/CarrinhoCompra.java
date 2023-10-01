package PatternCompositeExercicio04;

/**
 *
 * @author Gedionesouza 
 */
import java.util.ArrayList;
import java.util.List;

// Implementa a classe CarrinhoCompra que representa o carrinho de compras 
//contendo produtos individuais ou em promoção.
public class  CarrinhoCompra implements Produto {
 private List<ProdutoWrapper> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.add(new ProdutoWrapper(produto));
    }

    @Override
    public double getPrecoTotal() {
        double total = 0;
        for (ProdutoWrapper wrapper : produtos) {
            total += wrapper.getProduto().getPrecoTotal();
        }
        return total;
    }

    public List<String> getNomesDosProdutos() {
        List<String> nomes = new ArrayList<>();
        for (ProdutoWrapper wrapper : produtos) {
            nomes.add(wrapper.getNome());
        }
        return nomes;
    }

    public List<Produto> getProdutos() {
        List<Produto> listaProdutos = new ArrayList<>();
        for (ProdutoWrapper wrapper : produtos) {
            listaProdutos.add(wrapper.getProduto());
        }
        return listaProdutos;
    }

    @Override
    public String getNome() {
        return null;
    }

    private static class ProdutoWrapper {
        private Produto produto;
        private String nome;

        public ProdutoWrapper(Produto produto) {
            this.produto = produto;
            this.nome = produto.getNome();
        }

        public Produto getProduto() {
            return produto;
        }

        public String getNome() {
            return nome;
        }
    }
}

