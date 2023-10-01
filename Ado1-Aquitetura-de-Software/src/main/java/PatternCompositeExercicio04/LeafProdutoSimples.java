package PatternCompositeExercicio04;

/**
 *
 * @author Gedionesouza 
 */
public class LeafProdutoSimples implements Produto{
    private String nome;
    private double preco;

    public LeafProdutoSimples(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public double getPrecoTotal() {
        return preco;
    }

    public String getNome() {
        return nome;
    }
}

