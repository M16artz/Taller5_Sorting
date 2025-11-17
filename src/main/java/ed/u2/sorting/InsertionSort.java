package ed.u2.sorting;

/**
 *
 * @author MikelMZ : Miguel Armas
 */
public final class InsertionSort {

    public static void sort(int[] array) {

        int value;
        for (int i = 1; i < array.length; i++) {

            value = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > value) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = value;
        }
    }

    public static void sort(int[] array, boolean trace) {
        if (!trace) {
            sort(array);
            return;
        }

        // Contadores
        int externalIterations = 0;
        int internalIterations = 0;
        int comparisons = 0;
        int assignments = 0;

        String header = "=== INSERTION SORT ===\n";

        for (int i = 1; i < array.length; i++) {
            externalIterations++;

            int value = array[i];
            assignments++;
            int j = i - 1;

            
            comparisons++;
            while (j >= 0 && array[j] > value) {
                internalIterations++;
                comparisons++; // Comparación array[j] > value

                // Mover elemento
                array[j + 1] = array[j];
                assignments++;

                // Mostrar estado actual
                SortingUtils.showCurrentState(header, array, externalIterations, internalIterations,
                        comparisons, assignments, j, j + 1, "Moviendo");

                j--;
                comparisons++; // Comparación j >= 0 para la siguiente iteración
            }

            // Insertar valor en posición correcta
            array[j + 1] = value;
            assignments++;

            // Mostrar inserción
            SortingUtils.showCurrentState(header, array, externalIterations, internalIterations,
                    comparisons, assignments, i, j + 1, "Insertando");
        }

        SortingUtils.showFinalResult(header, array, externalIterations, internalIterations,
                comparisons, assignments);
    }

}
