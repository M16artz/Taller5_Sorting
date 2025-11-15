package ed.u2.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        int[] currentArray = null;

        while (true) {
            // Paso 1: Seleccionar o crear el arreglo
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
            System.out.println("\n--- Arreglo actual seleccionado: " + Arrays.toString(current) + " ---");
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
                    ;
            }
        }
    }

    /**
     * Permite al usuario seleccionar uno de los arrays predefinidos.
     */
    private static int[] selectPredefinedArray() {
        while (true) {
            System.out.print("Elegir dataset: ");
            System.out.println("A. " + Arrays.toString(A));
            System.out.println("B. " + Arrays.toString(B));
            System.out.println("C. " + Arrays.toString(C));
            System.out.println("D. " + Arrays.toString(D));
            System.out.println("E. " + Arrays.toString(E));
            String selection = scanner.next().toUpperCase();

            int[] selected = null;
            switch (selection) {
                case "A":
                    selected = A;
                    return Arrays.copyOf(selected, selected.length);
                case "B":
                    selected = B;
                    return Arrays.copyOf(selected, selected.length);
                case "C":
                    selected = C;
                    return Arrays.copyOf(selected, selected.length);
                case "D":
                    selected = D;
                    return Arrays.copyOf(selected, selected.length);
                case "E":
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
            System.out.print("Seleccione un algoritmo (A/B/C/0): ");

            algorithmChoice = scanner.next().toUpperCase();
            if (algorithmChoice.equals("0")) {
                System.out.println("Regresando al menú principal...");
                return; // Vuelve al menú principal
            }
            if (algorithmChoice.equals("1") || algorithmChoice.equals("2") || algorithmChoice.equals("3")) {
                break;
            }else{
                System.out.println("Ingrese una opción válida.");
            }
        }
        System.out.print("¿Desea la ejecución CON trazas para evidencias? (S/N): ");
        String traceChoice = scanner.next().toUpperCase();
        boolean trace = traceChoice.equals("S");

        long startTime = System.nanoTime();
        if(trace){
        switch (algorithmChoice) {
            case "A":
                System.out.println("\n--- Ejecutando Insertion Sort (Recomendado empezar aquí) ---");
                InsertionSort.sort(arr, trace);
                break;
            case "B":
                System.out.println("\n--- Ejecutando Selection Sort ---");

                break;
            case "C":
                System.out.println("\n--- Ejecutando Bubble Sort --- (Verifique optimización de corte temprano)");

                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }
        }else{
            switch (algorithmChoice) {
            case "A":
                System.out.println("\n--- Ejecutando Insertion Sort (Recomendado empezar aquí) --- ");
                InsertionSort.sort(arr);
                break;
            case "B":
                System.out.println("\n--- Ejecutando Selection Sort ---");

                break;
            case "C":
                System.out.println("\n--- Ejecutando Bubble Sort --- (Verifique optimización de corte temprano)");

                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }
        }

        long endTime = System.nanoTime();
        long durationMs = (endTime - startTime) / 1_000_000;

        System.out.println("\n--- RESULTADO FINAL ---");
        System.out.println("Arreglo Ordenado: " + Arrays.toString(arr));
        System.out.printf("Tiempo de ejecución: %d ms\n", durationMs);
        System.out.println("-----------------------\n");
    }

}
