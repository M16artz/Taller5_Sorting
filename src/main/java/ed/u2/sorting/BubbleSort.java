package ed.u2.sorting;

/**
 *
 * @author MikelMZ : Miguel Armas
 */
public final class BubbleSort {

    public static void sort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
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

        String header = "=== BUBBLE SORT ===\n";

        for (int i = 0; i < array.length; i++) {
            externalIterations++;
            boolean swapped = false;

            // Mostrar inicio de pasada externa
            SortingUtils.showCurrentState(header, array, externalIterations, internalIterations,
                    comparisons, assignments, i, -1, "Inicio pasada " + (i + 1));

            for (int j = 0; j < array.length - 1 - i; j++) {
                internalIterations++;
                comparisons++; // Comparación arreglo[j] > arreglo[j + 1]

                if (array[j] > array[j + 1]) {
                    // Realizar intercambio
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    assignments += 3; // 3 asignaciones por intercambio
                    swapped = true;

                    // Mostrar estado después del intercambio
                    SortingUtils.showCurrentState(header, array, externalIterations, internalIterations,
                            comparisons, assignments, j, j + 1, "Intercambiando");
                }
            }

            // Mostrar fin de pasada externa
            SortingUtils.showCurrentState(header, array, externalIterations, internalIterations,
                    comparisons, assignments, i, -1, "Fin pasada " + (i + 1) + (swapped ? "" : " - Sin cambios"));

            // Si no hubo intercambios, el array está ordenado
            if (!swapped) {
                break;
            }
        }

        SortingUtils.showFinalResult(header, array, externalIterations, internalIterations,
                comparisons, assignments);
    }

}
