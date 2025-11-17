package ed.u2.sorting;

/**
 *
 * @author MikelMZ : Miguel Armas
 */
public final class SelectionSort {

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }

            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
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

        String header = "=== SELECTION SORT ===\n";

        for (int i = 0; i < array.length; i++) {
            externalIterations++;

            int minIndex = i;

            // Mostrar estado al comenzar nueva iteración externa
            SortingUtils.showCurrentState(header, array, externalIterations, internalIterations,
                    comparisons, assignments, i, minIndex, "Buscando mínimo");

            for (int j = i + 1; j < array.length; j++) {
                internalIterations++;
                comparisons++; // Comparación arreglo[minIndex] > arreglo[j]

                if (array[minIndex] > array[j]) {
                    minIndex = j;
                    // Mostrar cuando se encuentra nuevo mínimo
                    SortingUtils.showCurrentState(header, array, externalIterations, internalIterations,
                            comparisons, assignments, j, minIndex, "Nuevo mínimo");
                }
            }

            // Realizar intercambio si es necesario
            comparisons++;
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
                assignments += 3; // 3 asignaciones por el intercambio

                // Mostrar estado después del intercambio
                SortingUtils.showCurrentState(header, array, externalIterations, internalIterations,
                        comparisons, assignments, i, minIndex, "Intercambiando");
            } else {
                // Mostrar cuando no hay intercambio necesario
                SortingUtils.showCurrentState(header, array, externalIterations, internalIterations,
                        comparisons, assignments, i, minIndex, "Sin intercambio");
            }
        }

        SortingUtils.showFinalResult(header, array, externalIterations, internalIterations,
                comparisons, assignments);
    }

}
