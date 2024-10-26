import java.util.Random;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Перемещение элементов, которые больше key, на одну позицию вперед
            // от их текущей позиции
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static double measureTime(int[] arr) {
        long startTime = System.nanoTime();
        insertionSort(arr);
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
            System.out.printf("%-10f", s_time);
           // System.out.printf("%-20d %-20f %-20f %-20f %-20f%n", size, s_time, r_time, ss_time, ra_time);
        }
    }
}