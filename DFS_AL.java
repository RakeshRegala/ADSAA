import java.util.*;

class DFS_AL {
    static void dfs(List<List<Integer>> adj, boolean[] visited, int node) {
        System.out.print(node + " ");
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(adj, visited, neighbor);
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>()); // Initialize each list
        }

        // Manually adding edges without addAll
        adj.get(0).add(1);
        adj.get(0).add(2);

        adj.get(1).add(0);
        adj.get(1).add(2);

        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(2).add(4);

        adj.get(3).add(2);

        adj.get(4).add(2);

        boolean[] visited = new boolean[n];
        dfs(adj, visited, 0);
    }
}
