import java.util.Arrays;

class MergeSort {
    static int[] temp; // Temporary array

    static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return; // Base case

        int mid = (left + right) / 2; 
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int i = left, j = mid + 1, k = 0;
        temp = new int[right - left + 1]; // Initialize temp array with correct size

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        // Correctly copy sorted elements back to original array
        for (k = 0; k < temp.length; k++)
            arr[left + k] = temp[k];
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr)); // Output: [5, 6, 7, 11, 12, 13]
    }
}
