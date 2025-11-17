package ed.u2.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author MikelMZ : Miguel Armas
 */
public class SortingUtils {

    private static Scanner scanner = new Scanner(System.in);

    public static String barsToString(int[] array) {
        if (array == null || array.length == 0) {
            return "Array vacío";
        }

        StringBuilder bars = new StringBuilder();
        int maxValue = Arrays.stream(array).max().orElse(1);
        int maxValueWidth = String.valueOf(maxValue).length();
        int maxBarWidth = 35;

        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            int barLength = (value * maxBarWidth) / Math.max(1, maxValue);

            String bar = "█".repeat(Math.max(1, barLength));
            String valueStr = String.format("(%" + maxValueWidth + "d)", value);

            // Usar formato con padding fijo
            bars.append(String.format("%2d: %-" + maxBarWidth + "s %s",
                    i, bar, valueStr))
                    .append("\n");
        }

        return bars.toString();
    }

    public static void wait(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Permite al usuario ingresar valores uno por uno.
     */
    public static int[] inputManualArray() {
        List<Integer> temp = new ArrayList<>();
        System.out.println("--- INGRESO MANUAL ---");
        System.out.println("Ingrese entre 2 y 15 números enteros. Escriba 'N' para terminar.");
        int count = 0;

        while (count < 15) {
            System.out.print("Valor " + (count + 1) + ": ");

            // Leer siempre como string primero para mayor control
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("N")) {
                if (count >= 2) {
                    break;
                } else {
                    System.out.println("Debe ingresar al menos 2 números antes de terminar.");
                    continue;
                }
            }

            // Intentar convertir a número
            try {
                int number = Integer.parseInt(input);
                temp.add(number);
                count++;

                if (count == 15) {
                    System.out.println("Límite de 15 elementos alcanzado.");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número o 'N'.");
            }
        }

        // Validación adicional
        if (temp.size() < 2) {
            System.out.println("Se requieren al menos 2 elementos. Usando valores por defecto.");
            return new int[]{5, 2, 8, 1, 9}; // Array por defecto
        }

        int[] result = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
    }

    /**
     * Permite generar un arreglo con N números aleatorios.
     */
    public static int[] generateRandomArray() {
        System.out.print("Ingrese el tamaño del arreglo (2-15): ");
        int size = getIntInput(2, 15);

        int range = 60;
        int[] randomArray = new int[size];
        for (int i = 0; i < size; i++) {
            randomArray[i] = (int) (Math.random() * range) + 1;
        }
        return randomArray;
    }

    /**
     * Método auxiliar para asegurar entrada de enteros.
     */
    public static int getIntInput(int min, int max) {
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.print("Entrada inválida. Por favor, ingrese un número: ");
                scanner.next(); // Consume la entrada inválida
            }
            int input = scanner.nextInt();
            if (input >= min && input <= max) {
                return input;
            }
            System.out.print("Número fuera de rango. Ingrese un número entre " + min + " y " + max + ": ");
        }
    }

    // Método auxiliar para mostrar estado actual
    public static void showCurrentState(String header, int[] array, int externalIt,
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
    public static void showFinalResult(String header, int[] array, int externalIt,
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
