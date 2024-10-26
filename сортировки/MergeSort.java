import java.util.Random;

public class MergeSort {
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;  // Находим середину массива
            // Рекурсивно сортируем левую половину
            mergeSort(array, left, mid);
            // Рекурсивно сортируем правую половину
            mergeSort(array, mid + 1, right);
            // Сливаем две отсортированные половины
            merge(array, left, mid, right);
        }
    }

    // Метод для слияния двух отсортированных частей массива
    public static void merge(int[] array, int left, int mid, int right) {
        // Определяем размеры двух подмассивов
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Создаем временные массивы для левой и правой части
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Копируем данные во временные массивы
        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        // Индексы для левой части, правой части и основного массива
        int i = 0, j = 0, k = left;

        // Сливаем два временных массива обратно в основной массив
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Копируем оставшиеся элементы левой части, если они есть
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Копируем оставшиеся элементы правой части, если они есть
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }


    public static double measureTime(int[] arr) {
        long startTime = System.nanoTime();
        mergeSort(arr, 0, arr.length - 1);
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