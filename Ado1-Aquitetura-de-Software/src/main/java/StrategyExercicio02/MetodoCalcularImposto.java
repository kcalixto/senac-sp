package StrategyExercicio02;

/**
 *
 * @author kcalixto
 */

// Define a classe MetodoCalcularImposto que realiza cálculos de impostos com
// base em um orçamento e um tipo de imposto.
public class MetodoCalcularImposto {
    public double calcular(Orcamento orcamento, Imposto imposto) {
        double totalImposto = 0;
        for (Double valor : orcamento.getValores()) {
            totalImposto += imposto.calcular(valor);// Chama o método calcular do imposto para cada valor e acumula o
                                                    // resultado.
        }
        return totalImposto; // Retorna o total de imposto calculado.
    }
}
