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
                showCurrentState(header, array, externalIterations, internalIterations,
                        comparisons, assignments, j, j + 1, "Moviendo");

                j--;
                comparisons++; // Comparación j >= 0 para la siguiente iteración
            }

            // Insertar valor en posición correcta
            array[j + 1] = value;
            assignments++;

            // Mostrar inserción
            showCurrentState(header, array, externalIterations, internalIterations,
                    comparisons, assignments, i, j + 1, "Insertando");
        }

        showFinalResult(header, array, externalIterations, internalIterations,
                comparisons, assignments);
    }

// Método auxiliar para mostrar estado actual
    private static void showCurrentState(String header, int[] array, int externalIt,
            int internalIt, int comp, int assign,
            int from, int to, String operation) {
        int totalIterations = externalIt + internalIt;
        int totalOperations = comp + assign;

        System.out.print("\n".repeat(30) + header
                + "Iteraciones: " + totalIterations + " (Ext: " + externalIt + ", Int: " + internalIt + ")"
                + "\nOperaciones: " + totalOperations + " (Comp: " + comp + ", Asig: " + assign + ")"
                + "\nIndices: " + from + " → " + to + "\n\n"
                + SortingUtils.barsToString(array)
                + "\n" + operation + ": " + from + " → " + to);
        System.out.flush();

        SortingUtils.wait(500);
    }

// Método auxiliar para mostrar resultado final
    private static void showFinalResult(String header, int[] array, int externalIt,
            int internalIt, int comp, int assign) {
        int totalIterations = externalIt + internalIt;
        int totalOperations = comp + assign;

        System.out.print("\n".repeat(30) + header
                + "=== COMPLETADO ===\n\n"
                + SortingUtils.barsToString(array)
                + "\n¡Array completamente ordenado!"
                + "\n\n--- ESTADÍSTICAS ---"
                + "\nIteraciones del bucle externo: " + externalIt
                + "\nIteraciones del bucle interno: " + internalIt
                + "\nTotal iteraciones: " + totalIterations
                + "\nComparaciones realizadas: " + comp
                + "\nAsignaciones realizadas: " + assign
                + "\nTotal operaciones: " + totalOperations);
        System.out.flush();
    }

}
