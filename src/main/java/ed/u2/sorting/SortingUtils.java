/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ed.u2.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author MikelMZ : Miguel Armas
 */
public class SortingUtils {
    
    private static Scanner scanner = new Scanner(System.in);

    public static void showAsArray(int[] arreglo) {
        System.out.println();
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 1; j <= arreglo[i]; j++) {
                System.out.print(arreglo[i] + " ");
            }
            System.out.println();
        }
    }
    
    public static void showAsBars(int[] arreglo) {
        System.out.println();
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 1; j <= arreglo[i]; j++) {
                System.out.print(arreglo[i] + " ");
            }
            System.out.println();
        }
    }

    public static void wait(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void cleanConsole() {
        // Simulación básica de limpieza
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    
    public static void cleanConsole(boolean complete) {
        
    }
    
    
    /**
     * Permite al usuario ingresar valores uno por uno.
     */
    public static int[] inputManualArray() {
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
            System.out.println("Arreglo vacío creado.");
        }

        // Convertir List<Integer> a int[]
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
        System.out.print("Ingrese el tamaño (N) del arreglo a generar: ");
        int size = getIntInput(1, Integer.MAX_VALUE);

        //Se define el valor máximo de valor cómo 40 para controlar la presentación del arreglo
        int range = 40;

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
