
package StrategyExercicio02;

import java.util.List;

/**
 *
 * @author kcalixto 
 */

// Define a classe Orcamento que representa um orçamento com uma lista de valores.
public class Orcamento {
   
    private final List<Double> valores;

    // Construtor que aceita uma lista de valores.
    public Orcamento(List<Double> valores) {
        this.valores = valores;
    }

    // Método para obter a lista de valores do orçamento.
    public List<Double> getValores() {
        return valores;
    }
}
