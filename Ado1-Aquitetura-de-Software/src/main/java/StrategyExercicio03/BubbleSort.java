package StrategyExercicio03;

/**
 *
 * @author Guilherme 
 */

// Implementa a classe BubbleSort que representa o algoritmo de 
// ordenação Bubble Sort.
class BubbleSort implements MetodoArray {
    @Override
    public void sort(int[] arr) {
        int i, j;
        int temp;
        for (j = 0; j < arr.length - 1; j++) {
            for (i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }
}

