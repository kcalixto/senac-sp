package composite;

public class Leaf implements Component {
    private String nome;
    private double preco;

    public Leaf() {
    }

    public Leaf(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    public String toString() {
        return "Leaf [nome=" + nome + ", preco=" + preco + "]";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
