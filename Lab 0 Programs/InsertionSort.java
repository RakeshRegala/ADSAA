import java.util.*;

class InsertionSort {

    static void sorting(int[] p, int n) {
        int i, j, item;
        for (i = 1; i < n; i++) {
            item = p[i];
            for (j = i - 1; j >= 0 && p[j] > item; j--) {
                p[j + 1] = p[j];
            }
            p[j + 1] = item;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] A = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        // Call sorting function
        sorting(A, n);

        // Display sorted array
        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(A[i] + "   ");
        }
    }
}
