import java.util.*;

class QuickSort {
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);  // Sort left part
            quickSort(arr, pivotIndex + 1, high); // Sort right part
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low]; // Choosing first element as pivot
        int i = low + 1, j = high;

        while (i <= j) {
            while (i <= high && arr[i] < pivot) i++;  // Move right if element is smaller than pivot
            while (arr[j] > pivot) j--;  // Move left if element is greater than pivot
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j); // Place pivot at the correct position
        return j;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
