package StrategyExercicio02;

/**
 *
 * @author kcalixto
 */

// Implementação da classe Ip1 que representa o imposto Ip1 com taxa de 10%.
public class Ip1 implements Imposto{
    @Override
    public double calcular(double valor) {
        return valor * 0.10; // Calcula o imposto como 10% do valor.
    }
}
