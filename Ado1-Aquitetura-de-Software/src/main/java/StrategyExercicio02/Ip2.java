package StrategyExercicio02;
/**
 *
 * @author kcalixto 
 */

// Implementação da classe Ip2 que representa o imposto Ip2 com taxa de 15%.
public class Ip2 implements Imposto{
    @Override
    public double calcular(double valor) {
        return valor * 0.15; // Calcula o imposto como 15% do valor.
    }
}
