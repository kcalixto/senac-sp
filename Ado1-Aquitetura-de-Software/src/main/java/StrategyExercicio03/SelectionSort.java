package StrategyExercicio03;

/**
 *
 * @author Guilherme
 */

// Implementa a classe SelectionSort que representa o algoritmo de 
// ordenação Selection Sort.
class SelectionSort implements MetodoArray {
    @Override
    public void sort(int[] arr) {
        int i, j, min, aux;
        for (i = 0; i < arr.length - 1; i++) {
            min = i;
            for (j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            aux = arr[i];
            arr[i] = arr[min];
            arr[min] = aux;
        }
    }
}


