import java.util.Arrays;

class MergeSort {
    static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return; // Base case

        int mid = (left + right) / 2; 
        mergeSort(arr, left, mid);   // Sort left half
        mergeSort(arr, mid + 1, right); // Sort right half
        merge(arr, left, mid, right);   // Merge sorted halves
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int i = left, j = mid + 1, k = 0;
        int[] temp = new int[right - left + 1]; // Temporary array

        // Merge both halves into temp[]
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        // Copy remaining elements
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        // Copy sorted elements back to original array
        for (i = left, k = 0; i <= right; i++, k++)
            arr[i] = temp[k];
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr)); // Output: [5, 6, 7, 11, 12, 13]
    }
}
