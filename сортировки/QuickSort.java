import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSort {
    public static void quick_Sort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quick_Sort(array, low, pivotIndex - 1);
            quick_Sort(array, pivotIndex + 1, high);
        }
    }
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }


    public static double measureTime(int[] arr) {
        long startTime = System.nanoTime();
        quick_Sort(arr,0,arr.length - 1);
        long endTime = System.nanoTime();
        return (endTime - startTime)/ 1e9;
    }

    public static void main(String[] args) {
        System.out.println("Размер массива\t\t\t\tВремя (с)");
        for (int size = 1000; size<15000;size+=1000 ) {
            int[] arr = new int[size];
            int[] SortedArr = new int[size];
            for (int i = 0; i < size; i++) {
                SortedArr[i] = i;
            }
            double s_time = measureTime(SortedArr);
            int[] ReverseSortedArr = new int[size];
            for (int i = 0; i < size; i++) {
                ReverseSortedArr[i] = size - i;
            }
            double r_time = measureTime(ReverseSortedArr);
            for (int i = 0; i < size / 10; i++) {
                int index1 = new Random().nextInt(size);
                int index2 = new Random().nextInt(size);
                int temp = SortedArr[index1];
                SortedArr[index1] = SortedArr[index2];
                SortedArr[index2] = temp;
            }
            double ss_time = measureTime(SortedArr);
            Random random = new Random();
            int[] RandomArray = new int[size];
            for (int i = 0; i < size; i++) {
                RandomArray[i] = random.nextInt(100000);
            }
            double ra_time = measureTime(RandomArray);

            System.out.printf("%-9f", ra_time);
           // System.out.printf("%-20d %-20f %-20f %-20f %-20f%n", size, s_time, r_time, ss_time, ra_time);
        }
    }
}