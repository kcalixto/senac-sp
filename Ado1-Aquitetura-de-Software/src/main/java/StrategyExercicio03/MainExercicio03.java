package StrategyExercicio03;

import java.util.Arrays;

/**
 *
 * @author Guilherme 
 */

// Classe de teste que cria um array de inteiros, escolhe uma estratégia 
// de ordenação e usa o contexto para executar a ordenação.
public class MainExercicio03 {
    
    public static void main(String[] args) {
        int[] arr = { 5, 2, 9, 1, 5, 6 };

        Contexto context = new Contexto(new InsertionSort());
        context.executeSort(arr);
        System.out.println("Insertion Sort: " + Arrays.toString(arr));

        context.setArray(new SelectionSort());
        context.executeSort(arr);
        System.out.println("Selection Sort: " + Arrays.toString(arr));

        context.setArray(new BubbleSort());
        context.executeSort(arr);
        System.out.println("Bubble Sort: " + Arrays.toString(arr));
    }      
}
