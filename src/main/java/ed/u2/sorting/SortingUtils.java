/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

    public static void cleanConsole() {
        try {
            final String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("windows")) {
                // Para Windows - usar ProcessBuilder que SÍ funciona
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Para Linux/Mac - intentar con clear command primero
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            // Si todo falla, usar el método de saltos de línea
            fallbackClear();
        }
    }

    private static void fallbackClear() {
        System.out.print("\n".repeat(100));
        System.out.flush();
    }

    /**
     * Permite al usuario ingresar valores uno por uno.
     */
    public static int[] inputManualArray() {
        List<Integer> temp = new ArrayList<>();
        System.out.println("--- INGRESO MANUAL ---");
        System.out.println("Ingrese números enteros. Escriba 'N' para terminar.");
        int count = 0;
        while (count <= 15) {
            System.out.print("Valor: ");
            if (scanner.hasNextInt()) {
                temp.add(scanner.nextInt());
                count++;
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
        System.out.print("Ingrese el tamaño (N) del arreglo a generar (máximo 15): ");
        int size = getIntInput(1, Integer.MAX_VALUE);
        if (size > 15) {
            size = 15;
        }
        //Se define el valor máximo de valor cómo 60 para controlar la presentación del arreglo
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
