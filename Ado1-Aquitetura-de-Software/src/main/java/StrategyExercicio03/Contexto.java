package StrategyExercicio03;

/**
 *
 * @author Guilherme
 */

// Classe Contexto que aceita uma estratégia de ordenação e usa essa
// estratégia para realizar a ordenação.
public class Contexto {
    
    private MetodoArray Array;

    public Contexto(MetodoArray Array) {
        this.Array = Array;
    }

    public void setArray(MetodoArray Array) {
        this.Array = Array;
    }

    public void executeSort(int[] arr) {
        Array.sort(arr);
    }
}

