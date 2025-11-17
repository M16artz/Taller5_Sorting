package ed.u2.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class SortingDemo {

    private static final int[] A = {8, 3, 6, 3, 9};
    private static final int[] B = {5, 4, 3, 2, 1}; // Inverso
    private static final int[] C = {1, 2, 3, 4, 5}; // Ya ordenado
    private static final int[] D = {2, 2, 2, 2};    // Duplicados
    private static final int[] E = {9, 1, 8, 2};

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("--- DEMOSTRACIÓN DE ALGORITMOS DE ORDENACIÓN IN-PLACE ---");

        while (true) {
            // Paso 1: Seleccionar o crear el arreglo
            int[] currentArray = null;
            currentArray = selectArrayMenu(currentArray);

            if (currentArray == null) {
                System.out.println("Gracias por usar, Fin de la demostración =)");
                break;
            }

            sortMenu(currentArray);
        }
    }

    /**
     * Muestra el menú para elegir/crear un arreglo.
     */
    private static int[] selectArrayMenu(int[] current) {
        if (current != null) {
            System.out.println("\n--- Arreglo actual seleccionado:  ---");
            System.out.println(Arrays.toString(current));
        }
        while (true) {
            System.out.println("\n[1. SELECCION DE DATOS]");
            System.out.println("1. Usar Caso de Prueba Predefinido (A, B, C, D, E)");
            System.out.println("2. Generar Arreglo Aleatorio (N números)");
            System.out.println("3. Ingresar Arreglo Manualmente (uno por uno)");
            System.out.println("0. Salir de la aplicación");
            System.out.print("Seleccione una opción: ");

            int choice = SortingUtils.getIntInput(0, 3);

            switch (choice) {
                case 1:
                    return selectPredefinedArray();
                case 2:
                    return SortingUtils.generateRandomArray();
                case 3:
                    return SortingUtils.inputManualArray();
                case 0:
                    return null; // Salir
                default:
                    System.out.println("Ingrese una opción válida.");

            }
        }
    }

    /**
     * Permite al usuario seleccionar uno de los arrays predefinidos.
     */
    private static int[] selectPredefinedArray() {
        while (true) {
            System.out.println("Elegir dataset: ");
            System.out.println("1. " + Arrays.toString(A));
            System.out.println("2. " + Arrays.toString(B));
            System.out.println("3. " + Arrays.toString(C));
            System.out.println("4. " + Arrays.toString(D));
            System.out.println("5. " + Arrays.toString(E));
            System.out.print("Seleccione un opción (1-5): ");
            String selection = scanner.nextLine().trim();
            if (selection.isEmpty()) {
                System.out.println("Entrada vacía. Por favor ingrese 1-5.");
                continue;
            }
            int[] selected = null;
            switch (selection) {
                case "1":
                    selected = A;
                    return Arrays.copyOf(selected, selected.length);
                case "2":
                    selected = B;
                    return Arrays.copyOf(selected, selected.length);
                case "3":
                    selected = C;
                    return Arrays.copyOf(selected, selected.length);
                case "4":
                    selected = D;
                    return Arrays.copyOf(selected, selected.length);
                case "5":
                    selected = E;
                    return Arrays.copyOf(selected, selected.length);
                default:
                    System.out.println("Dataset no reconocido. Ingrese una opción válida.");
            }
        }

    }

    /**
     * Muestra el menú de algoritmos y modo de ejecución (trazas).
     */
    private static void sortMenu(int[] arr) {
        String algorithmChoice;
        while (true) {
            System.out.println("\n[2. EJECUCIÓN DE ORDENACIÓN]");
            System.out.println("Arreglo a ordenar: " + Arrays.toString(arr));
            System.out.println("1. Insertion Sort (In-place)");
            System.out.println("2. Selection Sort (In-place)");
            System.out.println("3. Bubble Sort (In-place)");
            System.out.println("0. Volver al menú de selección de Arreglo");
            System.out.print("Seleccione un algoritmo (1/2/3/0): ");

            algorithmChoice = scanner.nextLine().trim();

            if (algorithmChoice.equals("0")) {
                System.out.println("Regresando al menú principal...");
                return;
            }

            if (algorithmChoice.equals("1") || algorithmChoice.equals("2") || algorithmChoice.equals("3")) {
                break;
            } else {
                System.out.println("Ingrese una opción válida (1, 2, 3 o 0).");
            }
        }
        
        System.out.print("¿Desea la ejecución CON trazas para evidencias? (S/N): ");
        String traceChoice = scanner.nextLine().trim().toUpperCase();
        boolean trace = traceChoice.equals("S");

        long startTime = System.nanoTime();
        switch (algorithmChoice) {
            case "1":
                System.out.println("\n--- Ejecutando Insertion Sort (Recomendado empezar aquí) ---");
                InsertionSort.sort(arr, trace);
                break;
            case "2":
                System.out.println("\n--- Ejecutando Selection Sort ---");
                SelectionSort.sort(arr, trace);
                break;
            case "3":
                System.out.println("\n--- Ejecutando Bubble Sort --- (Verifique optimización de corte temprano)");
                BubbleSort.sort(arr, trace);
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        long endTime = System.nanoTime();
        long durationMs = (endTime - startTime) / 1_000_000;

        System.out.println("\n--- RESULTADO FINAL ---");
        System.out.println("Arreglo Ordenado: \n" + Arrays.toString(arr));
        System.out.printf("Tiempo de ejecución: %d ms\n", durationMs);
        System.out.println("-----------------------\n");
    }

}
