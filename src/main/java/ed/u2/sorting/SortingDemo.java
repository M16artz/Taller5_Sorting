
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

    /** Muestra el menú para elegir/crear un arreglo. */
    private static int[] selectArrayMenu(int[] current) {
        if (current != null) {
            System.out.println("\n--- Arreglo actual seleccionado: " + Arrays.toString(current) + " ---");
        }
        
        System.out.println("\n[1. SELECCION DE DATOS]");
        System.out.println("1. Usar Caso de Prueba Predefinido (A, B, C, D, E)");
        System.out.println("2. Generar Arreglo Aleatorio (N números)");
        System.out.println("3. Ingresar Arreglo Manualmente (uno por uno)");
        System.out.println("0. Salir de la aplicación");
        System.out.print("Seleccione una opción: ");

        int choice = getIntInput(0, 3);
        
        switch (choice) {
            case 1: return selectPredefinedArray();
            case 2: return generateRandomArray();
            case 3: return inputManualArray();
            case 0: return null; // Salir
            default: return current;
        }
    }

    /** Permite al usuario seleccionar uno de los arrays predefinidos. */
    private static int[] selectPredefinedArray() {
        System.out.print("Elegir dataset (A, B, C, D, E): ");
        String selection = scanner.next().toUpperCase();

        int[] selected = null;
        switch (selection) {
            case "A": selected = A; break;
            case "B": selected = B; break;
            case "C": selected = C; break;
            case "D": selected = D; break;
            case "E": selected = E; break;
            default:
                System.out.println("Dataset no reconocido. Usando el dataset A por defecto.");
                selected = A;
        }
        // Devolvemos una copia para que la ordenación 'in-place' no afecte al original [cite: 47]
        return Arrays.copyOf(selected, selected.length);
    }
    
    /** Permite al usuario ingresar valores uno por uno. */
    private static int[] inputManualArray() {
        List<Integer> temp = new ArrayList<>();
        System.out.println("--- INGRESO MANUAL ---");
        System.out.println("Ingrese números enteros. Escriba 'N' para terminar.");
        
        while (true) {
            System.out.print("Valor: ");
            if (scanner.hasNextInt()) {
                temp.add(scanner.nextInt());
            } else {
                String input = scanner.next();
                if (input.equalsIgnoreCase("N")) {
                    break;
                }
                System.out.println("Entrada inválida. Ingrese un número o 'N'.");
            }
        }

        if (temp.isEmpty()) {
            System.out.println("Arreglo vacío creado."); // Caso borde [cite: 60]
        }
        
        // Convertir List<Integer> a int[]
        int[] result = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
    }

    /** Permite generar un arreglo con N números aleatorios. */
    private static int[] generateRandomArray() {
        System.out.print("Ingrese el tamaño (N) del arreglo a generar: ");
        int size = getIntInput(1, Integer.MAX_VALUE);
        
        System.out.print("Rango máximo (ej: 100): ");
        int range = getIntInput(1, Integer.MAX_VALUE);

        int[] randomArray = new int[size];
        for (int i = 0; i < size; i++) {
            randomArray[i] = (int) (Math.random() * range) + 1;
        }
        return randomArray;
    }

    // --- MÉTODOS DE MENÚ DE ORDENACIÓN Y EJECUCIÓN ---

    /** Muestra el menú de algoritmos y modo de ejecución (trazas). */
    private static void sortMenu(int[] arr) {
        System.out.println("\n[2. EJECUCIÓN DE ORDENACIÓN]");
        System.out.println("Arreglo a ordenar: " + Arrays.toString(arr));
        System.out.println("A. Insertion Sort (In-place)");
        System.out.println("B. Selection Sort (In-place)");
        System.out.println("C. Bubble Sort (In-place)");
        System.out.println("0. Volver al menú de selección de Arreglo");
        System.out.print("Seleccione un algoritmo (A/B/C/0): ");

        String algorithmChoice = scanner.next().toUpperCase();
        if (algorithmChoice.equals("0")) {
            return; // Vuelve al menú principal
        }
        
        System.out.print("¿Desea la ejecución CON trazas para evidencias? (S/N): ");
        String traceChoice = scanner.next().toUpperCase();
        boolean trace = traceChoice.equals("S");

        long startTime = System.nanoTime();
        
        switch (algorithmChoice) {
            case "A":
                System.out.println("\n--- Ejecutando Insertion Sort (Recomendado empezar aquí) --- [cite: 49]");
                InsertionSort.sort(arr, trace);
                break;
            case "B":
                System.out.println("\n--- Ejecutando Selection Sort ---");
                
                break;
            case "C":
                System.out.println("\n--- Ejecutando Bubble Sort --- (Verifique optimización de corte temprano) [cite: 58]");
                
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        long endTime = System.nanoTime();
        long durationMs = (endTime - startTime) / 1_000_000;

        System.out.println("\n--- RESULTADO FINAL ---");
        System.out.println("Arreglo Ordenado: " + Arrays.toString(arr));
        System.out.printf("Tiempo de ejecución: %d ms\n", durationMs);
        System.out.println("-----------------------\n");
    }

    // --- UTILITY METHODS ---

    /** Método auxiliar para asegurar entrada de enteros. */
    private static int getIntInput(int min, int max) {
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. Por favor, ingrese un número: ");
            scanner.next(); // Consume la entrada inválida
        }
        int input = scanner.nextInt();
        if (input < min || input > max) {
        }
        return input;
    }
}
