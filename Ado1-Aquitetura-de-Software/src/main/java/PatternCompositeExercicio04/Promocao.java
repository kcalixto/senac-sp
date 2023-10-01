package PatternCompositeExercicio04;

/**
 *
 * @author Gedionesouza 
 */

// Implementa a classe Promocao que representa um produto em promoção no 
// carrinho de compras.
public class Promocao implements Produto{
  private String nome;
    private double preco;
    private double desconto;

    public Promocao(String nome, double preco, double desconto) {
        this.nome = nome;
        this.preco = preco;
        this.desconto = desconto;
    }

    @Override
    public double getPrecoTotal() {
        return preco * (1 - desconto);
    }

    public String getNome() {
        return nome;
    }
}