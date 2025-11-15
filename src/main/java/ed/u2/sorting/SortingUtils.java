/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ed.u2.sorting;

/**
 *
 * @author MikelMZ : Miguel Armas
 */
public class SortingUtils {

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
}
