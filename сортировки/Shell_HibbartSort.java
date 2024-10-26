import java.util.Random;

public class Shell_HibbartSort {
    public static void HibbardSort(int[] array) {
        int n = array.length;
        int k = 1;
        while ((1 << k) - 1 < n) {
            k++;
        }
        for (int gap = (1 << (k - 1)) - 1; gap > 0; gap = (1 << (--k)) - 1) {
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }


        public static double measureTime(int[] arr) {
        long startTime = System.nanoTime();
            HibbardSort(arr);
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