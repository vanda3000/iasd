import java.util.Random;

public class BubbleSort {
    public static void BubbleSort(int[] arr) {
        int n = arr.length; // Получаем длину массива
        // Внешний цикл проходит по всему массиву
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // Переменная для отслеживания изменений в массиве
            // Внутренний цикл сравнивает элементы попарно и меняет их местами, если они расположены в неправильном порядке
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Меняем элементы местами, если текущий элемент больше следующего
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; // Отмечаем, что произошло изменение
                }
            }
            // Если на текущей итерации не произошло обменов, массив уже отсортирован, выходим из цикла
            if (!swapped) {
                break;
            }
        }
    }

    public static double measureTime(int[] arr) {
        long startTime = System.nanoTime();
        BubbleSort(arr);
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