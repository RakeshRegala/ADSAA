import java.util.Scanner;

public class Knapsack{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Objects:");
        int n = sc.nextInt();
        
        int[] p = new int[n];
        int[] w = new int[n];
        
        System.out.println("Enter profits for each object:");
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        
        System.out.println("Enter weights for each object:");
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        
        System.out.println("Enter maximum weight of knapsack:");
        int m = sc.nextInt();
        
        System.out.println("Maximum profit:  "+knapsack(m, w, p, n));
    }

    public static int knapsack(int m, int[] w, int[] p, int n) {
        int[][] k = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    k[i][j] = 0;
                } else if (w[i - 1] <= j) {
                    k[i][j] = Math.max(k[i - 1][j], k[i - 1][j - w[i - 1]] + p[i - 1]);
                } else {
                    k[i][j] = k[i - 1][j];
                }
            }
        }
            return k[n][m];
        }
    }
