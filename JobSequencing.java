import java.util.*;

class JobSequencing {
    
    // Function to perform job sequencing and maximize profit
    static ArrayList<Integer> jobSequencing(int[] id, int[] deadline, int[] profit) {
        int n = id.length;
        ArrayList<Integer> ans = new ArrayList<>(Arrays.asList(0, 0));

        // List to store jobs as {profit, deadline}
        ArrayList<int[]> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new int[]{profit[i], deadline[i]});
        }

        // Sort jobs by profit in descending order
        jobs.sort((a, b) -> b[0] - a[0]);

        // Array to store job slots (-1 indicates empty slot)
        int[] result = new int[n];
        Arrays.fill(result, -1);

        // Schedule jobs
        for (int i = 0; i < n; i++) {
            int start = Math.min(n, jobs.get(i)[1]) - 1;
            for (int j = start; j >= 0; j--) {
                if (result[j] == -1) { // If slot is available
                    result[j] = i;
                    break;
                }
            }
        }

        // Count total jobs completed and compute total profit
        for (int i = 0; i < n; i++) {
            if (result[i] != -1) {
                ans.set(0, ans.get(0) + 1); // Increase job count
                ans.set(1, ans.get(1) + jobs.get(result[i])[0]); // Add profit
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] id = {1, 2, 3, 4, 5};
        int[] deadline = {2, 1, 2, 1, 1};
        int[] profit = {100, 19, 27, 25, 15};

        ArrayList<Integer> ans = jobSequencing(id, deadline, profit);
        System.out.println("Jobs Completed: " + ans.get(0));
        System.out.println("Total Profit: " + ans.get(1));
    }
}
