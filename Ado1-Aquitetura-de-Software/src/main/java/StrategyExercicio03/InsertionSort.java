package StrategyExercicio03;

/**
 *
 * @author Guilherme
 */

// Implementa a classe InsertionSort que representa o algoritmo de ordenação 
// Insertion Sort.
public class InsertionSort implements MetodoArray{
    @Override
    public void sort(int[] arr) {
        int i, j;
        int temp;
        for (i = 1; i < arr.length; i++) {
            temp = arr[i];
            j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}

