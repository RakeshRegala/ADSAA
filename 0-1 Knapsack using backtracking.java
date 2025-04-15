public class SimpleKnapsack {

    static int maxProfit = 0;

    static void solve(int[] weights, int[] values, int capacity, int index, int profit) {
        // If we've considered all items or capacity is 0
        if (index == weights.length) {
            maxProfit = Math.max(maxProfit, profit);
            return;
        }

        // Option 1: Take the item if it fits
        if (weights[index] <= capacity) {
            solve(weights, values, capacity - weights[index], index + 1, profit + values[index]);
        }

        // Option 2: Skip the item
        solve(weights, values, capacity, index + 1, profit);
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4};
        int[] values = {3, 4, 5};
        int capacity = 5;

        solve(weights, values, capacity, 0, 0);
        System.out.println("Maximum Profit: " + maxProfit);
    }
}
