package StrategyExercicio02;
/**
 *
 * @author kcalixto 
 */

// Implementação da classe Ip3 que representa o imposto Ip3 com taxa de 25%.
public class Ip3 implements Imposto{
    @Override
    public double calcular(double valor) {
        return valor * 0.25; // Calcula o imposto como 25% do valor.
    }
}
