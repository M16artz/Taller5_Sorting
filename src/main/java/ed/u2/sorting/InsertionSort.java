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

        int value;
        for (int i = 1; i < array.length; i++) {

            value = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > value) {
                array[j + 1] = array[j];

                SortingUtils.cleanConsole();
                System.out.println("Indices Movidos: ");
                System.out.println("Indices: " + (j + 1));
                System.out.println("Indices: " + (j));
                SortingUtils.showAsBars(array);
                SortingUtils.wait(500);
                j--;
            }

            array[j + 1] = value;
            SortingUtils.cleanConsole();
            System.out.println("Indices Movidos: ");
            System.out.println("Indices: " + (j + 1));
            System.out.println("Indices: " + (i));
            SortingUtils.showAsBars(array);
            SortingUtils.wait(500);
        }
    }

}
